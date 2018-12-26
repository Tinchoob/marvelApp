package com.martinb.marvelapp.ui.comics

import com.martinb.marvelapp.data.model.ComicsResults
import com.martinb.marvelapp.ui.MvpView

interface ComicsView : MvpView {

    fun getComicsData(comicsResult: ComicsResults)
}