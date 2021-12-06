package com.example.cobrtb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MahnjaanDecorates : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahnjaan_decorates)

        webViewSetup()
    }

    private fun webViewSetup() {
        val mWebView = findViewById<WebView>(R.id.link)
        mWebView.webViewClient = WebViewClient()

        mWebView.apply {
            loadUrl("https://linktr.ee/mahnjaandecorates")
            //
        }
    }
}