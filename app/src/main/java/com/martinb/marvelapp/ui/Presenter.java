package com.martinb.marvelapp.ui;

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);
    void detachView();

}
