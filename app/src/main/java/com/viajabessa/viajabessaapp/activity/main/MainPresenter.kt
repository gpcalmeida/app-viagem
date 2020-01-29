package com.viajabessa.viajabessaapp.activity.main

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.viajabessa.viajabessaapp.adapter.MyAdapter
import com.viajabessa.viajabessaapp.model.Destination
import com.viajabessa.viajabessaapp.model.PhoneInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainPresenter(var activity: MainActivity){

    private var viewManager : RecyclerView.LayoutManager? = null
    private var viewAdapter : RecyclerView.Adapter<*>? = null
    private var model : MainModel? = null

    init{
        model = MainModel(this)
    }

    fun showList(myData : ArrayList<Destination>?) {
        viewManager = LinearLayoutManager(activity)
        viewAdapter = MyAdapter(myData)

        activity.recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
    }

    fun postPhoneInfo(phoneInfo: PhoneInfo)  {
        model?.postPhoneInfo(phoneInfo!!)

    }

    fun onRefreshPush() {
        model!!.getDestinations()
        onRefreshDone()
    }

    fun onRefreshDone(){
        activity.swipe_refresh.isRefreshing = false
    }
}