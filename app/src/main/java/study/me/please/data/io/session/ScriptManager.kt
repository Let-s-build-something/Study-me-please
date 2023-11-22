package study.me.please.data.io.session

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.PsychologyTerm

class ScriptManager(private var prompts: List<PsychologyTerm>) {
    var index: Int = 0
    private var stack = mutableListOf<PsychologyTerm>()

    suspend fun getNewPrompt(): PsychologyTerm? {
        if(++index >= stack.size) {
            flush()
        }
        return stack.getOrNull(index)
    }

    private suspend fun randomise() {
        withContext(Dispatchers.Default) {
            stack = prompts.toMutableList().distinctBy {
                it.isRepeated = false
                it.uid
            }.shuffled().toMutableList()
        }
    }

    fun injectToPosition(term: PsychologyTerm, index: Int, force: Boolean = false) {
        val newIndex = this.index.plus(index)
        term.isRepeated = true
        if(newIndex < stack.size) {
            stack.add(newIndex, term)
        }else if(force) {
            stack.add(term)
        }
    }

    val size: Int
        get() = stack.size

    suspend fun flush(newList: List<PsychologyTerm>? = null) {
        newList?.let {
            prompts = it
        }
        index = -1
        randomise()
    }
}