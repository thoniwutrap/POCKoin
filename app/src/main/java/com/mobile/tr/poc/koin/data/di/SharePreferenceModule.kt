package com.mobile.tr.poc.koin.data.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module


val preferencesModule = module {
    single(named("settingsPrefs")) { provideSettingsPreferences(androidApplication()) }
    single<SharedPreferences.Editor> {
        provideSettingsPreferences(androidApplication()).edit()
    }
}


private const val PREFERENCES_FILE_KEY = "com.example.settings_preferences"

private fun provideSettingsPreferences(app: Application): SharedPreferences =
    app.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)