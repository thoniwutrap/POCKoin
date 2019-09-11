package com.mobile.tr.poc.koin.ui.news.presenter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.tr.poc.koin.databinding.NewsListItemBinding
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem
import java.util.ArrayList

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mNewsList : MutableList<ArticlesItem> = mutableListOf()


    fun updateNews(categoryModel: MutableList<ArticlesItem>) {
        mNewsList = categoryModel
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val applicationBinding = NewsListItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerHolderCatIcon(applicationBinding)
    }

    override fun getItemCount(): Int  {
        return mNewsList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val appInfo = mNewsList[position]
        (holder as RecyclerHolderCatIcon).bind(appInfo)
    }

    inner class RecyclerHolderCatIcon(private var newsBinding: NewsListItemBinding) : RecyclerView.ViewHolder(newsBinding.root) {

        fun bind(appInfo: ArticlesItem) {
            newsBinding.newsViewModel  = appInfo
        }
    }

}