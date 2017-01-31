package com.techpalle.b34assignment211116;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    WebView webView;
    Button b1;
    String str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText) findViewById(R.id.edittext);
        webView = (WebView) findViewById(R.id.webview);
        b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1 = ed.getText().toString();
                ConnectivityManager manager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo= manager.getActiveNetworkInfo();
                if (networkInfo== null || networkInfo.isConnected() == false)
                {
                    webView.loadData("<h1>No Internet... Check Connection!!</h1>","text/html",null);
                    return;
                }
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("https://www.youtube.com/results?search_query="+str1);
                webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        if(url.equals("https://www.youtube.com/results?search_query="+str1))
                        {
                            Intent in=new Intent(MainActivity.this,Main2Activity.class);
                            Toast.makeText(MainActivity.this, url,Toast.LENGTH_LONG).show();
                            int index =url.indexOf("=");
                            index++;
                            String myurl = url.substring(index);
                            in.putExtra("key1",myurl);
                            startActivity(in);
                        }

                    }
                });
            }
        });
    }
}