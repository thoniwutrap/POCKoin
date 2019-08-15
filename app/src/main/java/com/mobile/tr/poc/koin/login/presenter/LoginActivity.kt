package com.mobile.tr.poc.koin.login.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginContract.View  {


    private val viewModel : LoginViewModel by viewModel()
    private val presenter: LoginContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        binding.loginViewModel = viewModel


        btnLogin.setOnClickListener {
            Log.e("ff",viewModel.mobileNo)
            presenter.login()
        }
    }
}
