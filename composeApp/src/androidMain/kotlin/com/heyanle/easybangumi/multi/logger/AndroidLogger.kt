package com.heyanle.easybangumi.multi.logger

import android.util.Log

/**
 * Created by heyanlin on 2024/4/23.
 */
class AndroidLogger(level: Level = Level.INFO) : Logger(level) {

    override fun display(level: Level, tag: String, msg: String) {
        when (level) {
            Level.DEBUG -> Log.d(tag, msg)
            Level.INFO -> Log.i(tag, msg)
            Level.WARNING -> Log.w(tag, msg)
            Level.ERROR -> Log.e(tag, msg)
            else -> Log.e(tag, msg)
        }
    }

}