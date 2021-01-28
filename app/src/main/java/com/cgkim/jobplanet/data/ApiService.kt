package com.cgkim.jobplanet.data

import retrofit2.http.GET

interface ApiService {
    // 서버와 통신하여 데이터를 가져옴
    @GET("/mobile-config/test_data.json")
    suspend fun getItems(): DataModel
}