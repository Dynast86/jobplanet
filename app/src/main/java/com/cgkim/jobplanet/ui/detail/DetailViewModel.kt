package com.cgkim.jobplanet.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    val title: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val rateAvg: MutableLiveData<Float> by lazy {
        MutableLiveData()
    }

    val imageUrl: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val industryName: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val occupationName: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    var reviewSummary = MutableLiveData<String>()
    var type = MutableLiveData<String>()
}