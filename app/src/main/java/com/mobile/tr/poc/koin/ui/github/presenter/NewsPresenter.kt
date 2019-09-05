package com.mobile.tr.poc.koin.ui.github.presenter

import android.util.Log
import com.mobile.tr.poc.koin.RxPresenter
import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.github.domain.NewsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsPresenter(
    var view: NewsContract.View?,
    var githubUseCase: NewsUseCase,
    var viewModel: NewsViewModel,
    compositeDisposable: CompositeDisposable
) :
    RxPresenter(compositeDisposable),
    NewsContract.Presenter {

    override fun getNews() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val db = githubUseCase.getNewsDB()
                Log.e("ddd",db[0].status)
                Log.e("ddd",db[0].totalResults.toString())
                Log.e("ddd",db[0].articles[3]?.urlToImage)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    override fun getGithub() {
        githubUseCase.getNews("ee13331230bf4998967d2b240665dda4")
            .map{
                var tbNews : TbNews = TbNews()
                tbNews.status = it.status
                tbNews.totalResults = it.totalResults
                tbNews.articles = it.articles
                githubUseCase.saveGithubDB(tbNews)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("long",it.toString())
                   // viewModel.username.value = "ddddd"
                },
                onError = {
                    it.printStackTrace()
                }
            ).addTo(compositeDisposable)
    }
}