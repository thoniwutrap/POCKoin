package com.mobile.tr.poc.koin.ui.news.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.databinding.ActivityGithubBinding
import com.mobile.tr.poc.koin.extension.initVertical
import com.mobile.tr.poc.koin.extension.launchActivity
import com.mobile.tr.poc.koin.ui.base.BaseActivity
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem
import com.mobile.tr.poc.koin.ui.news.domain.model.NewsResponse
import com.mobile.tr.poc.koin.ui.newsdetails.presenter.NewsDetailActivity
import kotlinx.android.synthetic.main.activity_github.*
import kotlinx.android.synthetic.main.activity_github.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.ArrayList

class NewsActivity : BaseActivity(), NewsContract.View {

    val viewModel: NewsViewModel by viewModel()
    private val presenter: NewsContract.Presenter by inject { parametersOf(this, viewModel) }
    var binding: ActivityGithubBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView<ActivityGithubBinding>(this, R.layout.activity_github)
                .apply {
                    newsViewModel = viewModel
                    lifecycleOwner = this@NewsActivity
                }
        subscribeViewModel()
        showLoading().let {
            presenter.getGithub()
        }
    }


    private fun subscribeViewModel() {
        viewModel.mutablePostList.observe(this, Observer<MutableList<ArticlesItem>> {
            viewModel.adapter?.updateNews(it)
        })

        viewModel.getSelected().observe(this, Observer<ArticlesItem> {
            launchActivity<NewsDetailActivity>{
                putExtra("position",viewModel.newsPositionSelected.value)
            }
        })
    }

    override fun onNewsSuccess() {
        hideLoading()
    }

    override fun onOfflineMode() {
        hideLoading()
        presenter.getNewsOffline()
    }

    fun getUser(view: View) {
        presenter.getNews()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.mutablePostList.removeObservers(this)
    }
}
