package com.example.myuccapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class UccSocial : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ucc_social)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Social Media Handles"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        // Declaring and Initializing
        val imgIG = findViewById(R.id.imgIG) as ImageView
        val imgFB = findViewById(R.id.imgFB) as ImageView
        val imgTWIT = findViewById(R.id.imgTWIT) as ImageView

        // Find the WebView by its unique ID
        val webHldes = findViewById<WebView>(R.id.wvHldes)
        webHldes!!.settings.javaScriptEnabled = true
        webHldes.webViewClient = WebViewClient()


        //Imageview that load each website when clicked.
        imgTWIT.setOnClickListener{
            webHldes.loadUrl("https://www.twitter.com/UCCjamaica/")
        }
        imgFB.setOnClickListener{
            webHldes.loadUrl("https://facebook.com/uccjamaica/")
        }
        imgIG.setOnClickListener{
            webHldes.loadUrl("https://www.instagram.com/uccjamaica/")
        }

        webHldes.loadUrl("https://www.instagram.com/uccjamaica/")


        webHldes.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webHldes.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webHldes.settings.setEnableSmoothTransition(true)
        webHldes.settings.setSupportZoom(true)
        webHldes.settings.builtInZoomControls = true
        webHldes.settings.displayZoomControls = false
        webHldes.settings.loadsImagesAutomatically = true
        webHldes.settings.blockNetworkImage = false
        webHldes.settings.setGeolocationEnabled(true)
        webHldes.settings.setJavaScriptCanOpenWindowsAutomatically(true)
        webHldes.settings.setSupportMultipleWindows(true)
        webHldes.settings.setDomStorageEnabled(true)
        webHldes.settings.setDatabaseEnabled(true)
        webHldes.settings.setDatabasePath(applicationContext.getDir("database", MODE_PRIVATE).path)
        webHldes.settings.setGeolocationDatabasePath(applicationContext.getDir("geolocation", MODE_PRIVATE).path)
        webHldes.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webHldes.setLayerType(View.LAYER_TYPE_HARDWARE, null)

    }

    override fun onBackPressed() {
        val webView: WebView = findViewById(R.id.wvHldes)
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
