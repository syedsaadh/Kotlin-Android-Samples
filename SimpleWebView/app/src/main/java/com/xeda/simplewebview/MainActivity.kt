package com.xeda.simplewebview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mWebView: WebView
    private lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mWebView = findViewById<WebView>(R.id.activity_main_web_view)
        progressBar = findViewById(R.id.activity_main_progress)

        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.displayZoomControls = true
        webSettings.builtInZoomControls = true
        mWebView.loadUrl("https://www.google.com/")
        mWebView.webViewClient = MyAppWebViewClient(progressBar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_refresh -> {
                mWebView.reload()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    override fun onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
