package com.heyanle.easybangumi.multi.base

import com.heyanle.inject.api.InjectScope
import com.heyanle.inject.api.fullType
import com.heyanle.inject.api.get
import com.heyanle.inject.core.DefaultInjectScope

/**
 * 顶层默认 scope
 * Created by HeYanLe on 2023/7/29 20:00.
 * https://github.com/heyanLE
 */
val Inject: InjectScope = DefaultInjectScope()
    .apply {
        baseModule.registerWith(this)
    }

inline fun <reified T : Any> injectLazy(): Lazy<T> {
    return lazy { Inject.get(fullType<T>()) }
}

inline fun <reified T : Any> injectValue(): Lazy<T> {
    return lazyOf(Inject.get(fullType<T>()))
}

inline fun <reified T : Any> injectLazy(key: Any): Lazy<T> {
    return lazy { Inject.get(fullType<T>(), key) }
}

inline fun <reified T : Any> injectValue(key: Any): Lazy<T> {
    return lazyOf(Inject.get(fullType<T>(), key))
}