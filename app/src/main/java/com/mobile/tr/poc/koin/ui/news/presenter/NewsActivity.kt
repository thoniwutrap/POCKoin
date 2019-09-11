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
import com.mobile.tr.poc.koin.ui.base.BaseActivity
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem
import com.mobile.tr.poc.koin.ui.news.domain.model.NewsResponse
import kotlinx.android.synthetic.main.activity_github.*
import kotlinx.android.synthetic.main.activity_github.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.ArrayList

class NewsActivity : BaseActivity(), NewsContract.View {

    val viewModel: NewsViewModel by viewModel()
    private val presenter: NewsContract.Presenter by inject { parametersOf(this, viewModel) }
    var binding : ActivityGithubBinding? = null
    var adapter : NewsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ff","create")
        binding = DataBindingUtil.setContentView<ActivityGithubBinding>(this, R.layout.activity_github)
            .apply {
                newsViewModel = viewModel
                lifecycleOwner = this@NewsActivity
            }
        subscribeViewModel()
        rvNews?.initVertical()  
        adapter = NewsAdapter()
        rvNews?.adapter = adapter

        showLoading()
        presenter.getGithub()


    }





    fun subscribeViewModel(){
        viewModel.mutablePostList.removeObservers(this)
        viewModel.mutablePostList.observe(this, Observer<MutableList<ArticlesItem>> {
            Log.e("d","subscrive ${it.size}")
            adapter?.setAppList(it)
        })
    }

    override fun onNewsSuccess() {
        hideLoading()
    }


    fun getUser(view: View) {
        presenter.getNews()
    }


    override fun onDestroy() {
        Log.e("destroy","true")
        viewModel.mutablePostList.value = null
        super.onDestroy()
    }
}
