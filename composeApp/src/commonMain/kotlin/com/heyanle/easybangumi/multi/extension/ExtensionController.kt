package com.heyanle.easybangumi.multi.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by heyanlin on 2024/4/23.
 */
interface ExtensionController {

    data class ExtensionLoaderState(
        val loading: Boolean,
        val error: Throwable?,
        val extensions: List<Extension>
    )

    val loaderStateFlow: StateFlow<ExtensionLoaderState>

}