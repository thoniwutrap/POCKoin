package com.mobile.tr.poc.koin.login.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobile.tr.poc.koin.LoginAPI
import com.mobile.tr.poc.koin.LoginRequest
import com.mobile.tr.poc.koin.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginContract.View  {

    private val presenter: LoginContract.Presenter by inject { parametersOf(this) }
 // private val repo: LoginAPI by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            presenter.login()
        }
    }
}
