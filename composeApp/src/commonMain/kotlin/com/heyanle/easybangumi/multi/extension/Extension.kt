package com.heyanle.easybangumi.multi.extension

import com.heyanle.easybangumi.mul.source_api.Source
import com.heyanle.easybangumi.multi.utils.getMatchReg


/**
 * Created by heyanlin on 2023/10/24.
 */
sealed class Extension {
    abstract val key: String
    abstract val label: String
    abstract val pkgName: String
    abstract val versionName: String
    abstract val versionCode: Long
    abstract val libVersion: Int
    abstract val readme: String?
    abstract val icon: String?
    abstract val loadType: Int
    abstract val sourcePath: String
    abstract val publicPath: String // 文件位置

    companion object {
        const val TYPE_APP = 0
        const val TYPE_FILE = 1
    }

    data class Installed(
        override val key: String,
        override val label: String,
        override val pkgName: String,
        override val versionName: String,
        override val versionCode: Long,
        override val libVersion: Int,
        override val readme: String?,
        override val icon: String?,
        override val loadType: Int,
        override val sourcePath: String,
        override val publicPath: String,
        val sources: List<Source>,

        ): Extension()

    data class InstallError(
        override val key: String,
        override val label: String,
        override val pkgName: String,
        override val versionName: String,
        override val versionCode: Long,
        override val libVersion: Int,
        override val readme: String?,
        override val icon: String?,
        override val loadType: Int,
        override val sourcePath: String,
        override val publicPath: String,
        val exception: Exception?,
        val errMsg: String,
    ): Extension()

    fun match(key: String): Boolean {
        var matched = false
        for (match in key.split(',')) {
            val regex = match.getMatchReg()
            if (label.matches(regex)) {
                matched = true
                break
            }
            if (pkgName.matches(regex)) {
                matched = true
                break
            }
            if (libVersion.toString().matches(regex)) {
                matched = true
                break
            }
            if ((readme?:"").matches(regex)) {
                matched = true
                break
            }
        }
        return matched
    }

}
