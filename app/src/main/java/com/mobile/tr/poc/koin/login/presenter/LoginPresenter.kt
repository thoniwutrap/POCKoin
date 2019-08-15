package com.mobile.tr.poc.koin.login.presenter

import android.util.Log
import com.mobile.tr.poc.koin.login.domain.model.LoginRequest
import com.mobile.tr.poc.koin.login.domain.LoginUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LoginPresenter (
    private var view: LoginContract.View?,
    private val loginUseCase: LoginUseCase,
    private val viewModel: LoginViewModel
) : LoginContract.Presenter {


    override fun getUser()  {}

    override fun login() {
        Log.e("d",viewModel.mobileNo)
        loginUseCase.execute(LoginRequest(viewModel.mobileNo, viewModel.password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("login","success")
                },
                onError = {
                    Log.e("login",it.printStackTrace().toString())
                    Log.e("msg",it.message)
                }
            )
    }
}