package com.heyanle.easybangumi.mul.source_api.entity


/**
 * Created by HeYanLe on 2023/10/18 23:19.
 * https://github.com/heyanLE
 */
class SCartoonImpl(
    override var id: String,
    override var source: String,
    override var url: String,
    override var title: String,
    override var genre: String? = null,
    override var coverUrl: String? = null,

    override var intro: String? = null,
    override var description: String? = null,

    override var updateStrategy: Int = SCartoon.UPDATE_STRATEGY_ALWAYS,
    override var isUpdate: Boolean = false,
    override var status: Int = SCartoon.STATUS_UNKNOWN,
) : SCartoon {

    private var genres: List<String>? = null

    override fun getGenres(): List<String>? {
        if(genre == null){
            return null
        }
        if(genres == null){
            genres = super.getGenres()
        }
        return genres
    }


}