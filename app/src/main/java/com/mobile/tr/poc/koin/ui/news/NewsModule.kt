package com.mobile.tr.poc.koin.ui.news

import com.mobile.tr.poc.koin.ui.news.domain.NewsUseCase
import com.mobile.tr.poc.koin.ui.news.domain.NewsUseCaseImpl
import com.mobile.tr.poc.koin.ui.news.presenter.NewsContract
import com.mobile.tr.poc.koin.ui.news.presenter.NewsPresenter
import com.mobile.tr.poc.koin.ui.news.presenter.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModule = module {

    single  { NewsViewModel() }

    factory  <NewsContract.Presenter> { (view: NewsContract.View,viewModel : NewsViewModel) -> NewsPresenter(view, get(),viewModel,get())}

    factory  <NewsUseCase> { NewsUseCaseImpl(get(),get()) }
}
