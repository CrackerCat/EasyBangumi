package com.heyanle.easybangumi.multi.logger

import mu.KotlinLogging
import org.jetbrains.skiko.OS

/**
 * Created by heyanlin on 2024/4/26.
 */
class KotlinLogger(level: Level = Level.INFO) : Logger(level) {

    private val logger = KotlinLogging.logger(LOGGER_TAG)
    override fun display(level: Level, tag: String, msg: String) {
        when (level) {
            Level.DEBUG -> logger.debug("[$tag] $msg")
            Level.INFO -> logger.info("[$tag] $msg")
            Level.WARNING -> logger.warn("[$tag] $msg")
            else -> logger.error("[$tag] $msg")
        }
    }
}