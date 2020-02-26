package com.vladshvyrev.moneytracer.ui.fragments.CreateNewTransaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladshvyrev.moneytracer.Repository.RemoteRepository
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateNewTransactionViewModel: ViewModel() {
    private val repository = RemoteRepository.getInstance()
    val userListLiveData = MutableLiveData<ItemForListTransaction>()
    fun postTransaction(tr:ItemForListTransaction)
    {
        repository.postTransaction(tr)
            .enqueue(object: Callback<ItemForListTransaction>{
                override fun onFailure(call: Call<ItemForListTransaction>, t: Throwable) {

                }

                override fun onResponse(call: Call<ItemForListTransaction>,
                                        response: Response<ItemForListTransaction>
                ) {
                    if (response.isSuccessful()) {
                        println(("response " + response.body()))
                    } else {
                        println("response code " + response.code())
                    }
                    userListLiveData.postValue(response.body())
                }
            }
            )
    }
}