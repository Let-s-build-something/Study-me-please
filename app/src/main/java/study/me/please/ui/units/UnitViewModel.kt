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
import study.me.please.ui.units.CollectionUnitsViewModel.ScrollToElement
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class UnitViewModel @Inject constructor(
    private val repository: UnitsRepository,
    private val dataManager: UnitDataManager,
    val clipBoard: GeneralClipBoard
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
    suspend fun collapseParagraph(index: Int) {
        withContext(Dispatchers.Default) {
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
                it.plus(dataManager.elements.value.getOrNull(index)?.uid ?: return@withContext)
            }
            currentUnit?.collapsedParagraphs = collapsedParagraphs.value
            repository.updateUnit(currentUnit ?: return@withContext)
        }
    }

    /** Collapses paragraph and its children */
    suspend fun expandParagraph(index: Int) {
        withContext(Dispatchers.Default) {
            val newElements = mutableListOf<UnitElement>()
            val paragraph = dataManager.elements.value.getOrNull(index) as? UnitElement.Paragraph ?: return@withContext
            val notLastLayers = paragraph.notLastLayers.toMutableList()

            if(collapsedParagraphs.value.contains(paragraph.data.uid).not()) return@withContext


            newElements.addAll(
                paragraph.data.facts.map { fact ->
                    UnitElement.Fact(
                        data = fact,
                        layer = paragraph.layer,
                        notLastLayers = notLastLayers,
                        isLastParagraph = paragraph.data.paragraphs.isEmpty(),
                        parentUid = paragraph.data.uid
                    )
                }
            )

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

                    if(iterationParagraph.factUidList.isNotEmpty()) {
                        if(isNotCollapsed) {
                            newElements.addAll(iterationParagraph.facts.map { fact ->
                                UnitElement.Fact(
                                    data = fact,
                                    layer = layer,
                                    notLastLayers = newList,
                                    isLastParagraph = iterationParagraph.paragraphs.isEmpty(),
                                    parentUid = iterationParagraph.uid
                                )
                            })
                        }
                    }
                    isNotCollapsed to newList
                }
            )

            /*iterateFurtherAction(
                paragraphs = paragraph.data.paragraphs,
                layer = paragraph.layer.plus(1),
                action = { iterationParagraph, layer, _, isLast ->
                    newElements.add(
                        UnitElement.Paragraph(
                            data = iterationParagraph,
                            notLastLayers = notLastLayers.toMutableList().apply {
                                if(isLast.not()) add(layer)
                            },
                            layer = layer
                        )
                    )

                    val isNotCollapsed = collapsedParagraphs.value.contains(iterationParagraph.uid).not()

                    if(isNotCollapsed) {
                        newElements.addAll(iterationParagraph.facts.map { fact ->
                            UnitElement.Fact(
                                data = fact,
                                layer = layer,
                                notLastLayers = notLastLayers,
                                isLastParagraph = iterationParagraph.paragraphs.isEmpty(),
                                parentUid = iterationParagraph.uid
                            )
                        })
                    }
                    isNotCollapsed to mutableListOf()
                }
            )*/
            dataManager.elements.update {
                it.toMutableList().apply {
                    addAll(index.plus(1), newElements)
                }
            }
            dataManager.collapsedParagraphs.update {
                it.toMutableList().apply {
                    remove(paragraph.data.uid)
                }
            }
            currentUnit?.collapsedParagraphs = collapsedParagraphs.value
            repository.updateUnit(currentUnit ?: return@withContext)
        }
    }

    /** Expands all paragraphs within this unit until the specified */
    suspend fun expandUntil(path: ScrollToElement) {
        withContext(Dispatchers.Default) {
            path.elementUidList.forEach { uid ->
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
        viewModelScope.launch {
            currentUnit?.let { unit ->
                val isNewElement = localStateElement.value?.second == -1
                val isSafeToAdd = if(isNewElement) true else requestElementRemoval(elementUid = element.uid)
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

            currentUnit?.let { unit ->
                if(unit.removeParagraph(elementUid)) {
                    repository.updateUnit(unit)
                    if(delete) repository.deleteParagraph(elementUid)
                    return@withContext true
                }
                if(unit.removeFact(elementUid)) {
                    repository.updateUnit(unit)
                    if(delete) repository.deleteFact(elementUid)
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
                            if(delete) repository.deleteParagraph(elementUid)

                            result = true
                            return@iterateFurtherAction false to mutableListOf()
                        }
                        if(paragraph.removeFact(elementUid)) {
                            repository.updateParagraph(paragraph)
                            dataManager.elements.update { update ->
                                update.toMutableList().apply {
                                    (find { it.uid == paragraph.uid } as? UnitElement.Paragraph)?.data?.updateTO(paragraph)
                                }
                            }
                            if(delete) repository.deleteFact(elementUid)

                            result = true
                            return@iterateFurtherAction false to mutableListOf()
                        }
                        result.not() to mutableListOf()
                    }
                )
            }

            result
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

            // we want to iterate up to find higher layer -> such item is the parent
            for(index in targetIndex.minus(1) downTo 0) {
                val itemAbove = dataManager.elements.value.getOrNull(index) ?: continue

                Log.d("kostka_test", "requestElementAdd, itemAbove: ${(itemAbove as? UnitElement.Paragraph)?.data?.name}")
                if(itemAbove.uid != element.uid && itemAbove.layer <= element.layer) {
                    (itemAbove as? UnitElement.Paragraph ?: continue).run {
                        val indexWithin = targetIndex - index - 1

                        when(element) {
                            is UnitElement.Paragraph -> {
                                data.addParagraph(
                                    indexWithin.minus(itemAbove.data.facts.size),
                                    element.data
                                )
                                if(isNewElement) repository.updateParagraph(element.data)
                            }
                            is UnitElement.Fact -> {
                                data.addFact(
                                    indexWithin,
                                    element.data
                                )
                                if(isNewElement) repository.updateFact(element.data)
                            }
                        }
                        repository.updateParagraph(data)
                    }

                    return@withContext true
                }
            }

            // after we iterated above and found nothing
            if(element.layer == INITIAL_LAYER) {
                if(element is UnitElement.Paragraph) {
                    unit.addParagraph(targetIndex, element.data)
                }
                if(element is UnitElement.Fact) {
                    unit.addFact(targetIndex, element.data)
                }
                repository.updateUnit(unit)
                return@withContext true
            }

            false
        }
    }

    /** removes an element from elements at certain [index] */
    fun removeElement(index: Int) {
        viewModelScope.launch {
            dataManager.elements.value.getOrNull(index)?.let { element ->
                if(element is UnitElement.Paragraph) {
                    collapseParagraph(index)
                }
                dataManager.elements.update {
                    it.toMutableList().apply {
                        removeAt(index)
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
            }
        }
    }

    /** Makes a request to return all elements within current unit */
    fun requestElements() {
        currentUnit?.let { unit ->
            dataManager.collapsedParagraphs.value = unit.collapsedParagraphs

            viewModelScope.launch(Dispatchers.Default) {
                val newElements = mutableListOf<UnitElement>()

                if(unit.factUidList.isNotEmpty()) {
                    newElements.addAll(unit.facts.map { fact ->
                        UnitElement.Fact(
                            data = fact,
                            layer = INITIAL_LAYER,
                            notLastLayers = listOf(),
                            isLastParagraph = true,
                            parentUid = unit.uid
                        )
                    })
                }
                if(unit.paragraphUidList.isNotEmpty()) {
                    iterateFurtherAction(
                        paragraphs = unit.paragraphs,
                        layer = INITIAL_LAYER,
                        action = { iterationParagraph, layer, _, isLast, notLastLayers ->
                            val newList = notLastLayers.toMutableList().apply {
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

                            if(iterationParagraph.factUidList.isNotEmpty()) {
                                if(isNotCollapsed) {
                                    newElements.addAll(iterationParagraph.facts.map { fact ->
                                        UnitElement.Fact(
                                            data = fact,
                                            layer = layer,
                                            notLastLayers = newList,
                                            isLastParagraph = iterationParagraph.paragraphs.isEmpty(),
                                            parentUid = iterationParagraph.uid
                                        )
                                    })
                                }
                            }
                            isNotCollapsed to newList
                        }
                    )
                }

                dataManager.elements.value = newElements
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