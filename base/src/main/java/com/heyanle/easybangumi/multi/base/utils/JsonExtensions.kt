package com.heyanle.easybangumi.multi.base.utils

import com.heyanle.easybangumi.multi.base.Inject
import com.squareup.moshi.Moshi
import kotlin.reflect.javaType
import kotlin.reflect.typeOf

/**
 * Created by heyanlin on 2024/4/25.
 */
@OptIn(ExperimentalStdlibApi::class)
inline fun <reified T> String.jsonTo(): T? {
    val moshi: Moshi by Inject.injectLazy()
    val adapter = moshi.adapter<T>(typeOf<T>().javaType)
    if (isEmpty()) {
        return null
    }
    return runCatching {
        adapter.fromJson(this)
    }.getOrElse {
        it.printStackTrace()
        null
    }
}


@OptIn(ExperimentalStdlibApi::class)
inline fun <reified T> T.toJson(): String {
    val moshi: Moshi by Inject.injectLazy()
    val adapter = moshi.adapter<T>(typeOf<T>().javaType)
    return adapter.toJson(this)
}