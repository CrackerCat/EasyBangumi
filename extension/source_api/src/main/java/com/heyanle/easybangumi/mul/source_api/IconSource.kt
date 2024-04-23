package com.heyanle.easybangumi.mul.source_api

/**
 * Created by HeYanLe on 2023/2/22 20:12.
 * https://github.com/heyanLE
 */
interface IconSource : Source {

    // 文件路径 or 网络地址
    fun getIconUri(): () -> (String?)

}