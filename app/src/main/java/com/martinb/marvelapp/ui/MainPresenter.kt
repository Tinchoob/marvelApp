package com.martinb.marvelapp.ui

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.HashUtils
import com.martinb.marvelapp.data.remote.MarvelApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException


class MainPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<MainView>(), PresenterContract.PresenterMain {


    override fun getCharacterInfo() {

        GlobalScope.launch(Dispatchers.Main) {
            val request = marvelApiService.getData(timestamp, BuildConfig.APIKEY, hash)
            try {
                val response = request.await()
                mvpView?.charactersInfo(response)
            } catch (e: HttpException) {
                e.stackTrace
            } catch (e: Throwable) {
                e.stackTrace
            }
        }

    }

    override fun getCharacterFilteredInfo(input: String) {

        GlobalScope.launch(Dispatchers.Main) {
            val request = marvelApiService.getDataFiltered(timestamp, BuildConfig.APIKEY, hash, input)
            try {
                val response = request.await()
                mvpView?.filteredCharactersInfo(response)
            } catch (e: HttpException) {
                e.stackTrace
            } catch (e: Throwable) {
                e.stackTrace
            }

        }

    }
}
