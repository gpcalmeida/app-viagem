package com.viajabessa.viajabessaapp.activity.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.viajabessa.viajabessaapp.R

class SplashActivity : AppCompatActivity() {

    val presenter = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter?.getPhoneInfo()

        presenter?.startAnimation()

        presenter?.startCountDown()
    }


}