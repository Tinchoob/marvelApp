package com.martinb.marvelapp.ui;

import com.martinb.marvelapp.data.model.Character;

public interface MainView extends MvpView {

    void charactersInfo(Character character);
    void filteredCharactersInfo(Character character);

}
