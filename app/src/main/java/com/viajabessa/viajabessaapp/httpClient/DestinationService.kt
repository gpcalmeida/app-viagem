package com.viajabessa.viajabessaapp.httpClient


import com.viajabessa.viajabessaapp.model.Destination
import com.viajabessa.viajabessaapp.model.PhoneInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

public interface DestinationService{

    @GET("destinations")
     fun getAllDestinations() : Call<ArrayList<Destination>>

    @POST("destinations")
    fun postPhoneInfo(@Body info : PhoneInfo) : Call<ArrayList<Destination>>
}