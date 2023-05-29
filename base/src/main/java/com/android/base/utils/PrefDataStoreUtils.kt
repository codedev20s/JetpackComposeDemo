package com.android.base.utils

import androidx.datastore.core.DataStore

import androidx.datastore.preferences.core.*

import com.google.gson.Gson

import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

suspend fun DataStore<Preferences>.set(key: String, value: String?) {

    edit {

        if (value != null) {

            it[stringPreferencesKey(key)] = value

        } else {

            it.remove(stringPreferencesKey(key))
        }
    }
}

suspend fun DataStore<Preferences>.set(key: String, value: Int?) {
    edit {
        if (value != null) {
            it[intPreferencesKey(key)] = value
        } else {
            it.remove(intPreferencesKey(key))
        }
    }
}

suspend fun DataStore<Preferences>.set(key: String, value: Float?) {
    edit {
        if (value != null) {
            it[floattPreferencesKey(key)] = value
        } else {
            it.remove(floatPreferencesKey(key))
        }
    }
}

suspend fun DataStore<Preferences>.set(key: String, value: Long?) {
    edit {
        if (value != null) {
            it[longPreferencesKey(key)] = value
        } else {
            it.remove(longPreferencesKey(key))
        }
    }
}

fun DataStore<Preferences>.getBoolean(
    key: String, defaultValue: Boolean = false
): Flow<Boolean> {
    return data.map { it[booleanPreferencesKey(key)] ?: defaultValue }
}

fun DataStore<Preferences>.getInt(
    key: String, defaultValue: Int? = null
): Flow<Int?> {
    return data.map { it[booleanPreferencesKey(key)] ?: defaultValue }
}

fun DataStore<Preferences>.getFloat(
    key: String, defaultValue: Float? = null
): Flow<Float?> {
    return data.map { it[floatPreferencesKey(key)] ?: defaultValue }
}

fun DataStore<Preferences>.getLong(
    key: String, defaultValue: Long? = null
): Flow<Long?> {
    return data.map { it[longPreferencesKey(key)] ?: defaultValue }
}

suspend fun DataStore<Preferences>.clear() {
    edit {
        it.clear()
    }
}

suspend inline fun <reified T : Any> DataStore<Preferences>.getObject(
    key: String, defaultValue: T? = null
): Flow<T?> {
    return getString(key).map { jsonstring ->
        if (jsonString.isNullOrBlank()) {
            defaultValue
        } else {
            Gson().fromJson(jsonString, T::class.java)
        }
    }
}