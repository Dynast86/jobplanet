package com.cgkim.jobplanet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CellTypeCompany(
    var ranking: Int,
    var interview_difficulty: Int,
    var name: String,
    var salary_avg: Int,
    var web_site: String,
    var logo_path: String,
    var interview_question: String,
    var company_id: Int,
    var has_job_posting: Boolean,
    var rate_total_avg: Float,
    var industry_id: Int,
    var review_summary: String,
    var type: String,
    var industry_name: String,
    var simple_desc: String
) : Parcelable