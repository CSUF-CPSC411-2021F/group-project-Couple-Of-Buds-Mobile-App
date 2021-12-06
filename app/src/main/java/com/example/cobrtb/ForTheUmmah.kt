package com.example.cobrtb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class ForTheUmmah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_the_ummah)

        webViewSetup()
    }

    private fun webViewSetup() {
        val mWebView = findViewById<WebView>(R.id.link2)
        mWebView.webViewClient = WebViewClient()

        mWebView.apply {
            loadUrl("https://fortheummah.co/")
        }
    }
}