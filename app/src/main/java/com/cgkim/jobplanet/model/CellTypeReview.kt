package com.cgkim.jobplanet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CellTypeReview(
    var ranking: Int,
    var cons: String,
    var name: String,
    var days_ago: Int,
    var logo_path: String,
    var pros: String,
    var company_id: Int,
    var occupation_name: String,
    var rate_total_avg: Float,
    var industry_id: Int,
    var date: String,
    var review_summary: String,
    var type: String,
    var industry_name: String,
    var simple_desc: String
) : Parcelable
