package com.mobile.tr.poc.koin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.tr.poc.koin.login.presenter.LoginActivity
import com.mobile.tr.poc.koin.vm.VMActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent(this,VMActivity::class.java).apply {
            startActivity(this)
        }
    }
}
