package study.me.please.ui.components.preference_chooser

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.preferences.SessionPreferencePack

/** Storage of preference packs */
interface PreferencePackDataManager {
    val preferencePacks: MutableStateFlow<List<SessionPreferencePack>?>
}