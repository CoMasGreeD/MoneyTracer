package com.vladshvyrev.moneytracer.Repository


import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import retrofit2.Call

interface Repository {
    fun getTransactionList(): Call<List<ItemForListTransaction>>
    fun postTransaction(tr :ItemForListTransaction):Call<ItemForListTransaction>

}