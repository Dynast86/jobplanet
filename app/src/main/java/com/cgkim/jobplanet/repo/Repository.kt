package com.cgkim.jobplanet.repo

import com.cgkim.jobplanet.data.ItemsModel

interface Repository {
    suspend fun getItems(): List<ItemsModel>
}