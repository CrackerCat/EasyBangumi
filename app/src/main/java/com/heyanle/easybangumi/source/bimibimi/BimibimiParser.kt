package com.heyanle.easybangumi.source.bimibimi

import com.heyanle.easybangumi.EasyApplication
import com.heyanle.easybangumi.R
import com.heyanle.easybangumi.entity.Bangumi
import com.heyanle.easybangumi.entity.BangumiDetail
import com.heyanle.easybangumi.source.IBangumiDetailParser
import com.heyanle.easybangumi.source.IHomeParser
import com.heyanle.easybangumi.source.IParser
import com.heyanle.easybangumi.source.IPlayUrlParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

/**
 * Created by HeYanLe on 2021/9/20 21:48.
 * https://github.com/heyanLE
 */
class BimibimiParser: IParser, IHomeParser, IBangumiDetailParser, IPlayUrlParser {

    companion object{
        const val ROOT_URL = "http://bimiacg2.net"
    }

    private fun url(source: String): String{
        return when {
            source.startsWith("http") -> {
                source
            }
            source.startsWith("/") -> {
                ROOT_URL + source
            }
            else -> {
                "$ROOT_URL/$source"
            }
        }
    }

    override fun getKey(): String {
        return "Bimibimi"
    }

    override fun getLabel(): String {
        return "Bimibimi"
    }

    override suspend fun home(): LinkedHashMap<String, List<Bangumi>> {
        return withContext(Dispatchers.IO){
            val map = LinkedHashMap<String, List<Bangumi>>()
            kotlin.runCatching {
                val doc = Jsoup.connect(ROOT_URL).timeout(10000)
                    .userAgent(EasyApplication.INSTANCE.getString(R.string.UA))
                    .get()
                val elements = doc.getElementsByClass("area-cont")

                fun load(element:Element){
                    val columnTitle = element.getElementsByClass("title")[0].child(1).text()
                    val uls = element.getElementsByClass("tab-cont")
                    val list = arrayListOf<Bangumi>()
                    val ul = uls[0]
                    ul.children().forEach { ele ->
                        val detailUrl =  url(ele.child(0).attr("href"))
                        val imgUrl = url(ele.getElementsByTag("img")[0].attr("src"))
                        val title = ele.child(1).child(0).text()
                        val intro = ele.child(1).child(1).text()
                        val bangumi = Bangumi(
                            id = "${getLabel()}-$detailUrl",
                            source = getKey(),
                            name = title,
                            cover = imgUrl,
                            intro = intro,
                            detailUrl = detailUrl,
                            visitTime = System.currentTimeMillis()
                        )
                        list.add(bangumi)
                    }
                    map[columnTitle] = list

                }

                // 今日热播
                load(elements[0])

                // 新番放送
                load(elements[1])

                // 大陆动漫
                load(elements[2])

                // 番组计划
                load(elements[3])

                // 剧场动画
                load(elements[4])




            }.onFailure {
                it.printStackTrace()
            }

            return@withContext map
        }

    }

    override suspend fun detail(bangumi: Bangumi): BangumiDetail? {
        return withContext(Dispatchers.IO) {
            kotlin.runCatching {
                val doc = Jsoup.connect(bangumi.detailUrl).timeout(10000)
                    .userAgent(EasyApplication.INSTANCE.getString(R.string.UA))
                    .get()
                val description = doc.getElementsByClass("vod-jianjie")[0].text()
                return@withContext BangumiDetail(
                    id = bangumi.id,
                    source = getKey(),
                    name = bangumi.name,
                    cover = bangumi.cover,
                    intro = bangumi.intro,
                    detailUrl = bangumi.detailUrl,
                    description = description
                )
            }.onFailure {
                it.printStackTrace()
            }
            null
        }
    }

    override suspend fun getBangumiPlaySource(bangumi: Bangumi): LinkedHashMap<String, List<String>> {
        return withContext(Dispatchers.IO) {
            val map = LinkedHashMap<String, List<String>>()
            kotlin.runCatching {
                val doc = Jsoup.connect(bangumi.detailUrl).timeout(10000)
                    .userAgent(EasyApplication.INSTANCE.getString(R.string.UA))
                    .get()
                val sourceDiv = doc.getElementsByClass("play_source_tab")[0]
                val ite = sourceDiv.getElementsByTag("a").iterator()
                val playBoxIte = doc.getElementsByClass("play_box").iterator()
                while(ite.hasNext() && playBoxIte.hasNext()){
                    val sourceA = ite.next()
                    val list = arrayListOf<String>()

                    val playBox = playBoxIte.next()
                    playBox.getElementsByTag("a").forEach {
                        list.add(it.text())
                    }

                    map[sourceA.text()] = list
                }
            }.onFailure {
                it.printStackTrace()
            }
            map
        }
    }

    override suspend fun getBangumiPlayUrl(
        bangumi: Bangumi,
        lineIndex: Int,
        episodes: Int
    ): String {
        return ""
    }
}