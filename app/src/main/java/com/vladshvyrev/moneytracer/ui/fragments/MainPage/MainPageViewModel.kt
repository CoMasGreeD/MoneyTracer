package com.vladshvyrev.moneytracer.ui.fragments.MainPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladshvyrev.moneytracer.Repository.RemoteRepository
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.Repository.network.TransactionsList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPageViewModel: ViewModel() {
    private val repository = RemoteRepository.getInstance()
    val userListLiveData = MutableLiveData<TransactionsList>()
fun getTransactionList()
{
repository.getTransactionList().enqueue(
object: Callback<TransactionsList>{
    override fun onFailure(call: Call<TransactionsList>, t: Throwable) {

    }

    override fun onResponse(call: Call<TransactionsList>,
                            response: Response<TransactionsList>
    ) {
        userListLiveData.postValue(response.body())
    }
}
)
}
}