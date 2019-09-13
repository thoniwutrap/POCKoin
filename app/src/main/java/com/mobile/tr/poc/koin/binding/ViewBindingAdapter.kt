package com.mobile.tr.poc.koin.binding

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.ShapeDrawable




object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("android:img")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }

    @JvmStatic
    @BindingAdapter("app:setAdapter")
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:setAdapterHorizontal")
    fun bindRecyclerViewAdapterHorizontal(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context,LinearLayoutManager.HORIZONTAL ,false)
        recyclerView.itemAnimator?.changeDuration = 0
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:bgColor", "app:stokeColor")
    fun backgroundDrawableChange(view: ImageView, bgColor : Int, stokeColor : Int){
        view.background.apply {
            when (this) {
                is ShapeDrawable -> {
                    this.paint.color = bgColor
                }
                is GradientDrawable -> {
                    this.setColor(bgColor)
                    this.setStroke(1,stokeColor)
                }
                is ColorDrawable -> {
                    this.color =bgColor
                }
            }
        }

    }

}