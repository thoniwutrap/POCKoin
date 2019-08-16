package com.mobile.tr.poc.koin

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

open class RxPresenter (val compositeDisposable: CompositeDisposable) :
	LifecycleObserver {

	@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
	fun onDestroy() {
		Log.e("ffff","destory")
		compositeDisposable.dispose()
	}
}