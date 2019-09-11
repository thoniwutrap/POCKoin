package com.mobile.tr.poc.koin.data.di

import com.mobile.tr.poc.koin.ui.news.githubContributeModule
import com.mobile.tr.poc.koin.ui.login.loginContributeModule

var contributorModule =
    loginContributeModule +
        preferencesModule +
            githubContributeModule