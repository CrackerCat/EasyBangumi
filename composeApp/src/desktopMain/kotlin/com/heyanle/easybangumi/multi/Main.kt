package com.heyanle.easybangumi.multi

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.runBlocking
import ui.App

fun main() = application {
    runBlocking {
        Scheduler.runOnAppInit()
    }
    Window(onCloseRequest = ::exitApplication, title = "EasyBangumi") {
        App()
    }
}