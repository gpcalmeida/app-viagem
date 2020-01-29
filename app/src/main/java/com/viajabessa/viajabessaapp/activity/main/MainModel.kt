package com.viajabessa.viajabessaapp.activity.main

import com.viajabessa.viajabessaapp.httpClient.RetrofitConfiguration
import com.viajabessa.viajabessaapp.model.Destination
import com.viajabessa.viajabessaapp.model.PhoneInfo
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel(var presenter: MainPresenter){

    fun getDestinations() {
        var list : ArrayList<Destination>? = null

        val call = RetrofitConfiguration().destinationService().getAllDestinations()
        call.enqueue(object : Callback<ArrayList<Destination>> {
            override fun onFailure(call: Call<ArrayList<Destination>>?, t: Throwable?) {
                presenter.activity.toast("Não foi possivel carregar a lista de pacotes.")
            }

            override fun onResponse(call: Call<ArrayList<Destination>>?, response: Response<ArrayList<Destination>>?) {
                list = response!!.body()
                presenter.showList(list)
            }

        })
    }

    fun postPhoneInfo(info : PhoneInfo){
        var list : ArrayList<Destination>? = null

        val call = RetrofitConfiguration().destinationService().postPhoneInfo(info)
        call.enqueue(object : Callback<ArrayList<Destination>>{
            override fun onFailure(call: Call<ArrayList<Destination>>?, t: Throwable?) {
                presenter.activity.toast("Não foi possivel carregar a lista de pacotes.")
            }

            override fun onResponse(call: Call<ArrayList<Destination>>?, response: Response<ArrayList<Destination>>?) {
                list = response!!.body()
                presenter.showList(list)
            }

        })
    }
}