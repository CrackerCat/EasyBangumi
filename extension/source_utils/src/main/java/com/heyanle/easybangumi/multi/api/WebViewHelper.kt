package com.heyanle.easybangumi.multi.api

/**
 * Created by heyanlin on 2024/4/23.
 */
interface WebViewHelper {


    data class WebViewSniffingStrategy (
        val url: String,
        val interceptResourceRegex: String,
        val encoding: String = "utf-8",
        val userAgentString: String? = null,
        val header: Map<String, String>? = null,
        val actionJs: String? = null,
        val timeOut: Long = 8000L,
        val interceptBlob: Boolean = false
    )

    data class WebViewSniffingResult(
        val strategy: WebViewSniffingStrategy,
        val content: String,
        val interceptResource: String,
    )

    suspend fun startSniffing(
        strategy: WebViewSniffingStrategy
    ): WebViewSniffingResult


}