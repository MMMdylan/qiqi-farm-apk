package com.qiqi.farm;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.webkit.JavascriptInterface;
import android.content.SharedPreferences;

public class MainActivity extends Activity {


    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        WebView web = new WebView(this);


        WebSettings settings = web.getSettings();


        // 开启JavaScript
        settings.setJavaScriptEnabled(true);


        // WebView存储支持
        settings.setDomStorageEnabled(true);


        // 页面从 file:///android_asset 加载，不受这两项影响；关掉其他文件和 content:// 访问
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);



        // SharedPreferences
        sp = getSharedPreferences(
                "qiqiFarm",
                MODE_PRIVATE
        );



        // JS调用Android
        web.addJavascriptInterface(
                new AndroidStorage(),
                "AndroidStorage"
        );


        // 设置 WebChromeClient 后，网页里的 alert/confirm 弹窗才会显示
        web.setWebChromeClient(new WebChromeClient());



        web.loadUrl(
                "file:///android_asset/index.html"
        );


        setContentView(web);

    }




    // 页面数据按名字分别保存：farmList（农场列表，沿用旧版的名字）、waterPlans、waterStrategies、settings
    private class AndroidStorage {


        @JavascriptInterface
        public void save(String key, String data){


            sp.edit()
              .putString(
                    key,
                    data
              )
              .apply();

        }




        @JavascriptInterface
        public String load(String key){


            return sp.getString(
                    key,
                    ""
            );

        }

    }

}
