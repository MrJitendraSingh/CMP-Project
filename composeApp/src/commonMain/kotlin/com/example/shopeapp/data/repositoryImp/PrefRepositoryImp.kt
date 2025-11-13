package com.example.shopeapp.data.repositoryImp

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.shopeapp.domain.repository.PrefRepository
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first

class PrefRepositoryImp(
    private val pref: DataStore<Preferences>
) : PrefRepository {

    companion object {
        private val USERNAME_KEY = stringPreferencesKey("username")
        private val PASSWORD_KEY = stringPreferencesKey("password")
    }

    override suspend fun setUsername(username: String) {
        pref.edit { prefs ->
            prefs[USERNAME_KEY] = username
        }
    }

    override suspend fun getUsername(): String {
        val prefs = pref.data.first()
        return prefs[USERNAME_KEY] ?: ""
    }

    override suspend fun setPassword(password: String) {
        pref.edit { prefs ->
            prefs[PASSWORD_KEY] = password
        }
    }

    override suspend fun getPassword(): String {
        val prefs = pref.data.first()
        return prefs[PASSWORD_KEY] ?: ""
    }
}
