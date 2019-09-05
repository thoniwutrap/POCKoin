package com.mobile.tr.poc.koin.ui.github

import com.mobile.tr.poc.koin.ui.github.domain.NewsUseCase
import com.mobile.tr.poc.koin.ui.github.domain.NewsUseCaseImpl
import com.mobile.tr.poc.koin.ui.github.presenter.NewsContract
import com.mobile.tr.poc.koin.ui.github.presenter.NewsPresenter
import com.mobile.tr.poc.koin.ui.github.presenter.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModule = module {

    viewModel { NewsViewModel() }

    single <NewsContract.Presenter> { (view: NewsContract.View,viewModel : NewsViewModel) -> NewsPresenter(view, get(),viewModel,get())}

    single <NewsUseCase> { NewsUseCaseImpl(get(),get()) }
}
