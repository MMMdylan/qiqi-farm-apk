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

        // 开启JavaScript
        settings.setJavaScriptEnabled(true);

        // 开启网页本地存储（localStorage）
        settings.setDomStorageEnabled(true);

        // 开启数据库存储
        settings.setDatabaseEnabled(true);

        // 允许读取assets中的HTML
        settings.setAllowFileAccess(true);

        // 适配手机比例
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        // 加载你的HTML
        web.loadUrl("file:///android_asset/index.html");

        setContentView(web);
    }
}
