package com.example.haoji.mvp_build;

import android.widget.Toast;

import java.util.logging.Handler;

/**
 * Created by HAOJI on 2019/7/25.
 */

public class MvpModel {
    /**
     * 获取网络接口数据
     * 请求参数
     * 数据回调接口
     */

    public static void getNetData(final String param, final MvpCallback mvpCallback){
                //switch语句
                switch (param) {
                    case "normal":
                        mvpCallback.onSuccess("根据参数"+param+"的请求网络数据成功");
                        break;
                    case "failure":
                        mvpCallback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        mvpCallback.onError();
                        break;
                    default:
                        break;
                }
                mvpCallback.onComplete();
    }
}
