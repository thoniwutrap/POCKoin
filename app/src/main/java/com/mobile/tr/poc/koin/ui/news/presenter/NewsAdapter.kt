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


    fun setAppList(categoryModel: MutableList<ArticlesItem>) {
        mNewsList = categoryModel
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val applicationBinding = NewsListItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerHolderCatIcon(applicationBinding)
    }

    override fun getItemCount(): Int  {
        Log.e("sizxxe",mNewsList.size.toString())
        return mNewsList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val appInfo = mNewsList[position]
        (holder as NewsAdapter.RecyclerHolderCatIcon).bind(appInfo)
    }

    inner class RecyclerHolderCatIcon(private var applicationBinding: NewsListItemBinding) : RecyclerView.ViewHolder(applicationBinding.root) {

        fun bind(appInfo: ArticlesItem) {
            applicationBinding.newsViewModel  = appInfo
        }
    }

}