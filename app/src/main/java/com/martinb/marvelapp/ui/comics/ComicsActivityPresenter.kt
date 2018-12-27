package com.martinb.marvelapp.ui.comics

import com.martinb.marvelapp.data.remote.MarvelApiService
import com.martinb.marvelapp.ui.BasePresenter
import com.martinb.marvelapp.ui.NavigationActivityView
import com.martinb.marvelapp.ui.PresenterContract

class ComicsActivityPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<NavigationActivityView>(), PresenterContract.PresenterMainComics {
}