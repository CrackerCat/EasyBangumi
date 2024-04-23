package module

import com.heyanle.inject.api.InjectModule

/**
 * Created by heyanlin on 2024/4/23.
 */

actual fun getPlatformRootModules(): List<InjectModule> {
    return listOf()
}

actual fun getPlatformModules(): List<InjectModule> {
    return listOf()
}