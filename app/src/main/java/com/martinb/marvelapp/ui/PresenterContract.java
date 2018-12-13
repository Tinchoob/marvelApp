package com.martinb.marvelapp.ui;

import com.martinb.marvelapp.data.model.Character;

public interface PresenterContract {

    interface PresenterMain {
        void getCharacterInfo();
        void getCharacterFilteredInfo(String input);
    }


}
