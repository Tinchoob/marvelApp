package com.martinb.marvelapp.ui.comics

import com.martinb.marvelapp.data.remote.MarvelApiService
import com.martinb.marvelapp.ui.BasePresenter
import com.martinb.marvelapp.ui.PresenterContract

class ComicsActivityPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<MainComicsView>(), PresenterContract.PresenterMainComics {
}