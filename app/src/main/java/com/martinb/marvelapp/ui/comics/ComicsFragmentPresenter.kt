package com.martinb.marvelapp.ui

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.remote.MarvelApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ComicsFragmentPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<ComicsView>(), PresenterContract.PresenterComics {


    override fun getComicsByCharacter(characterId: String){
        try {
            GlobalScope.launch(Dispatchers.Main) {
                val request =  marvelApiService.getComicsData(timestamp,BuildConfig.APIKEY,hash,characterId)
                try {
                    val response = request.await()
                    mvpView?.getComicsData(response)
                } catch (e: HttpException) {
                    e.stackTrace
                } catch (e: Throwable) {
                    e.stackTrace
                }

            }

        }catch (e : HttpException){
            e.stackTrace
        }

    }


}