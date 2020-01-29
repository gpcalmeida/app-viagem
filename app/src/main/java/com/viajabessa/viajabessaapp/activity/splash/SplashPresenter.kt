package com.viajabessa.viajabessaapp.activity.splash

import com.viajabessa.viajabessaapp.activity.main.MainActivity
import android.content.Intent
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import com.jaredrummler.android.device.DeviceName
import com.viajabessa.viajabessaapp.R
import kotlinx.android.synthetic.main.activity_splash.*
import android.os.Build

class SplashPresenter(val activity: SplashActivity){

    private var manufacturer = ""
    private var phoneName = ""
    private var model = ""
    private var androidSdk = 0

    fun startMain(){
        val i = Intent(activity, MainActivity::class.java)
        activity.startActivity(i)
        activity.finish()
    }

    fun startCountDown(){
        var handler = Handler()
        var r  = Runnable {
            startMain()
        }
        handler.postDelayed(r,2900)
    }

    fun startAnimation(){
        val anim = AnimationUtils.loadAnimation(activity, R.anim.blink)
        anim.interpolator = LinearInterpolator()
        anim.repeatCount = Animation.ABSOLUTE
        anim.duration = 3000

        activity.splash_image.startAnimation(anim)
    }

    fun getPhoneInfo() {
        val androidOS = Build.VERSION.RELEASE

        DeviceName.with(activity).request { info, error ->
            this.manufacturer = info.manufacturer
            this.phoneName = info.marketName
            this.model = info.model
        }
    }
}