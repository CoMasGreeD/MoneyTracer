package com.vladshvyrev.moneytracer.ui.fragments.MainPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction

class MainPageViewModel: ViewModel() {
    val userListLiveData = MutableLiveData<ItemForListTransaction>()

}