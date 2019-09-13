package com.mobile.tr.poc.koin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.tr.poc.koin.ui.news.presenter.NewsActivity
import com.mobile.tr.poc.koin.ui.pincode.PinCodeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent(this,PinCodeActivity::class.java).apply {
            startActivity(this)
        }
    }
}
