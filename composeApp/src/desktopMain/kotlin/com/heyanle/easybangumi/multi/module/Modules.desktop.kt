package com.heyanle.easybangumi.multi.module


import com.heyanle.easybangumi.multi.Platform
import com.heyanle.easybangumi.multi.logger.Level
import com.heyanle.easybangumi.multi.logger.Logger
import com.heyanle.easybangumi.multi.logger.SLF4JLogger
import com.heyanle.inject.api.InjectModule
import com.heyanle.inject.api.addSingletonFactory
import com.heyanle.inject.api.module
import java.nio.file.Paths
import kotlin.io.path.absolutePathString

/**
 * Created by heyanlin on 2024/4/23.
 */
actual fun getPlatformModules(): List<InjectModule> {
    return listOf(
        module {
            addSingletonFactory<Logger> {
                com.heyanle.easybangumi.multi.logger.SLF4JLogger(Level.DEBUG)
            }
            addSingletonFactory<Platform> {
                object : Platform {
                    override val name: String = "Java ${System.getProperty("java.version")}"
                    override val rootDirPath: String
                        get() = Paths.get("").absolutePathString().toString()
                }
            }
        }
    )
}