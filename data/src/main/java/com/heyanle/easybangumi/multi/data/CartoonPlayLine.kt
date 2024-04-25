package com.heyanle.easybangumi.multi.data

/**
 * Created by heyanlin on 2024/4/25.
 */
data class CartoonPlayLine(
    val id: String,
    val label: String,
    val episodes: List<CartoonEpisode>,
)

data class CartoonEpisode(
    val id: String,
    val label: String,
    val order: Int,
)