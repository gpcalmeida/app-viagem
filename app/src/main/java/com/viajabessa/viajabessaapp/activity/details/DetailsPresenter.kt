package com.viajabessa.viajabessaapp.activity.details

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsPresenter(var activity: DetailsActivity){

    fun insertInfo(imageUrl : String, location : String, price : String, desc : String){
        Picasso.get().load(imageUrl).into(activity.location_image)
        activity.details_location.text = location
        activity.details_price.text = price
        activity.details_price2.text = price
        activity.description.text = desc
    }
}