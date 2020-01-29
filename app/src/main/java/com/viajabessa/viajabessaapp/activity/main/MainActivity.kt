package com.viajabessa.viajabessaapp.activity.main

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jaredrummler.android.device.DeviceName
import com.viajabessa.viajabessaapp.R
import com.viajabessa.viajabessaapp.adapter.MyAdapter
import com.viajabessa.viajabessaapp.httpClient.RetrofitConfiguration
import com.viajabessa.viajabessaapp.model.Destination
import com.viajabessa.viajabessaapp.model.PhoneInfo
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val androidOS = Build.VERSION.RELEASE
        var phoneModel : String
        var manufacturer : String

        DeviceName.with(this).request { info, error ->
            phoneModel = info.marketName
            manufacturer = info.manufacturer
            presenter.postPhoneInfo(PhoneInfo(phoneModel,manufacturer,androidOS))
        }

        swipe_refresh.setOnRefreshListener {
            presenter.onRefreshPush()
        }

    }

}
