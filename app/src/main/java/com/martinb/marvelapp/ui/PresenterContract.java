package com.martinb.marvelapp.ui;

import com.martinb.marvelapp.data.model.Character;

public interface PresenterContract {

    interface PresenterMain {
        void getCharacterInfo();
    }

    interface MainView extends MvpView {
        void charactersInfo(Character character);
    }

}
