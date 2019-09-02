package com.mobile.tr.poc.koin

import android.content.SharedPreferences
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mobile.tr.poc.koin.data.di.*
import com.mobile.tr.poc.koin.data.local.entity.User
import com.mobile.tr.poc.koin.data.local.query.UserDao
import com.mobile.tr.poc.koin.login.datasource.network.loginDataSourceNetworkModule
import com.mobile.tr.poc.koin.login.feedModule
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mockito.mock


class SharePreferencesTest : AutoCloseKoinTest() {

    val userDao: UserDao by inject()
    val user = mock(User::class.java)


    @Before
    fun setupTest(){  startKoin {
        androidLogger()
        modules(listOf(appModule,
            networkModule,localModule, feedModule,
            loginDataSourceNetworkModule))
    }

    }

    @Test
    fun exmTest(){
        user.uid = 1
        user.accessToken = "sdf"
        user.refreshToken = "refresh"
        user.tokenType = "B"
        userDao.upsert(user)
        Assert.assertEquals("sdf", user.accessToken)
    }


}