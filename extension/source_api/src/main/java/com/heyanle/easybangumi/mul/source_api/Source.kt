package com.heyanle.easybangumi.mul.source_api

import kotlin.reflect.KClass


/**
 * Created by HeYanLe on 2023/10/18 22:41.
 * https://github.com/heyanLE
 */
interface Source {
    /**
     * Must be unique
     */
    val key: String

    val label: String

    val version: String

    val versionCode: Int

    val describe: String?

    fun register(): List<KClass<*>>


}