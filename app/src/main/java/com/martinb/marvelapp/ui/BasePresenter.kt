package com.martinb.marvelapp.ui


import io.reactivex.disposables.CompositeDisposable


open class BasePresenter<T : MvpView> : Presenter<T> {

    var mvpView: T? = null
        private set

    val compositeDisposable = CompositeDisposable()


    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        this.mvpView = null
        if (!compositeDisposable.isDisposed) compositeDisposable.clear()
    }
}
