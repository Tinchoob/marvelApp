package com.martinb.marvelapp.ui

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.remote.MarvelApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class ComicsFragmentPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<ComicsView>(), PresenterContract.PresenterComics {


    override fun getComicsByCharacter(characterId: String){
        try {

        compositeDisposable.add(
        marvelApiService.getComicsData(timestamp,BuildConfig.APIKEY,hash,characterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> mvpView?.getComicsData(result) }
        )
        }catch (e : HttpException){
            e.stackTrace
        }

    }


}