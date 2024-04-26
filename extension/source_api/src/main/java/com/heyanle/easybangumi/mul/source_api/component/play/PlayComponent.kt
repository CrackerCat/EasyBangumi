package com.heyanle.easybangumi.mul.source_api.component.play


import com.heyanle.easybangumi.mul.source_api.SourceResult
import com.heyanle.easybangumi.mul.source_api.component.Component
import com.heyanle.easybangumi.mul.source_api.entity.SCartoonSummary
import com.heyanle.easybangumi.mul.source_api.entity.SEpisode
import com.heyanle.easybangumi.mul.source_api.entity.SPlayLine
import com.heyanle.easybangumi.mul.source_api.entity.SPlayerInfo

/**
 * Created by HeYanLe on 2023/10/18 23:28.
 * https://github.com/heyanLE
 */
interface PlayComponent: Component {

    /**
     * 获取播放信息
     * @param SPlayLine 对应的播放线路
     * @param SEpisode 集
     */
    suspend fun getPlayInfo(
        summary: SCartoonSummary,
        SPlayLine: SPlayLine,
        SEpisode: SEpisode,
    ): SourceResult<SPlayerInfo>
}