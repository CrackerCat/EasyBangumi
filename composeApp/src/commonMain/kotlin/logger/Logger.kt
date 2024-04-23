package logger

abstract class Logger(var level: Level = Level.INFO) {

    abstract fun display(level: Level, tag: String, msg: String)

    fun debug(tag: String, msg: String) {
        log(Level.DEBUG, tag, msg)
    }

    fun info(tag: String, msg: String) {
        log(Level.INFO, tag, msg)
    }

    fun warn(tag: String, msg: String) {
        log(Level.WARNING, tag, msg)
    }

    fun error(tag: String, msg: String) {
        log(Level.ERROR, tag, msg)
    }

    fun isAt(lvl: Level): Boolean = this.level <= lvl

    fun log(lvl: Level, tag: String, msg: String) {
        if (isAt(lvl)) display(lvl, tag, msg)
    }
}

const val LOGGER_TAG = "Easy"

enum class Level {
    DEBUG, INFO, WARNING, ERROR, NONE
}
