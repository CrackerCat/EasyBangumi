package com.heyanle.easybangumi.multi.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import java.net.CookieManager

/**
 * Created by heyanlin on 2024/4/23.
 */
interface NetworkHelper {

    val cookieManager: CookieManager
    val defaultLinuxUA: String
    val defaultAndroidUA: String
    val randomUA: String

    val httpClient: HttpClient
    val cloudflareClient: HttpClient

    val cookiesStorage: CookiesStorage




}