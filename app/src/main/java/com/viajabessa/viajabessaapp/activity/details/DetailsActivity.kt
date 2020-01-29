package com.viajabessa.viajabessaapp.activity.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.squareup.picasso.Picasso
import com.viajabessa.viajabessaapp.R
import com.viajabessa.viajabessaapp.R.id.location_image
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    var presenter : DetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = DetailsPresenter(this)

        var imageUrl = intent.extras["image_url"] as String
        var location = intent.extras["location"] as String
        var price = intent.extras["price"] as String
        var desc = intent.extras["description"] as String

        presenter!!.insertInfo(imageUrl,location,price,desc)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}