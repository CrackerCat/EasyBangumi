package com.heyanle.easybangumi.multi.module


import com.heyanle.easybangumi.multi.Platform
import com.heyanle.easybangumi.multi.logger.KotlinLogger
import com.heyanle.easybangumi.multi.logger.Level
import com.heyanle.easybangumi.multi.logger.Logger
import com.heyanle.easybangumi.multi.path.DesktopPathProvider
import com.heyanle.easybangumi.multi.path.PathProvider
import com.heyanle.inject.api.InjectModule
import com.heyanle.inject.api.addSingletonFactory
import com.heyanle.inject.api.module
import org.jetbrains.skiko.hostArch

/**
 * Created by heyanlin on 2024/4/23.
 */
actual fun getPlatformModules(): List<InjectModule> {
    return listOf(
        module {
            addSingletonFactory<Logger> {
                KotlinLogger(Level.DEBUG)
            }
            addSingletonFactory<Platform> {
                object : Platform {
                    override val name: String = "${System.getProperty("os.name")}, ${System.getProperty("os.version")}, ${hostArch.id}"
                }
            }

            addSingletonFactory<PathProvider> {
                DesktopPathProvider()
            }
        }
    )
}