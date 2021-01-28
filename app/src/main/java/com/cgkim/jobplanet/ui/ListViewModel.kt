package com.cgkim.jobplanet.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cgkim.jobplanet.data.ItemsModel
import com.cgkim.jobplanet.repo.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(repository: Repository) : ViewModel() {

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    var itemList: MutableLiveData<List<ItemsModel>> = MutableLiveData()

    val searchByKeyWord = fun(_: String) {
        if (isLoading() == true)
            return

        loading(true)
        CoroutineScope(Dispatchers.Main).launch {
            itemList.value = repository.getItems()
            loading(false)
        }
    }

    init {
        loading(false)
    }

    private fun loading(bool: Boolean) {
        isLoading.value = bool
    }

    fun isLoading(): Boolean? {
        return isLoading.value
    }
}