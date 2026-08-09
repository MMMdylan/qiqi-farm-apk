package com.qiqi.farm;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        WebView web = new WebView(this);

        WebSettings settings = web.getSettings();

        settings.setJavaScriptEnabled(true);

        // 开启网页存储
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);

        // 允许本地文件
        settings.setAllowFileAccess(true);

        web.loadUrl("file:///android_asset/index.html");

        setContentView(web);
    }
}
