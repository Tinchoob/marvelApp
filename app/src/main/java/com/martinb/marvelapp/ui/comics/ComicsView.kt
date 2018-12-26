package com.martinb.marvelapp.ui

import com.martinb.marvelapp.data.model.ComicsResults

interface ComicsView : MvpView {

    fun getComicsData(comicsResult: ComicsResults)
}