package com.example.valumate.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "valumate_preferences")

class DataStoreManager(private val context: Context) {
    val accessTokenKey = stringPreferencesKey("access_token")
    val refreshTokenKey = stringPreferencesKey("refresh_token")
    
    suspend fun saveAccessToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[accessTokenKey] = token
        }
    }

    suspend fun saveRefreshToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[refreshTokenKey] = token
        }
    }

    val accessToken: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[accessTokenKey]
    }

    val refreshToken: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[refreshTokenKey]
    }

    suspend fun clearAll() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
