package study.me.please.ui.components.preference_chooser

import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.data.io.preferences.SessionPreferencePack

/** controlling unit of preference packs */
interface PreferencePackViewModel {
    val preferencePackDataManager: PreferencePackDataManager
    val preferencePackRepository: PreferencePackRepository
    val preferencePacks: StateFlow<List<SessionPreferencePack>?>

    val coroutineScope: CoroutineScope

    /** Requests a list of preference packs */
    fun requestPreferencePacks() {
        coroutineScope.launch {
            preferencePackDataManager.preferencePacks.value = preferencePackRepository.getPreferencePacks()
        }
    }

    /** updates preference pack in DB */
    fun requestPreferencePackSave(preferencePack: SessionPreferencePack) {
        coroutineScope.launch {
            preferencePackRepository.savePreferencePack(preferencePack.also {
                it.dateModified = DateUtils.now.timeInMillis
            })
        }
    }

    /** creates a new record of preference pack */
    fun addNewPreferencePack(name: String): SessionPreferencePack {
        val newPreferencePack = SessionPreferencePack(name = name)
        coroutineScope.launch {
            preferencePackRepository.savePreferencePack(newPreferencePack)
            preferencePackDataManager.preferencePacks.update {
                it?.toMutableList()?.apply {
                    add(0, newPreferencePack)
                }
            }
        }
        return newPreferencePack
    }

    /**  */
    fun requestPreferencePackDelete(uid: String) {
        coroutineScope.launch {
            preferencePackRepository.deletePreferencePack(uid)
            preferencePackDataManager.preferencePacks.update { preferences ->
                preferences?.toMutableList()?.apply {
                    removeAll { it.uid == uid }
                }
            }
        }
    }
}