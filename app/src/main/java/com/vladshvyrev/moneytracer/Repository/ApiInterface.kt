package com.vladshvyrev.moneytracer.Repository

import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("CoMasGreeD/CoMaGreeD-repo/transactions")
    fun getTransactionList(): Call<List<ItemForListTransaction>>
    @POST("CoMasGreeD/CoMaGreeD-repo/transactions")
    fun postTransaction(
       @Body tr : ItemForListTransaction
    ): Call<ItemForListTransaction>
}