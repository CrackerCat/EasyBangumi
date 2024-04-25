package com.heyanle.easybangumi.mul.source_api.entity



/**
 * Created by HeYanLe on 2023/2/18 21:54.
 * https://github.com/heyanLE
 */

open class SPlayLine(
    val id: String, // 源自己维护和判断
    val label: String,
    val SEpisodes: ArrayList<SEpisode>,
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SPlayLine

        if (id != other.id) return false
        if (label != other.label) return false
        if (SEpisodes != other.SEpisodes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + label.hashCode()
        result = 31 * result + SEpisodes.hashCode()
        return result
    }
}


open class SEpisode(
    val id: String, // 源自己维护和判断
    val label: String,
    val order: Int, // 第几集，用来排序，都一致就按照 PlayLine 中顺序
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SEpisode

        if (id != other.id) return false
        if (label != other.label) return false
        if (order != other.order) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + label.hashCode()
        result = 31 * result + order
        return result
    }
}


