package com.example.w10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView netti;
    Button etsi;
    Button eteenpäin;
    Button taaksepäin;
    Button päivitä;
    EditText editText;
    Button js_shoutOut;
    Button js_initialize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        netti = findViewById(R.id.webView);
        editText = findViewById(R.id.editText);
        //Sallitaan JavaScript
        netti.getSettings().setJavaScriptEnabled(true);
        netti.setWebViewClient(new WebViewClient());
        //Asetetaan google aloitussivuksi
        netti.loadUrl("http://www.google.fi");
        //Sallitaan meneminen eteen- ja taaksepäin.
        netti.canGoBack();
        netti.canGoForward();
    }
    //Etsiminen selaimesta
    public void etsiminen(View v){
        String osoite = editText.getText().toString();
        if (osoite.contains("https://")){
            netti.loadUrl(osoite);
        }
        else if(osoite.contains("http://")){
            netti.loadUrl(osoite);
        }
        else if (osoite.contains("index.html")){
            netti.loadUrl("file:///android_asset/index.html");
        }else {
            netti.loadUrl("http://"+osoite);
        }
    }
    //funktiot painikkeille
    public void taakse(View v){
        netti.goBack();
    }
    public void eteen(View v){
        netti.goForward();
    }
    public void päivitä(View v){
        netti.reload();
    }
    public void js_1(View v){
        netti.evaluateJavascript("javascript:initialize()",null);
    }
    public void js_2(View v){
        netti.evaluateJavascript("javascript:shoutOut()", null);
    }
}