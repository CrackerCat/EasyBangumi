package com.heyanle.easybangumi.multi.path

import org.jetbrains.skiko.OS
import org.jetbrains.skiko.hostOs
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

/**
 * Created by heyanlin on 2024/4/26.
 */
class DesktopPathProvider : PathProvider {

    override val applicationFiles: String by lazy {
        when (hostOs) {
            OS.Windows -> Path( System.getenv("FOLDERID_LocalAppData"), "com.heyanle.easybangumi.multi", "data").absolutePathString()
            OS.Linux ->  Path(System.getenv("HOME"), ".local", "share", "com.heyanle.easybangumi.multi").absolutePathString()
            OS.MacOS -> Path(System.getenv("HOME"), "Library", "Application Support", "com.heyanle.easybangumi.multi").absolutePathString()
            else -> throw IllegalStateException("Unsupported OS: $hostOs")
        }
    }
    override val applicationCache: String by lazy {
        when (hostOs) {
            OS.Windows -> Path( System.getenv("FOLDERID_LocalAppData"), "com.heyanle.easybangumi.multi", "cache").absolutePathString()
            OS.Linux ->  Path(System.getenv("HOME"), ".cache", "com.heyanle.easybangumi.multi").absolutePathString()
            OS.MacOS -> Path(System.getenv("HOME"), "Library", "Caches", "com.heyanle.easybangumi.multi").absolutePathString()
            else -> throw IllegalStateException("Unsupported OS: $hostOs")
        }
    }
}