package com.viajabessa.viajabessaapp.httpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfiguration{


    private val retrofit = Retrofit.Builder()
            .baseUrl("https://private-71887-viajabessamobicare2.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun destinationService() = retrofit.create(DestinationService::class.java)



}