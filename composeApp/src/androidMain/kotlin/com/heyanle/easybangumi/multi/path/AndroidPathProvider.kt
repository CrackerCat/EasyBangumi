package com.heyanle.easybangumi.multi.path

import android.content.Context

/**
 * Created by heyanlin on 2024/4/26.
 */
class AndroidPathProvider(
    private val context: Context
): PathProvider {

    override val applicationFiles: String by lazy {
        context.getExternalFilesDir(null)?.absolutePath ?: context.filesDir.absolutePath
    }
    override val applicationCache: String by lazy {
        context.externalCacheDir?.absolutePath ?: context.cacheDir.absolutePath
    }
}