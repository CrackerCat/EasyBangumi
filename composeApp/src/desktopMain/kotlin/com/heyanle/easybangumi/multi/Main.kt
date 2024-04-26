package com.heyanle.easybangumi.multi

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.runBlocking
import ui.App
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    println(System.getProperty("user.dir"))
    println(Paths.get("").toAbsolutePath().toString())
    application {
        runBlocking {
            Scheduler.runOnAppInit()
        }
        Window(onCloseRequest = ::exitApplication, title = "EasyBangumi") {
            App()
            Column {
                Text(System.getenv("HOME"))
                Text(System.getProperty("user.dir"))
                Text(Paths.get("").toAbsolutePath().toString())
            }
        }
    }
}