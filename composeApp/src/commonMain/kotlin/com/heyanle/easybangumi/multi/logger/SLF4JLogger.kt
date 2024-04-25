package com.heyanle.easybangumi.multi.logger

import org.slf4j.LoggerFactory

/**
 * Created by heyanlin on 2024/4/23.
 */
class SLF4JLogger(level: com.heyanle.easybangumi.multi.logger.Level = com.heyanle.easybangumi.multi.logger.Level.INFO) : com.heyanle.easybangumi.multi.logger.Logger(level) {

    private val logger = LoggerFactory.getLogger(com.heyanle.easybangumi.multi.logger.LOGGER_TAG)

    override fun display(level: com.heyanle.easybangumi.multi.logger.Level, tag: String, msg: String) {
        when (level) {
            com.heyanle.easybangumi.multi.logger.Level.DEBUG -> logger.debug("[${tag}]$msg")
            com.heyanle.easybangumi.multi.logger.Level.INFO -> logger.info("[${tag}]$msg")
            com.heyanle.easybangumi.multi.logger.Level.ERROR -> logger.error("[${tag}]$msg")
            else -> logger.error("[${tag}]$msg")
        }
    }
}