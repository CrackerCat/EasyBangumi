package com.heyanle.easybangumi.multi.source

import com.heyanle.easybangumi.mul.source_api.Source
import com.heyanle.easybangumi.multi.source.bundle.ComponentBundle

/**
 * Created by heyanlin on 2023/10/27.
 */

sealed class SourceInfo {
    abstract val source: Source

//    // 数据迁移中
//    class Migrating(
//        override val source: Source,
//        val componentBundle: ComponentBundle,
//    ): SourceInfo()

    // 加载成功
    data class Loaded(
        override val source: Source,
        val componentBundle: ComponentBundle,
    ): SourceInfo()

    // 加载失败
    data class Error(
        override val source: Source,
        val msg: String,
        val exception: Exception? = null,
    ): SourceInfo()
}

data class ConfigSource(
    val sourceInfo: SourceInfo,
    val config: SourceConfig,
){
    val source: Source
        get() = sourceInfo.source
}

data class SourceConfig(
    val key: String,
    val order: Int,
    val enable: Boolean,
)