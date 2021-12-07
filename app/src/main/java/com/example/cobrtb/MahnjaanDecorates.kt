package com.example.cobrtb

import android.widget.MediaController
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.VideoView
import android.view.View

class MahnjaanDecorates : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahnjaan_decorates)
        val mediaController = MediaController(this)
        val mVideoView = findViewById<VideoView>(R.id.videoView)
        mediaController.setAnchorView(mVideoView)
        val localUri = Uri.parse("android.resource://$packageName/${R.raw.mahnjaanvid}")
        mVideoView.setMediaController(mediaController)
        mVideoView.setVideoURI(localUri)
        mVideoView.requestFocus()
        mVideoView.start()
        
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