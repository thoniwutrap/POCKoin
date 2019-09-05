package com.mobile.tr.poc.koin.ui.login.presenter

import android.util.Log
import com.mobile.tr.poc.koin.RxPresenter
import com.mobile.tr.poc.koin.data.local.query.UserDao
import com.mobile.tr.poc.koin.ui.login.domain.model.LoginRequest
import com.mobile.tr.poc.koin.ui.login.domain.LoginUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LoginPresenter (
    var view: LoginContract.View?,
    var loginUseCase: LoginUseCase,
    var userDao: UserDao,
    var viewModel : LoginViewModel,
    compositeDisposable: CompositeDisposable
) : RxPresenter(compositeDisposable),
    LoginContract.Presenter {


    override fun getUser()  {
        Observable.fromCallable {
            userDao.getUser()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.e("ddd",it[0].accessToken)
            }.addTo(compositeDisposable)
    }

    override fun login() {
        loginUseCase.login(LoginRequest(viewModel.mobileNo, viewModel.password))
            .map {
                userDao.upsert(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("login","ddd")
                },
                onError = {}
            ).addTo(compositeDisposable)
    }
}