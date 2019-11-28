package com.example.haoji.mvp_build;

/**
 * Created by HAOJI on 2019/7/25.
 */

public interface MvpView  {
    void showLoading();

    void hideLoading();

    void showData(String data);

    void showFailureMessage(String msg);

    void showErrorMessage();
}
