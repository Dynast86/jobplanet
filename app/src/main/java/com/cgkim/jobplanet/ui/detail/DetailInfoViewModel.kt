package com.cgkim.jobplanet.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cgkim.jobplanet.model.CellTypeCompany

class DetailInfoViewModel : ViewModel() {
    var data = MutableLiveData<CellTypeCompany>()
}