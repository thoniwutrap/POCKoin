package com.mobile.tr.poc.koin.login

import android.util.Log
import com.mobile.tr.poc.koin.login.domain.LoginUseCase
import com.mobile.tr.poc.koin.login.domain.LoginUseCaseImpl
import com.mobile.tr.poc.koin.login.presenter.LoginActivity
import com.mobile.tr.poc.koin.login.presenter.LoginContract
import com.mobile.tr.poc.koin.login.presenter.LoginPresenter
import com.mobile.tr.poc.koin.login.presenter.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val feedModule = module {

    viewModel { LoginViewModel() }

    single <LoginUseCase> { LoginUseCaseImpl(get()) }

    single <LoginContract.Presenter> { (view: LoginContract.View,viewModel : LoginViewModel) -> LoginPresenter(view, get(),viewModel)}

}
