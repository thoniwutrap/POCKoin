package com.mobile.tr.poc.koin.login.presenter

import android.util.Log
import com.mobile.tr.poc.koin.RxPresenter
import com.mobile.tr.poc.koin.login.domain.model.LoginRequest
import com.mobile.tr.poc.koin.login.domain.LoginUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LoginPresenter (
     var view: LoginContract.View?,
     var loginUseCase: LoginUseCase,
     var viewModel : LoginViewModel,
     compositeDisposable: CompositeDisposable
) : RxPresenter(compositeDisposable),
    LoginContract.Presenter {


    override fun getUser()  {}

    override fun login() {
        loginUseCase.login(LoginRequest(viewModel.mobileNo, viewModel.password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("login","success")
                },
                onError = {}
            ).addTo(compositeDisposable)
    }
}