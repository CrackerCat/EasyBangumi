package com.heyanle.easybangumi.mul.source_api.component.play


import com.heyanle.easybangumi.mul.source_api.SourceResult
import com.heyanle.easybangumi.mul.source_api.component.Component
import com.heyanle.easybangumi.mul.source_api.entity.CartoonSummary
import com.heyanle.easybangumi.mul.source_api.entity.Episode
import com.heyanle.easybangumi.mul.source_api.entity.PlayLine
import com.heyanle.easybangumi.mul.source_api.entity.PlayerInfo

/**
 * Created by HeYanLe on 2023/10/18 23:28.
 * https://github.com/heyanLE
 */
interface PlayComponent: Component {

    /**
     * 获取播放信息
     * @param playLine 对应的播放线路
     * @param episode 集
     */
    suspend fun getPlayInfo(
        summary: CartoonSummary,
        playLine: PlayLine,
        episode: Episode,
    ): SourceResult<PlayerInfo>
}