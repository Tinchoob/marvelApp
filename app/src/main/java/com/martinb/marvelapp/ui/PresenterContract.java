package com.martinb.marvelapp.ui;

import com.martinb.marvelapp.data.model.Character;

public interface PresenterContract {

    interface PresenterMain {
        void getCharacterInfo();
        void getCharacterFilteredInfo(String input);
    }

    interface MainView extends MvpView {
        void charactersInfo(Character character);
        void filteredCharactersInfo(Character character);
    }

}
