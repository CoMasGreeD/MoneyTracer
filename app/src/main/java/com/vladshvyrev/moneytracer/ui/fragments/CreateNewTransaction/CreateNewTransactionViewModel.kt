package com.vladshvyrev.moneytracer.ui.fragments.CreateNewTransaction

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladshvyrev.moneytracer.Repository.RemoteRepository
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.ui.fragments.MainPage.MainPageFragment
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
                    if (response.isSuccessful) {



                        tr.name=response.body()!!.name
                        tr.category=response.body()!!.category
                        tr.id=response.body()!!.id
                        tr.income_or_not=response.body()!!.income_or_not
                        tr.money = response.body()!!.money
                        userListLiveData.postValue(tr)
                    } else {
                        println("response code " + response.code())
                    }
                   // userListLiveData.postValue(response.body())
                }
            }
            )
    }
}