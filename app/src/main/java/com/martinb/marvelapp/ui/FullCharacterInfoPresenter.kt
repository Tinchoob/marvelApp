package com.martinb.marvelapp.ui

import com.martinb.marvelapp.data.remote.MarvelApiService

class FullCharacterInfoPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<FullCharacterInfoView>(), PresenterContract.PresenterFullInfo