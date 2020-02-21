package com.vladshvyrev.moneytracer.Repository

import com.vladshvyrev.moneytracer.Repository.network.TransactionsList

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRepository private constructor() : Repository {

    init {
        createApi()
    }
    companion object {
        private var repo: RemoteRepository? = null
        fun getInstance(): RemoteRepository {

            if (repo == null) {
                repo = RemoteRepository()
            }
            return repo!!
        }
    }
    private lateinit var api: ApiInterface
//    private val token = "cO0vWxovDeIx1B0QdMhpBN3gTnJ4_Wu9Kemq"
//    private val format = "json"

    override fun getTransactionList(): Call<TransactionsList> = api.getTransactionList()

//    override fun getUserId(id: String?): Call<UserResponse> = api.getUserId(
//        id,
//        format,
//        token
//    )

    private fun createApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build())
            .build()
        api = retrofit.create(ApiInterface::class.java)
    }
}