package module

import Platform
import android.os.Build
import com.heyanle.easy_bangumi_cm.EasyApplication
import com.heyanle.inject.api.InjectModule
import com.heyanle.inject.api.addSingletonFactory
import com.heyanle.inject.api.module
import logger.AndroidLogger
import logger.Level
import logger.Logger

/**
 * Created by heyanlin on 2024/4/23.
 */
actual fun getPlatformModules(): List<InjectModule> {
    return listOf(
        module {
            addSingletonFactory<Logger> {
                AndroidLogger(Level.DEBUG)
            }
            addSingletonFactory<Platform> {
                object : Platform {
                    override val name: String = "Android ${Build.VERSION.SDK_INT}"
                    override val rootDirPath: String
                        get() = EasyApplication.APP.getExternalFilesDir(null)?.absolutePath
                            ?: EasyApplication.APP.cacheDir.absolutePath
                }
            }
        }
    )
}
