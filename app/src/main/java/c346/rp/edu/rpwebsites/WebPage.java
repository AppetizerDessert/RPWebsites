package c346.rp.edu.rpwebsites;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebPage extends AppCompatActivity {

    WebView wvWebPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webpage);


        wvWebPage = findViewById(R.id.webViewWebPage);
        wvWebPage.setWebViewClient(new WebViewClient());

        WebSettings testing=wvWebPage.getSettings();
        testing.setCacheMode(WebSettings.LOAD_NO_CACHE);
        testing.setAllowFileAccess(false);
        testing.setAllowFileAccessFromFileURLs(true);
        testing.setBuiltInZoomControls(true);

        Intent intentReceived = getIntent();

        String url = intentReceived.getStringExtra("url");
        wvWebPage.loadUrl(url);

        Toast.makeText(WebPage.this,url,Toast.LENGTH_LONG).show();




    }
}
