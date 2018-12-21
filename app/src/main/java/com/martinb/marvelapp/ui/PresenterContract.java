package com.martinb.marvelapp.ui;

public interface PresenterContract {

    interface PresenterMain {
        void getCharacterInfo();
        void getCharacterFilteredInfo(String input);
    }

    interface PresenterFullInfo{

    }

    interface PresenterComics{
        void getComicsByCharacter(String characterId);
    }

}
