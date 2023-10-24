package study.me.please.ui.components.preference_chooser

import study.me.please.data.io.preferences.SessionPreferencePack


/** interface for interacting with preference chooser */
interface PreferenceChooserController {
    fun addPreferencePack(name: String): SessionPreferencePack
    fun savePreference(preference: SessionPreferencePack)
    fun deletePreference(preferenceUid: String)
    fun choosePreference(preference: SessionPreferencePack)
}