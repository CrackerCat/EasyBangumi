package com.heyanle.easybangumi.multi.base

import com.heyanle.easybangumi.multi.base.utils.MoshiArrayListJsonAdapter
import com.heyanle.inject.api.InjectScope
import com.heyanle.inject.api.addSingletonFactory
import com.heyanle.inject.api.module
import com.heyanle.inject.core.DefaultInjectScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
/**
 * Created by heyanlin on 2024/4/23.
 */


val baseModule = module {
    addSingletonFactory {
        Moshi.Builder()
            .add(MoshiArrayListJsonAdapter.FACTORY)
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
}