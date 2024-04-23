package com.heyanle.inject.api

/**
 * Created by HeYanLe on 2023/7/29 20:11.
 * https://github.com/heyanLE
 */

interface InjectModule {
    fun registerWith(intoScope: InjectScope) {
        intoScope.registerInjectables()
    }

    fun InjectScope.registerInjectables()

}

fun module(init: InjectScope.() -> Unit): InjectModule {
    return object : InjectModule {
        override fun InjectScope.registerInjectables() {
            init()
        }
    }
}
