package com.heyanle.easybangumi.multi.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.heyanle.easybangumi.multi.entity.Cartoon_infoQueries
import com.heyanle.easybangumi.multi.entity.DCartoonInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * Created by heyanlin on 2024/4/25.
 */
class CartoonInfoDao(
    private val queries: Cartoon_infoQueries,
    private val scope: CoroutineScope,
) {

    fun flowAll() = queries.findAll().asFlow().mapToList(scope.coroutineContext).toCartoonInfoFlow()
    fun flowAllHistory() =
        queries.findAllHistory().asFlow().mapToList(scope.coroutineContext).toCartoonInfoFlow()

    fun flowAllStarted() =
        queries.findAllStared().asFlow().mapToList(scope.coroutineContext).toCartoonInfoFlow()

    fun flowByIdentify(id: String, sourceKey: String) =
        queries.findAllByIdentify(id, sourceKey).asFlow().mapToList(scope.coroutineContext)
            .toCartoonInfoFlow()

    fun insertOrReplace(cartoonInfo: CartoonInfo) {
        scope.launch {
            queries.insertOrReplace(cartoonInfo.toDCartoonInfo())
        }
    }

}

fun Flow<List<DCartoonInfo>>.toCartoonInfoFlow() = map { infoList ->
    infoList.map {
        it.toCartoonInfo()
    }
}