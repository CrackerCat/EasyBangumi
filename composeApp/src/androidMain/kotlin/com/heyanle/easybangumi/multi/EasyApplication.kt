package com.heyanle.easybangumi.multi

import android.app.Application

/**
 * Created by heyanlin on 2024/4/23.
 */
class EasyApplication : Application() {

    companion object {
        lateinit var APP: EasyApplication
    }


    override fun onCreate() {
        super.onCreate()
        APP = this
        Scheduler.runOnAppInit()
    }

}