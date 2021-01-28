package com.cgkim.jobplanet.repo

import com.cgkim.jobplanet.data.ApiService

class RepositoryImpl(private val service: ApiService) : Repository {
    override suspend fun getItems() = service.getItems().items
}