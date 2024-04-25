package com.heyanle.easybangumi.multi.data

import com.heyanle.easybangumi.multi.base.utils.jsonTo
import com.heyanle.easybangumi.multi.entity.DCartoonInfo

/**
 * Created by heyanlin on 2024/4/25.
 */
data class CartoonInfo(
    // finder
    val id: String,
    val sourceKey: String,

    // cover
    val name: String,
    val cover: String,
    val intro: String,
    val url: String,

    // detailed
    val isDetailedLoaded: Boolean,
    val genre: String,
    val description: String,
    val year: Long,
    val month: Long,
    val updateStrategy: CartoonInfo.UpdateStrategy,
    val isUpdate: Boolean,
    val status: CartoonInfo.CartoonStatus,
    val lastUpdateTime: Long,

    val isPlayLineLoad: Boolean,
    val playLineJson: String,
    val isShowLine: Boolean,

    // preference
    val isReversal: Boolean,
    val episodeSortKey: Long,
    val tagList: String,

    // star
    val starTime: Long,
    val pinTime: Long,

    // history
    val lastHistoryUpdateTime: Long,
    val lastHistoryWatchTime: Long,
    val lastLineId: String,
    val lastLineName: String,
    val lastEpisodeIndex: Long,
    val lastEpisodeCount: Long,
    val lastEpisodeId: String,
    val lastEpisodeName: String,
    val lastProgressTime: Long,
    val sourceName: String,

    // cache
    val extra: String,
    val createdAt: Long,
    val modifiedAt: Long,
) {
    enum class UpdateStrategy {
        ALWAYS, ONLY_STRICT, NEVER
    }

    enum class CartoonStatus {
        UNKNOWN, ONGOING, FINISHED
    }

    val playLine: List<CartoonPlayLine> by lazy {
        playLineJson.jsonTo() ?: emptyList()
    }

    val genreList: List<String> by lazy {
        genre.split(",").map { it.trim() }
    }

    val tagListList: List<String> by lazy {
        tagList.split(",").map { it.trim() }
    }

}

    fun DCartoonInfo.toCartoonInfo() =
        CartoonInfo(
            id = this.id,
            sourceKey = this.source_key,
            name = this.name,
            cover = this.cover,
            intro = this.intro,
            url = this.url,
            isDetailedLoaded = this.is_detailed_loaded,
            genre = this.genre,
            description = this.description,
            year = this.year,
            month = this.month,
            updateStrategy = this.update_strategy,
            isUpdate = this.is_update,
            status = this.status,
            lastUpdateTime = this.last_update_time,
            isPlayLineLoad = this.is_play_line_load,
            playLineJson = this.play_line_json,
            isShowLine = this.is_show_line,
            isReversal = this.is_reversal,
            episodeSortKey = this.episode_sort_key,
            tagList = this.tag_list,
            starTime = this.star_time,
            pinTime = this.pin_time,
            lastHistoryUpdateTime = this.last_history_update_time,
            lastHistoryWatchTime = this.last_history_watch_time,
            lastLineId = this.last_line_id,
            lastLineName = this.last_line_name,
            lastEpisodeIndex = this.last_episode_index,
            lastEpisodeCount = this.last_episode_count,
            lastEpisodeId = this.last_episode_id,
            lastEpisodeName = this.last_episode_name,
            lastProgressTime = this.last_progress_time,
            sourceName = this.source_name,
            extra = this.extra,
            createdAt = this.created_at,
            modifiedAt = this.modified_at,

            )

    fun CartoonInfo.toDCartoonInfo(): DCartoonInfo =
        DCartoonInfo(
            id = id,
            source_key = sourceKey,
            name = name,
            cover = cover,
            intro = intro,
            url = url,
            is_detailed_loaded = isDetailedLoaded,
            genre = genre,
            description = description,
            year = year,
            month = month,
            update_strategy = updateStrategy,
            is_update = isUpdate,
            status = status,
            last_update_time = lastUpdateTime,
            is_play_line_load = isPlayLineLoad,
            play_line_json = playLineJson,
            is_show_line = isShowLine,
            is_reversal = isReversal,
            episode_sort_key = episodeSortKey,
            tag_list = tagList,
            star_time = starTime,
            pin_time = pinTime,
            last_history_update_time = lastHistoryUpdateTime,
            last_history_watch_time = lastHistoryWatchTime,
            last_line_id = lastLineId,
            last_line_name = lastLineName,
            last_episode_index = lastEpisodeIndex,
            last_episode_count = lastEpisodeCount,
            last_episode_id = lastEpisodeId,
            last_episode_name = lastEpisodeName,
            last_progress_time = lastProgressTime,
            source_name = sourceName,
            extra = extra,
            created_at = createdAt,
            modified_at = modifiedAt,
        )