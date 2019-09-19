package com.mobile.tr.poc.koin.ui.news.presenter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.tr.poc.koin.databinding.NewsListItemBinding
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem
import java.util.ArrayList

class NewsAdapter(var viewModel: NewsViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mNewsList : MutableList<ArticlesItem> = mutableListOf()


    fun updateNews(categoryModel: MutableList<ArticlesItem>) {
        mNewsList.addAll(categoryModel)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val applicationBinding = NewsListItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerHolderNews(applicationBinding)
    }

    override fun getItemCount(): Int  {
        Log.e("size",mNewsList.size.toString())
        return mNewsList.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecyclerHolderNews).bind(viewModel,position)
    }

    inner class RecyclerHolderNews(private var newsBinding: NewsListItemBinding) : RecyclerView.ViewHolder(newsBinding.root) {

        fun bind(appInfo: NewsViewModel,position: Int) {
            newsBinding.newsViewModel  = appInfo
            newsBinding.position = position
            newsBinding.executePendingBindings()
        }
    }

}