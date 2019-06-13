package com.martinb.marvelapp.ui

interface NavigationActivityView: MvpView {

    fun navigateTo(characterId : String, fragment: String)
}