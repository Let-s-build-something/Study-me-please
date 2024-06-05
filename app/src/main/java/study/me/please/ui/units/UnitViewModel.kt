package study.me.please.ui.units

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.FactIO
import study.me.please.data.io.UnitElement
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.shared.SharedDataManager
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class UnitViewModel @Inject constructor(
    private val repository: UnitsRepository,
    private val dataManager: UnitDataManager,
    val clipBoard: GeneralClipBoard,
    private val sharedDataManager: SharedDataManager
): BaseViewModel() {

    init {
        viewModelScope.launch {
            clipBoard.initialize()
        }
    }

    /** specific unit for this viewmodel */
    var currentUnit: UnitIO? = null

    /** current backstack of elements to be displayed */
    val elements = dataManager.elements.asStateFlow()

    /** list of all collapsed paragraphs */
    val collapsedParagraphs = dataManager.collapsedParagraphs.asStateFlow()

    /** currently dragged element with its source information including index ([Pair.second]) */
    val localStateElement = MutableStateFlow<Pair<UnitElement, Int>?>(null)

    /** Collapses paragraph and its children */
    suspend fun collapseParagraph(index: Int, onSelectionRequest: (String) -> Unit) {
        withContext(Dispatchers.Default) {
            val element = dataManager.elements.value.getOrNull(index) ?: return@withContext
            if(dataManager.collapsedParagraphs.value.contains(element.uid)) return@withContext

            dataManager.elements.update { list ->
                val newList = list.toMutableList()
                val layerToRemove = list.getOrNull(index)?.layer ?: return@withContext
                for (i in index.plus(1) until list.size) {
                    val item = list.getOrNull(i) ?: break
                    if(item.layer > layerToRemove || (item.layer == layerToRemove && item !is UnitElement.Paragraph)) {
                        newList.remove(item)
                    }else break
                }
                newList
            }
            dataManager.collapsedParagraphs.update {
                it.plus(element.uid)
            }
            currentUnit?.collapsedParagraphs = collapsedParagraphs.value
            repository.updateUnit(currentUnit ?: return@withContext)

            // we want to iterate up to find higher layer -> such item is the parent
            for(i in index.minus(1) downTo 0) {
                val itemAbove = dataManager.elements.value.getOrNull(i) ?: continue

                if (itemAbove.uid != element.uid
                    && itemAbove.layer <= element.layer
                    && collapsedParagraphs.value.contains(itemAbove.uid).not()
                ) {
                    if(itemAbove is UnitElement.Paragraph) {
                        onSelectionRequest(itemAbove.data.uid)
                        return@withContext
                    }else continue
                }
            }
            onSelectionRequest("NaN")
        }
    }

    /** Collapses paragraph and its children */
    suspend fun expandParagraph(index: Int) {
        withContext(Dispatchers.Default) {
            val newElements = mutableListOf<UnitElement>()
            val paragraph = dataManager.elements.value.getOrNull(index) as? UnitElement.Paragraph ?: return@withContext
            val notLastLayers = paragraph.notLastLayers.toMutableList()

            if(collapsedParagraphs.value.contains(paragraph.data.uid).not()) return@withContext


            // unit facts with their nested facts
            paragraph.data.facts.forEach { paragraphFact ->
                newElements.addAll(
                    listOf(paragraphFact).plus(paragraphFact.facts).mapIndexed { index, fact ->
                        UnitElement.Fact(
                            data = fact,
                            innerIndex = index,
                            isNested = fact.uid != paragraphFact.uid,
                            isLast = paragraphFact.facts.lastOrNull()?.uid == fact.uid,
                            layer = paragraph.layer,
                            notLastLayers = notLastLayers,
                            isLastParagraph = paragraph.data.paragraphs.isEmpty(),
                            parentUid = paragraph.data.uid
                        )
                    }
                )
            }

            iterateFurtherAction(
                paragraphs = paragraph.data.paragraphs,
                layer = paragraph.layer.plus(1),
                action = { iterationParagraph, layer, _, isLast, notLastLayers2 ->
                    val newList = notLastLayers.toMutableList().apply {
                        addAll(notLastLayers2)
                        if(isLast.not()) add(layer)
                    }

                    newElements.add(
                        UnitElement.Paragraph(
                            data = iterationParagraph,
                            notLastLayers = newList,
                            layer = layer
                        )
                    )

                    val isNotCollapsed = collapsedParagraphs.value.contains(iterationParagraph.uid).not()

                    if(iterationParagraph.factUidList.isNotEmpty() && isNotCollapsed) {
                        iterationParagraph.facts.forEachIndexed { index, paragraphFact ->
                            newElements.addAll(
                                listOf(paragraphFact).plus(paragraphFact.facts).map { fact ->
                                    UnitElement.Fact(
                                        data = fact,
                                        layer = layer,
                                        isNested = fact.uid != paragraphFact.uid,
                                        isLast = paragraphFact.facts.lastOrNull()?.uid == fact.uid,
                                        innerIndex = index,
                                        notLastLayers = newList,
                                        isLastParagraph = iterationParagraph.paragraphs.isEmpty(),
                                        parentUid = iterationParagraph.uid
                                    )
                                }
                            )
                        }
                    }
                    isNotCollapsed to newList
                }
            )

            dataManager.elements.update {
                it.toMutableList().apply {
                    addAll(index.plus(1), newElements.filter { element -> element !in this })
                }
            }
            dataManager.collapsedParagraphs.update {
                it.toMutableList().apply {
                    removeIf { item -> item == paragraph.data.uid }
                }
            }
            currentUnit?.collapsedParagraphs = collapsedParagraphs.value
            repository.updateUnit(currentUnit ?: return@withContext)
        }
    }

    /** Expands all paragraphs within this unit until the specified */
    suspend fun expandUntil(path: FocusedUnitElement) {
        withContext(Dispatchers.Default) {
            path.elementPath.forEach { uid ->
                dataManager.elements.value.indexOfFirst { it.uid == uid }.takeIf { it != -1 }?.let {
                    expandParagraph(it)
                }
            }
        }
    }

    /** Cancels drag and drop if there was any */
    fun cancelDragAndDrop() {
        if(localStateElement.value == null) return
        if(localStateElement.value?.second == -1) localStateElement.value = null

        localStateElement.value?.let { value ->
            val newValue = value.first to value.second
            localStateElement.value = null

            viewModelScope.launch {
                dataManager.elements.update {
                    it.toMutableList().apply {
                        add(newValue.second, newValue.first)
                    }
                }
                expandParagraph(newValue.second)
            }
        }
    }

    /** Saves scroll position of the current layout */
    fun saveScrollPosition(
        firstVisibleItemIndex: Int,
        firstVisibleItemOffset: Int
    ) {
        viewModelScope.launch {
            currentUnit?.firstVisibleItemIndex = firstVisibleItemIndex
            currentUnit?.firstVisibleItemOffset = firstVisibleItemOffset
            repository.updateUnit(currentUnit ?: return@launch)
        }
    }

    /**
     * Called when drag event is ended
     *
     * Meaning of this function is to save changes into the DB - both removal and adding and add item into [elements]
     */
    fun onDragEnded(
        element: UnitElement,
        targetIndex: Int,
        requestRefresh: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.Default) {
            currentUnit?.let { unit ->
                if(dataManager.elements.value.any { it.uid == element.uid }) return@launch

                val isNewElement = localStateElement.value?.second == -1
                val isSafeToAdd = if(isNewElement) true else requestElementRemoval(elementUid = element.uid)
                Log.d("kostka_test", "onDragEnded, isSafeToAdd: $isSafeToAdd")
                if(isSafeToAdd) {
                    requestElementAdd(
                        unit = unit,
                        element = element,
                        targetIndex = targetIndex,
                        isNewElement = isNewElement
                    )
                }
                dataManager.elements.update {
                    it.toMutableList().apply {
                        add(targetIndex.coerceIn(0, this.size), element)
                    }
                }
                expandParagraph(targetIndex)

                requestRefresh()
                requestElements()
            }
            localStateElement.value = null
        }
    }

    /** iterates through whole unit in order to remove any element by its uid */
    suspend fun requestElementRemoval(
        elementUid: String,
        delete: Boolean = false
    ): Boolean {
        return withContext(Dispatchers.Default) {
            var result = false

            val onNestedRemoved: suspend (FactIO) -> Unit = { parent: FactIO ->
                repository.updateFact(parent)
                result = true
            }

            currentUnit?.let { unit ->
                if(unit.removeParagraph(elementUid)) {
                    repository.updateUnit(unit)
                    if(delete) repository.deleteParagraph(elementUid)

                    if(delete) {
                        updateFirebaseUnit(unit)
                    }
                    return@withContext true
                }
                if(unit.removeFact(elementUid, onNestedRemoved = onNestedRemoved)) {
                    repository.updateUnit(unit)
                    if(delete) repository.deleteFact(elementUid)

                    if(delete) {
                        updateFirebaseUnit(unit)
                    }
                    return@withContext true
                }

                iterateFurtherAction(
                    unit.paragraphs,
                    action = { paragraph, _, _, _, _ ->
                        if(paragraph.removeParagraph(elementUid)) {
                            repository.updateParagraph(paragraph)
                            dataManager.elements.update { update ->
                                update.toMutableList().apply {
                                    (find { it.uid == paragraph.uid } as? UnitElement.Paragraph)?.data?.updateTO(paragraph)
                                }
                            }

                            result = true
                            if(delete) {
                                repository.deleteParagraph(elementUid)
                                updateFirebaseUnit(unit)
                            }
                            return@iterateFurtherAction false to mutableListOf()
                        }
                        if(paragraph.removeFact(elementUid, onNestedRemoved = onNestedRemoved)) {
                            repository.updateParagraph(paragraph)
                            dataManager.elements.update { update ->
                                update.toMutableList().apply {
                                    (find { it.uid == paragraph.uid } as? UnitElement.Paragraph)?.data?.updateTO(paragraph)
                                }
                            }

                            result = true
                            if(delete) {
                                repository.deleteFact(elementUid)
                                updateFirebaseUnit(unit)
                            }
                            return@iterateFurtherAction false to mutableListOf()
                        }
                        result.not() to mutableListOf()
                    }
                )
            }

            Log.d("kostka_test", "requestElementRemoval, result: $result")
            result
        }
    }

    private fun updateFirebaseUnit(unit: UnitIO) {
        if(sharedDataManager.currentUser.value == null) return
        viewModelScope.launch {
            repository.updateFirebaseUnit(
                unit = unit,
                collectionUid = unit.collectionUid
            )
        }
    }

    /** iterates through whole unit in order to add any element by parent uid */
    private suspend fun requestElementAdd(
        unit: UnitIO?,
        element: UnitElement,
        targetIndex: Int,
        isNewElement: Boolean
    ): Boolean {
        if(unit == null) return false

        return withContext(Dispatchers.Default) {

            Log.d("kostka_test", "requestElementAdd, targetIndex: $targetIndex")
            // we want to iterate up to find higher layer -> such item is the parent
            for(index in targetIndex.minus(1) downTo 0) {
                val itemAbove = dataManager.elements.value.getOrNull(index) ?: continue

                Log.d("kostka_test", "requestElementAdd, itemAbove: ${(itemAbove as? UnitElement.Paragraph)?.data?.name}")
                if(itemAbove.uid != element.uid && itemAbove.layer <= element.layer) {
                    (itemAbove as? UnitElement.Paragraph ?: continue).run {
                        when(element) {
                            is UnitElement.Paragraph -> {
                                data.addParagraph(
                                    0, //always on top, refactor if changed
                                    element.data
                                )
                                if(isNewElement) repository.updateParagraph(element.data)
                            }
                            is UnitElement.Fact -> {
                                val indexWithin = data.facts.indexOfFirst {
                                    it.uid == elements.value.getOrNull(targetIndex - 1)?.uid
                                }
                                var result = false
                                itemAbove.data.facts.toList().forEachIndexed { factIndex, fact ->
                                    fact.facts.toList().forEachIndexed { nestedFactIndex, _ ->
                                        if(element.isNested && index + nestedFactIndex + factIndex + 2 == targetIndex) {
                                            result = true
                                            data.addFact(
                                                index = factIndex,
                                                nestedIndex = nestedFactIndex,
                                                fact = element.data,
                                                isNested = true
                                            )
                                        }
                                    }
                                    // nested index still within + 1, otherwise not
                                    val additionalIndex = (if(element.isNested) 2 else 1)
                                    if(result.not() && factIndex + index + additionalIndex == targetIndex) {
                                        result = true
                                        data.addFact(
                                            index = factIndex,
                                            fact = element.data,
                                            isNested = element.isNested
                                        )
                                    }
                                }
                                // in case of adding something to the very end
                                if(result.not()) {
                                    data.addFact(
                                        index = data.facts.size,
                                        fact = element.data,
                                        isNested = false // it cannot be nested, as the index does not match any fact
                                    )
                                }

                                if (isNewElement) {
                                    repository.updateFact(element.data)
                                }
                                if(element.isNested) {
                                    data.facts.getOrNull(indexWithin)?.let { fact ->
                                        repository.updateFact(fact)
                                    }
                                }
                            }
                        }
                        repository.updateParagraph(data)
                    }

                    updateFirebaseUnit(unit)
                    return@withContext true
                }
            }

            // after we iterated above and found nothing
            if(element.layer == INITIAL_LAYER) {
                if(element is UnitElement.Paragraph) {
                    unit.addParagraph(targetIndex, element.data)
                }
                if(element is UnitElement.Fact) {
                    unit.addFact(
                        targetIndex - 1,
                        element.data,
                        isNested = element.isNested
                    )
                    if(isNewElement) repository.updateFact(element.data)
                    if (element.isNested) {
                        unit.facts.getOrNull(targetIndex - 1)?.let { fact ->
                            repository.updateFact(fact)
                        }
                    }
                }
                repository.updateUnit(unit)

                updateFirebaseUnit(unit)
                return@withContext true
            }

            false
        }
    }

    /** removes an element from elements at certain [element] */
    fun removeElement(element: UnitElement, onSelectionRequest: (String) -> Unit) {
        viewModelScope.launch {
            dataManager.elements.value
                .indexOfFirst { it.uid == element.uid }
                .takeIf { it != -1 }
                ?.let { index ->
                    dataManager.elements.update { toUpdate ->
                    toUpdate.toMutableList().apply {
                        when (element) {
                            is UnitElement.Paragraph -> {
                                collapseParagraph(index, onSelectionRequest = onSelectionRequest)
                                removeAt(index)
                            }
                            is UnitElement.Fact -> {
                                if(element.data.facts.isNotEmpty()) {
                                    removeAll { toRemove ->
                                        toRemove.uid == element.uid || element.data.facts.any {
                                            it.uid == toRemove.uid
                                        }
                                    }
                                }else removeAt(index)
                            }
                        }
                    }
                }
            }
        }
    }

    /** Updates specific paragraph within this unit */
    fun updateParagraph(paragraph: ParagraphIO) {
        viewModelScope.launch {
            var result = false

            currentUnit?.let { unit ->
                iterateFurtherAction(
                    paragraphs = unit.paragraphs,
                    action = { iteratedParagraph, _, _, _, _ ->
                        if(iteratedParagraph.uid == paragraph.uid) {
                            iteratedParagraph.updateTO(paragraph)
                            result = true
                        }
                        result.not() to mutableListOf()
                    }
                )

                repository.updateParagraph(paragraph)

                dataManager.elements.update { update ->
                    update.apply {
                        (find { it.uid == paragraph.uid } as? UnitElement.Paragraph)?.data?.updateTO(paragraph)
                    }
                }
                updateFirebaseUnit(unit)
            }
        }
    }

    /** Updates specific fact */
    fun updateFact(fact: FactIO) {
        viewModelScope.launch(Dispatchers.Default) {
            currentUnit?.let { unit ->
                var result = false

                unit.facts.find { it.uid == fact.uid }?.updateTO(fact)
                iterateFurtherAction(
                    paragraphs = unit.paragraphs,
                    action = { paragraph, _, _, _, _ ->
                        paragraph.facts.find { it.uid == fact.uid }?.run {
                            updateTO(fact)
                            result = true
                        }
                        result.not() to mutableListOf()
                    }
                )

                repository.updateFact(fact)

                dataManager.elements.update { update ->
                    update.apply {
                        (find { it.uid == fact.uid } as? UnitElement.Fact)?.data?.updateTO(fact)
                    }
                }
                updateFirebaseUnit(unit)
            }
        }
    }

    /** Makes a request to return all elements within current unit */
    fun requestElements() {
        currentUnit?.let { unit ->
            dataManager.collapsedParagraphs.value = unit.collapsedParagraphs

            viewModelScope.launch(Dispatchers.Default) {
                val newElements = mutableListOf<UnitElement>()

                // unit facts with their nested facts
                // each unit fact is separated by their nested facts, as those are nested in the verticalGrid
                if(unit.factUidList.isNotEmpty()) {
                    unit.facts.forEach { unitFact ->
                        newElements.addAll(
                            listOf(unitFact).plus(unitFact.facts).mapIndexed { index, fact ->
                                UnitElement.Fact(
                                    data = fact,
                                    innerIndex = index,
                                    isNested = fact.uid != unitFact.uid,
                                    isLast = unitFact.facts.lastOrNull()?.uid == fact.uid,
                                    layer = INITIAL_LAYER,
                                    notLastLayers = listOf(),
                                    isLastParagraph = true,
                                    parentUid = unit.uid
                                )
                            }
                        )
                    }
                }
                if(unit.paragraphUidList.isNotEmpty()) {
                    iterateFurtherAction(
                        paragraphs = unit.paragraphs,
                        layer = INITIAL_LAYER,
                        action = { iterationParagraph, layer, _, isLast, notLastLayers ->
                            val newList = notLastLayers.toMutableList().apply {
                                if(isLast.not()) add(layer)
                            }

                            // add category paragraph
                            newElements.add(
                                UnitElement.Paragraph(
                                    data = iterationParagraph,
                                    notLastLayers = newList,
                                    layer = layer
                                )
                            )

                            val isNotCollapsed = collapsedParagraphs.value.contains(iterationParagraph.uid).not()

                            // elements are UI representation of the data - we want only visible ones
                            if(iterationParagraph.factUidList.isNotEmpty() && isNotCollapsed) {
                                iterationParagraph.facts.forEachIndexed { index, paragraphFact ->
                                    newElements.addAll(
                                        listOf(paragraphFact).plus(paragraphFact.facts).map { fact ->
                                            UnitElement.Fact(
                                                data = fact,
                                                layer = layer,
                                                isNested = fact.uid != paragraphFact.uid,
                                                isLast = paragraphFact.facts.lastOrNull()?.uid == fact.uid,
                                                // the index within this paragraph - facts are one column
                                                innerIndex = index,
                                                notLastLayers = newList,
                                                isLastParagraph = iterationParagraph.paragraphs.isEmpty(),
                                                parentUid = iterationParagraph.uid
                                            )
                                        }
                                    )
                                }
                            }
                            isNotCollapsed to newList
                        }
                    )
                }

                dataManager.elements.value = newElements.distinctBy { it.uid }
            }
        }
    }

    /** requests for a paragraph */
    fun requestParagraph(uid: String) {
        viewModelScope.launch {
            currentUnit = UnitIO(paragraphUidList = mutableListOf(uid), collectionUid = "").also { unit ->
                unit.paragraphs.addAll(
                    repository.getParagraphsBy(unit.paragraphUidList).orEmpty().sortedBy {
                        unit.paragraphUidList.indexOf(it.uid)
                    }.onEach { paragraph ->
                        if(paragraph.factUidList.isNotEmpty()) {
                            paragraph.facts.clear()
                            paragraph.facts.addAll(
                                repository.getFactsBy(paragraph.factUidList).orEmpty().sortedBy {
                                    paragraph.factUidList.indexOf(it.uid)
                                }
                            )
                        }
                        if(paragraph.paragraphUidList.isNotEmpty()) {
                            paragraph.paragraphs.clear()
                            paragraph.paragraphs.addAll(
                                repository.getParagraphsBy(paragraph.paragraphUidList)?.sortedBy {
                                    paragraph.factUidList.indexOf(it.uid)
                                }.orEmpty()
                            )
                        }

                        iterateFurtherAction(paragraph) { iterationParagraph ->
                            if(iterationParagraph.factUidList.isNotEmpty()) {
                                iterationParagraph.facts.clear()
                                iterationParagraph.facts.addAll(
                                    repository.getFactsBy(iterationParagraph.factUidList).orEmpty().sortedBy {
                                        iterationParagraph.factUidList.indexOf(it.uid)
                                    }
                                )
                            }
                            if(iterationParagraph.paragraphUidList.isNotEmpty()) {
                                iterationParagraph.paragraphs.clear()
                                iterationParagraph.paragraphs.addAll(
                                    repository.getParagraphsBy(iterationParagraph.paragraphUidList)?.sortedBy {
                                        iterationParagraph.factUidList.indexOf(it.uid)
                                    }.orEmpty()
                                )
                            }
                        }
                    }
                )
            }
            requestElements()
        }
    }

    /** iterates into all possible depths */
    private suspend fun iterateIntoParagraph(
        paragraph: ParagraphIO,
        layer: Int = 0,
        notLastLayers: List<Int> = listOf(),
        action: suspend (
            ParagraphIO,
            layer: Int,
            index: Int,
            isLast: Boolean,
            notLastLayers: List<Int>
        ) -> Pair<Boolean, MutableList<Int>>
    ) {
        withContext(Dispatchers.Default) {
            val paragraphsCopy = paragraph.paragraphs.toList()
            paragraphsCopy.forEachIndexed { index, iterationParagraph ->
                val actionResult = action(iterationParagraph, layer, index, index == paragraphsCopy.lastIndex, notLastLayers)
                if(actionResult.first) {
                    iterateIntoParagraph(
                        paragraph = iterationParagraph,
                        action = action,
                        layer = layer.plus(1),
                        notLastLayers = actionResult.second
                    )
                }
            }
            paragraph.paragraphs = paragraphsCopy.toMutableList()
        }
    }

    /** iterates into all possible depths */
    private suspend fun iterateFurtherAction(
        paragraphs: List<ParagraphIO>,
        layer: Int = INITIAL_LAYER,
        notLastLayers: List<Int> = listOf(),
        action: suspend (
            ParagraphIO,
            layer: Int,
            index: Int,
            isLast: Boolean,
            notLastLayers: List<Int>
        ) -> Pair<Boolean, MutableList<Int>>
    ) {
        paragraphs.forEachIndexed { index, paragraph ->
            val actionResult = action(paragraph, layer, index, index == paragraphs.lastIndex, notLastLayers)
            if(actionResult.first) {
                iterateIntoParagraph(paragraph, layer.plus(1), action = action, notLastLayers = actionResult.second)
            }
        }
    }

    /** iterates into all possible depths */
    private suspend fun iterateFurtherAction(
        paragraph: ParagraphIO,
        action: suspend (ParagraphIO) -> Unit
    ) {
        withContext(Dispatchers.Default) {
            val paragraphsCopy = paragraph.paragraphs.toList()
            paragraphsCopy.forEach { iterationParagraph ->
                action(iterationParagraph)
                iterateFurtherAction(
                    paragraph = iterationParagraph,
                    action = action,
                )
            }
            paragraph.paragraphs = paragraphsCopy.toMutableList()
        }
    }

    companion object {
        /** layer of the first items within Unit */
        const val INITIAL_LAYER = -1
    }
}