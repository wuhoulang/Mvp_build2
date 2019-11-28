package com.example.haoji.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/8/12.
 */

public class WebViewActivity extends Activity {
    private WebView id_wv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview2);
        id_wv=findViewById(R.id.id_wv);
        WebSettings webSettings = id_wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        id_wv.loadUrl("http://www.uc123.com/");
    }
}
