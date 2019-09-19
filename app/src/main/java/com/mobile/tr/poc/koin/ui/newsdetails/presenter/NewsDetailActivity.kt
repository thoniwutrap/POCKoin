package com.mobile.tr.poc.koin.ui.newsdetails.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.databinding.ActivityNewsDetailBinding
import com.mobile.tr.poc.koin.ui.news.presenter.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailActivity : AppCompatActivity() {

    var position : Int = 0
    val viewModel: NewsViewModel by viewModel()
    var newsDetailbinding: ActivityNewsDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        position = intent.getIntExtra("position",0)

        newsDetailbinding =
            DataBindingUtil.setContentView<ActivityNewsDetailBinding>(this, R.layout.activity_news_detail)
                .apply {
                    newsViewModel = viewModel
                    lifecycleOwner = this@NewsDetailActivity
                }

    }
}
