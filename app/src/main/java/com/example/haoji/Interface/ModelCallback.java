package com.example.haoji.Interface;

/**
 * Created by HAOJI on 2019/11/25.
 */

public abstract interface ModelCallback {


    void onSuccess(String data);
    void onFailure(String msg);

}
