package com.mobile.tr.poc.koin.di

import com.mobile.tr.poc.koin.login.datasource.LoginRepository
import com.mobile.tr.poc.koin.login.datasource.LoginRepositoryImpl
import com.mobile.tr.poc.koin.login.domain.LoginUseCase
import com.mobile.tr.poc.koin.login.domain.LoginUseCaseImpl
import com.mobile.tr.poc.koin.login.presenter.LoginContract
import com.mobile.tr.poc.koin.login.presenter.LoginPresenter
import org.koin.dsl.module

val feedModule = module {

    factory<LoginRepository> { LoginRepositoryImpl(get()) }

    factory<LoginUseCase> { LoginUseCaseImpl(get()) }

    factory<LoginContract.Presenter> { (view: LoginContract.View) -> LoginPresenter(view, get()) }


}