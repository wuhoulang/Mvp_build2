package com.example.haoji.mvp_build;

/**
 * Created by HAOJI on 2019/7/25.
 */

public interface MvpCallback {
    void onSuccess(String data);
    void onFailure(String msg);

    void onError();
    void onComplete();
}
