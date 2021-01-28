package com.cgkim.jobplanet.data

data class DataModel(
    var minimum_interviews: Int,
    var total_page: Int,
    var minimum_reviews: Int,
    var total_count: Int,

    var page: Int,
    var page_size: Int,
    var minimum_salaries: Int,

    var items: List<ItemsModel>
)

// items의 값이 type따라 달라져서 Any사용
data class ItemsModel(
    var cell_type: String?,
    var cell_object: Any?
)