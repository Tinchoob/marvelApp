package com.martinb.marvelapp.data.remote;

import com.martinb.marvelapp.data.model.Character;

import java.util.List;

public interface RemoteDataListener {

    void charactersInfo(Character character);

}
