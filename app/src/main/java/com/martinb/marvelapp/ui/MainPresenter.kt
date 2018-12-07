package com.martinb.marvelapp.ui

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.HashUtils
import com.martinb.marvelapp.data.remote.MarvelApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<PresenterContract.MainView>(), PresenterContract.PresenterMain {

    private val hash = HashUtils.md5(String.format("%s%s%s", "1", BuildConfig.SECRET, BuildConfig.APIKEY))

    override fun getCharacterInfo() {
        compositeDisposable.add(
                marvelApiService.getData("1", BuildConfig.APIKEY, hash).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { result ->
                            mvpView?.charactersInfo(result)
                        })

    }

    override fun getCharacterFilteredInfo(input: String) {
        compositeDisposable.add(
                marvelApiService.getDataFiltered("1",BuildConfig.APIKEY,hash,input)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe{ result -> mvpView?.filteredCharactersInfo(result)
                        }
        )
   }


}
