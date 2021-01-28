package com.cgkim.jobplanet.data

import com.cgkim.jobplanet.model.CellTypeCompany
import com.cgkim.jobplanet.model.CellTypeHorizontal
import com.cgkim.jobplanet.model.CellTypeReview
import com.cgkim.jobplanet.model.ThemeItem
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

// cell_type에 따라 Object를 새로 생성
class DataDeserializer : JsonDeserializer<DataModel> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): DataModel {
        val jsonObject = json?.asJsonObject ?: throw  NullPointerException("Response Data Null")
        val items = jsonObject["items"]
        val array = items.asJsonArray ?: throw NullPointerException("Items Not Array")

        val minimumInterviews = jsonObject["minimum_interviews"]
        val totalPage = jsonObject["total_page"]
        val minimumReviews = jsonObject["minimum_reviews"]
        val totalCount = jsonObject["total_count"]

        val page = jsonObject["page"]
        val pageSize = jsonObject["page_size"]
        val minimumSalaries = jsonObject["minimum_salaries"]

        val classifyArray: MutableList<ItemsModel> = arrayListOf()
        array.forEach {
            val item = it.asJsonObject
            classifyArray.add(getItemData(item))
        }
        return DataModel(
            minimumInterviews.asInt,
            totalPage.asInt,
            minimumReviews.asInt,
            totalCount.asInt,
            page.asInt,
            pageSize.asInt,
            minimumSalaries.asInt,
            classifyArray
        )
    }

    // 타입별로 오브젝트를 저장
    private fun getItemData(item: JsonObject): ItemsModel {
        when (val type = item["cell_type"].asString) {
            "CELL_TYPE_COMPANY" -> {
                return ItemsModel(
                    type, CellTypeCompany(
                        item["ranking"].asInt,
                        item["interview_difficulty"].asInt,
                        item["name"].asString,
                        item["salary_avg"].asInt,
                        item["web_site"].asString,
                        item["logo_path"].asString,
                        item["interview_question"].asString,
                        item["company_id"].asInt,
                        item["has_job_posting"].asBoolean,
                        item["rate_total_avg"].asFloat,
                        item["industry_id"].asInt,
                        item["review_summary"].asString,
                        item["type"].asString,
                        item["industry_name"].asString,
                        item["simple_desc"].asString
                    )
                )
            }
            "CELL_TYPE_HORIZONTAL_THEME" -> {
                val array = item["themes"].asJsonArray
                val count = item["count"].asInt
                val themeArray = arrayListOf<ThemeItem>()
                for (idx in 0 until count) {
                    val themeItem = array[idx].asJsonObject
                    themeArray.add(
                        ThemeItem(
                            themeItem["color"].asString,
                            themeItem["cover_image"].asString,
                            themeItem["id"].asInt,
                            themeItem["title"].asString
                        )
                    )
                }

                return ItemsModel(
                    type, CellTypeHorizontal(
                        count,
                        themeArray,
                    )
                )
            }
            "CELL_TYPE_REVIEW" -> {
                return ItemsModel(
                    type, CellTypeReview(
                        item["ranking"].asInt,
                        item["cons"].asString,
                        item["name"].asString,
                        item["days_ago"].asInt,
                        item["logo_path"].asString,
                        item["pros"].asString,
                        item["company_id"].asInt,
                        item["occupation_name"].asString,
                        item["rate_total_avg"].asFloat,
                        item["industry_id"].asInt,
                        item["date"].asString,
                        item["review_summary"].asString,
                        item["type"].asString,
                        item["industry_name"].asString,
                        item["simple_desc"].asString
                    )
                )
            }
        }

        return ItemsModel(null, null)
    }
}