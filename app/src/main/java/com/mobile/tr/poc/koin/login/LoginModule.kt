package com.mobile.tr.poc.koin.login

import android.util.Log
import com.mobile.tr.poc.koin.login.domain.LoginUseCase
import com.mobile.tr.poc.koin.login.domain.LoginUseCaseImpl
import com.mobile.tr.poc.koin.login.presenter.LoginContract
import com.mobile.tr.poc.koin.login.presenter.LoginPresenter
import com.mobile.tr.poc.koin.login.presenter.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedModule = module {

    factory<LoginUseCase> { LoginUseCaseImpl(get()) }

    factory<LoginContract.Presenter> { (view: LoginContract.View) -> LoginPresenter(view, get(),get())}

    viewModel { LoginViewModel() }
}