package module

import Platform
import com.heyanle.inject.api.InjectModule
import com.heyanle.inject.api.addSingletonFactory
import com.heyanle.inject.api.module
import logger.Level
import logger.Logger
import logger.SLF4JLogger
import java.nio.file.Paths
import kotlin.io.path.absolutePathString

/**
 * Created by heyanlin on 2024/4/23.
 */
actual fun getPlatformModules(): List<InjectModule> {
    return listOf(
        module {
            addSingletonFactory<Logger> {
                SLF4JLogger(Level.DEBUG)
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