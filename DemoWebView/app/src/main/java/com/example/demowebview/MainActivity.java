package com.example.demowebview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void backBtn(View view) {
        if(webView.canGoBack()){
            webView.goBack();
        }
    }

    public void forwardBtn(View view) {
        if(webView.canGoForward()){
            webView.goForward();
        }
    }

    public void reloadBtn(View view) {
        webView.reload();
    }

    public void goBtn(View view) {
        String url = editText.getText().toString();
        webView.loadUrl(url);
    }
}