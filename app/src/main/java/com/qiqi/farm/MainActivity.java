package com.qiqi.farm;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.JavascriptInterface;
import android.content.SharedPreferences;

public class MainActivity extends Activity {


    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        WebView web = new WebView(this);


        WebSettings settings = web.getSettings();


        settings.setJavaScriptEnabled(true);


        settings.setDomStorageEnabled(true);


        settings.setAllowFileAccess(true);



        // 创建本地存储
        sp = getSharedPreferences(
                "qiqiFarm",
                MODE_PRIVATE
        );



        // JS调用Android接口
        web.addJavascriptInterface(
                new AndroidStorage(),
                "AndroidStorage"
        );



        web.loadUrl(
                "file:///android_asset/index.html"
        );


        setContentView(web);

    }




    public class AndroidStorage {



        @JavascriptInterface
        public void saveData(String data){


            sp.edit()
              .putString(
                    "farmList",
                    data
              )
              .apply();

        }



        @JavascriptInterface
        public String loadData(){


            return sp.getString(
                    "farmList",
                    ""
            );

        }

    }

}
