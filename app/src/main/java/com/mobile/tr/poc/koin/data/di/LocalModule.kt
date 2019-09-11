package com.mobile.tr.poc.koin.data.di

import android.app.Application
import androidx.room.Room
import com.mobile.tr.poc.koin.data.local.AppDatabase
import com.mobile.tr.poc.koin.data.local.query.UserDao
import com.mobile.tr.poc.koin.ui.news.datasource.local.NewsDao
import org.koin.dsl.module

const val DATABASE_FILE_NAME = "teerap"


val localModule = module {

    single{ provideAppDatabase(get()) }
    single { provideUserDao(get())}
    single { provideGithubUser(get()) }

}

fun provideAppDatabase(application: Application): AppDatabase =
    Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        DATABASE_FILE_NAME)
        .build()


fun provideUserDao(db: AppDatabase): UserDao = db.userDao()
fun provideGithubUser(db: AppDatabase) : NewsDao = db.githubUser()