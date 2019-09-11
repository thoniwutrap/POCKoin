package com.mobile.tr.poc.koin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.tr.poc.koin.ui.news.presenter.NewsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent(this,NewsActivity::class.java).apply {
            startActivity(this)
        }
    }
}
