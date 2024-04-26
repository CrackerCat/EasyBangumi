package com.heyanle.easybangumi.mul.source_api.component.detailed


import com.heyanle.easybangumi.mul.source_api.SourceResult
import com.heyanle.easybangumi.mul.source_api.component.Component
import com.heyanle.easybangumi.mul.source_api.entity.SCartoon
import com.heyanle.easybangumi.mul.source_api.entity.SCartoonSummary
import com.heyanle.easybangumi.mul.source_api.entity.SPlayLine

/**
 * Created by HeYanLe on 2023/10/18 23:26.
 * https://github.com/heyanLE
 */
interface DetailedComponent: Component {
    class NonPlayLine(
        SPlayLine: SPlayLine
    ): List<SPlayLine> by listOf(SPlayLine)

    /**
     * 获取番剧详细信息
     */
    suspend fun getDetailed(
        summary: SCartoonSummary
    ): SourceResult<SCartoon>

    /**
     * 获取播放线路
     */
    suspend fun getPlayLine(
        summary: SCartoonSummary
    ): SourceResult<List<SPlayLine>>

    /**
     * 同时获取
     */
    suspend fun getAll(
        summary: SCartoonSummary
    ): SourceResult<Pair<SCartoon, List<SPlayLine>>>
}