package com.mobile.tr.poc.koin.ui.news.presenter

import android.util.Log
import com.mobile.tr.poc.koin.RxPresenter
import com.mobile.tr.poc.koin.data.local.entity.news.TbImageNews
import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.news.domain.NewsUseCase
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem
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
    var newsUseCase: NewsUseCase,
    var viewModel: NewsViewModel,
    compositeDisposable: CompositeDisposable
) :
    RxPresenter(compositeDisposable),
    NewsContract.Presenter {


    override fun getNews() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val db = newsUseCase.getNewsDB()
                Log.e("ddd",db[0].uid.toString())
                Log.e("ddd",db[0].totalResults.toString())
                Log.e("ddd",db[0].articles[3]?.urlToImage)
            } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    }

    override fun getGithub() {

        newsUseCase.getNews("ee13331230bf4998967d2b240665dda4")
            .map {
                val tbNews: TbNews = TbNews()
                tbNews.status = it.status
                tbNews.totalResults = it.totalResults
                tbNews.articles = it.articles
                newsUseCase.saveGithubDB(tbNews)
            }
            .map {
                newsUseCase.getArticle(it)

            }.map {
                for (item in it.articles) {
                    val imgNews: TbImageNews = TbImageNews()
                    imgNews.imgUrl = item.urlToImage
                    imgNews.newsUid = it.uid
                    newsUseCase.saveImgNews(imgNews)
                }
                newsUseCase.getArticle(it.uid!!.toLong())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    view?.onNewsSuccess()
                    viewModel.mutablePostList.postValue(it.articles)
                },
                onError = {
                    Log.e("dd", "ssE")
                    it.printStackTrace()
                    view?.onOfflineMode()
                }
            ).addTo(compositeDisposable)
    }

    override fun getNewsOffline() {
        CoroutineScope(Dispatchers.IO).launch {
            val newsList = newsUseCase.getNewsDB()
            for(item in newsList){
                viewModel.mutablePostList.postValue(item.articles)
            }
        }

    }
}