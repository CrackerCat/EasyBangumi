package logger

import org.slf4j.LoggerFactory

/**
 * Created by heyanlin on 2024/4/23.
 */
class SLF4JLogger(level: Level = Level.INFO) : Logger(level) {

    private val logger = LoggerFactory.getLogger(LOGGER_TAG)

    override fun display(level: Level, tag: String, msg: String) {
        when (level) {
            Level.DEBUG -> logger.debug("[${tag}]$msg")
            Level.INFO -> logger.info("[${tag}]$msg")
            Level.ERROR -> logger.error("[${tag}]$msg")
            else -> logger.error("[${tag}]$msg")
        }
    }
}