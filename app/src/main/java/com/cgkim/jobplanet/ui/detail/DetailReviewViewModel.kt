package com.cgkim.jobplanet.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cgkim.jobplanet.model.CellTypeReview

class DetailReviewViewModel : ViewModel() {
    var data = MutableLiveData<CellTypeReview>()
}