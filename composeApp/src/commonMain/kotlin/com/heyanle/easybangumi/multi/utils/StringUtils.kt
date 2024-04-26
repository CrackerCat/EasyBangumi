package com.heyanle.easybangumi.multi.utils

import com.heyanle.easybangumi.multi.base.Inject
import com.heyanle.easybangumi.multi.logger.Level
import com.heyanle.easybangumi.multi.logger.Logger
import com.heyanle.inject.api.get

/**
 * Created by heyanlin on 2024/4/23.
 */
private val regCharSet = setOf<Char>(
    '*', '.', '?', '+', '$', '^', '[', ']', '(', ')', '{', '}', '|', '\\', '/'
)

fun String.getMatchReg(): Regex {
    return runCatching {
        buildString {
            append("(.*)(")
            append(this@getMatchReg.toCharArray().toList().filter { it != ' ' }
                .joinToString(")(.*)(") {
                    if (regCharSet.contains(it)) {
                        "\${it}"
                    } else it + ""

                })
            append(")(.*)")
        }.toRegex(RegexOption.IGNORE_CASE)
    }.getOrElse {
        // 出错了就什么都不给你匹配
        "".toRegex(RegexOption.IGNORE_CASE)
    }
}

fun Any?.logi(tag: String) {
    val logger = Inject.get<Logger>()
    logger.log(Level.INFO, tag, this.toString())
}


fun Any?.logd(tag: String) {
    val logger = Inject.get<Logger>()
    logger.log(Level.DEBUG, tag, this.toString())
}


fun Any?.logw(tag: String) {
    val logger = Inject.get<Logger>()
    logger.log(Level.WARNING, tag, this.toString())
}


fun Any?.loge(tag: String) {
    val logger = Inject.get<Logger>()
    logger.log(Level.ERROR, tag, this.toString())
}
