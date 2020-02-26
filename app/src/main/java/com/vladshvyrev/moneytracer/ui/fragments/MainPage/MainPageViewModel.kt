package com.vladshvyrev.moneytracer.ui.fragments.MainPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladshvyrev.moneytracer.Repository.RemoteRepository
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPageViewModel: ViewModel() {
    private val repository = RemoteRepository.getInstance()
    val userListLiveData = MutableLiveData<List<ItemForListTransaction>>()
fun getTransactionList()
{
repository.getTransactionList()
    .enqueue(object: Callback<List<ItemForListTransaction>>{
    override fun onFailure(call: Call<List<ItemForListTransaction>>, t: Throwable) {

    }

    override fun onResponse(call: Call<List<ItemForListTransaction>>,
                            response: Response<List<ItemForListTransaction>>
    ) {
        userListLiveData.postValue(response.body())
    }
}
)
}
}