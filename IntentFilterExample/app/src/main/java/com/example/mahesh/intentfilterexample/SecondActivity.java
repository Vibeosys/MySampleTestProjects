package com.example.mahesh.intentfilterexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mahesh on 9/21/2015.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.secondactivity);
        Uri uri=getIntent().getData();
        WebView webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new callback());
webView.loadUrl(uri.toString());
    }

}

 class callback extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }
}