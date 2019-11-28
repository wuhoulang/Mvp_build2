package com.example.haoji.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.jiguang.share.wechat.WeChatHandleActivity;

/**
 * Created by HAOJI on 2019/9/6.
 */

public class JChatProCallbackActivity extends WeChatHandleActivity {
    private static final String TAG = "JChatProCallbackActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
