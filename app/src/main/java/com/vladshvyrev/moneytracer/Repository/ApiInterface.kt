package com.vladshvyrev.moneytracer.Repository

import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.Repository.network.TransactionsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("transactions")
    fun getTransactionList(): Call<TransactionsList>
//    @GET("public-api/users/{userId}")
//    fun getUserId(
//        @Path("userId") id: String?,
//        @Query("_format") format: String,
//        @Query("access-token") accessToken: String
//
//    ): Call<UserResponse>
}