package com.vladshvyrev.moneytracer.Repository


import com.vladshvyrev.moneytracer.Repository.network.TransactionsList
import retrofit2.Call

interface Repository {
    fun getTransactionList(): Call<TransactionsList>

}