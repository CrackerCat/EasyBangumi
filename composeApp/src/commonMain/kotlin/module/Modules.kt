package module

import com.heyanle.inject.api.InjectModule

/**
 * Created by heyanlin on 2024/4/23.
 */
expect fun getPlatformRootModules(): List<InjectModule>
expect fun getPlatformModules(): List<InjectModule>