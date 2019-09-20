package com.mobile.tr.poc.koin.ui.newsdetails.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.google.android.material.appbar.AppBarLayout
import com.mobile.tr.poc.koin.databinding.ActivityNewsDetailBinding
import com.mobile.tr.poc.koin.ui.news.presenter.NewsViewModel
import kotlinx.android.synthetic.main.activity_news_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.graphics.PorterDuff
import androidx.core.view.ViewCompat
import android.opengl.ETC1.getHeight
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import androidx.core.content.ContextCompat
import com.mobile.tr.poc.koin.R
import java.lang.Math.abs
import java.math.RoundingMode


class NewsDetailActivity : AppCompatActivity() {

    var position : Int = 0
    val viewModel: NewsViewModel by viewModel()
    var newsDetailbinding: ActivityNewsDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        position = intent.getIntExtra("position",0)
        newsDetailbinding =
            DataBindingUtil.setContentView<ActivityNewsDetailBinding>(this, R.layout.activity_news_detail)
                .apply {
                    newsViewModel = viewModel
                    lifecycleOwner = this@NewsDetailActivity
                }


        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.e("dd",verticalOffset.toString())
            viewTop.visibility = View.VISIBLE
            Log.e("cal alpha","${abs(verticalOffset)}")
            var alpha : Double  = 0.0
            if(abs(verticalOffset)!=0){
                alpha  = (kotlin.math.abs(verticalOffset)/380.0)
            }else{
                alpha = 0.0
            }
            val rounded = alpha.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
            Log.e("alpha",rounded.toFloat().toString())
            viewTop.alpha = rounded.toFloat()
            imgFrameBack.alpha = 1-rounded.toFloat()

//            if(rounded <= 0.5){
//                btnBack.setColorFilter(ContextCompat.getColor(this, R.color.white),PorterDuff.Mode.MULTIPLY);
//            }else{
//                btnBack.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent),PorterDuff.Mode.MULTIPLY);
//            }

            if(rounded.toFloat() > 0.4){
                btnBack.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent));
            }else{
                btnBack.setColorFilter(ContextCompat.getColor(this, R.color.white));
            }

        })
    }
}
