package com.martinb.marvelapp.ui

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.HashUtils


open class BasePresenter<T : MvpView> : Presenter<T> {

    protected val timestamp = "1"
    protected val hash = HashUtils.md5(String.format("%s%s%s", "1", BuildConfig.SECRET, BuildConfig.APIKEY))

    var mvpView: T? = null
        private set


    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        this.mvpView = null
    }
}
