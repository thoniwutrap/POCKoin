package com.mobile.tr.poc.koin.ui.github.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.databinding.ActivityGithubBinding
import com.mobile.tr.poc.koin.extension.initVertical
import kotlinx.android.synthetic.main.activity_github.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class NewsActivity : AppCompatActivity(), NewsContract.View {

    val viewModel: NewsViewModel by viewModel()
    private val presenter: NewsContract.Presenter by inject { parametersOf(this, viewModel) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityGithubBinding>(this, R.layout.activity_github)
            .apply {
                newsViewModel = viewModel
                lifecycleOwner = this@NewsActivity
            }
        rvNews.initVertical()

    }


    fun getUser(view: View) {
        presenter.getNews()
    }
}
