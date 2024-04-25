package com.heyanle.easybangumi.mul.source_api.entity

/**
 * 历史遗留问题，插件化不能随便加和继承，只能扩展进去了
 * Created by heyanlin on 2023/8/4.
 * https://github.com/heyanLE
 */

fun SCartoonCover.toIdentify(): String {
    return "${id},${source}"
}

fun SCartoon.toIdentify(): String {
    return "${id},${source}"
}

fun SCartoonCover.matchIdentify(identify: String): Boolean {
    return toIdentify() == identify
}

fun SCartoon.matchIdentify(identify: String): Boolean {
    return toIdentify() == identify
}