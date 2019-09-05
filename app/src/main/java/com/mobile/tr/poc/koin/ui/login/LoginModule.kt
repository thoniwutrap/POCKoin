package com.mobile.tr.poc.koin.ui.login

import com.mobile.tr.poc.koin.ui.login.domain.LoginUseCase
import com.mobile.tr.poc.koin.ui.login.domain.LoginUseCaseImpl
import com.mobile.tr.poc.koin.ui.login.presenter.LoginContract
import com.mobile.tr.poc.koin.ui.login.presenter.LoginPresenter
import com.mobile.tr.poc.koin.ui.login.presenter.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedModule = module {

    viewModel { LoginViewModel() }

    single <LoginUseCase> { LoginUseCaseImpl(get()) }

    single <LoginContract.Presenter> { (view: LoginContract.View,viewModel : LoginViewModel) -> LoginPresenter(view, get(),get(),viewModel,get())}


}
