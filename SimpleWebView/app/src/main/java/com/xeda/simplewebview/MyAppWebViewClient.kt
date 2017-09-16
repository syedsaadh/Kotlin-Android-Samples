package com.xeda.simplewebview

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

/**
 * Created by Xeda on 16-09-2017.
 */

class MyAppWebViewClient : WebViewClient {

    private lateinit var progressBar : ProgressBar

    constructor(progressBar: ProgressBar) {
        this.progressBar = progressBar
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        progressBar.visibility = View.VISIBLE
        super.onPageStarted(view, url, favicon)
    }
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
    }
}