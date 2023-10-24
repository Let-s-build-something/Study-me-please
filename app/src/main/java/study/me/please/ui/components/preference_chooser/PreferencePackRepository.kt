package study.me.please.ui.components.preference_chooser

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.room.PreferencesDao

/** Access to DB for preference packs */
interface PreferencePackRepository {
    val preferencesDao: PreferencesDao

    /** returns preference packs */
    suspend fun getPreferencePacks(): List<SessionPreferencePack> {
        return withContext(Dispatchers.IO) {
            preferencesDao.getAllPreferences().orEmpty()
        }
    }

    /** returns preference packs */
    suspend fun getPreferencePack(uid: String): SessionPreferencePack? {
        return withContext(Dispatchers.IO) {
            preferencesDao.getPreferencePackByUid(uid)
        }
    }

    /** updates preference pack in DB */
    suspend fun savePreferencePack(preferencePack: SessionPreferencePack) {
        withContext(Dispatchers.IO) {
            preferencesDao.insertPreferencePack(preferencePack)
        }
    }

    /** deletes preference pack from DB */
    suspend fun deletePreferencePack(uid: String) {
        withContext(Dispatchers.IO) {
            preferencesDao.deletePreferencePack(uid)
        }
    }
}