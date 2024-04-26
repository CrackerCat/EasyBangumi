package com.heyanle.easybangumi.multi.module


import android.os.Build
import com.heyanle.easybangumi.multi.EasyApplication
import com.heyanle.easybangumi.multi.Platform
import com.heyanle.inject.api.InjectModule
import com.heyanle.inject.api.addSingletonFactory
import com.heyanle.inject.api.module
import com.heyanle.easybangumi.multi.logger.AndroidLogger
import com.heyanle.easybangumi.multi.logger.Level
import com.heyanle.easybangumi.multi.logger.Logger
import com.heyanle.easybangumi.multi.path.AndroidPathProvider
import com.heyanle.easybangumi.multi.path.PathProvider


/**
 * Created by heyanlin on 2024/4/23.
 */
actual fun getPlatformModules(): List<InjectModule> {
    return listOf(
        module {
            addSingletonFactory<PathProvider> {
                AndroidPathProvider(EasyApplication.APP)
            }
            addSingletonFactory<Logger> {
                AndroidLogger(Level.DEBUG)
            }
            addSingletonFactory<Platform> {
                object : Platform {
                    override val name: String = "Android ${Build.VERSION.SDK_INT}"
                }
            }
        }
    )
}
