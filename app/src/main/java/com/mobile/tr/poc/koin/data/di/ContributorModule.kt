package com.mobile.tr.poc.koin.data.di

import com.mobile.tr.poc.koin.ui.login.loginContributeModule
import com.mobile.tr.poc.koin.ui.news.newsContributeModule
import com.mobile.tr.poc.koin.ui.pincode.pincodeContributeModule

var contributorModule =
    loginContributeModule +
            newsContributeModule +
            pincodeContributeModule+
            preferencesModule
