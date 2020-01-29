package com.viajabessa.viajabessaapp.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.viajabessa.viajabessaapp.model.Destination
import com.viajabessa.viajabessaapp.R
import com.viajabessa.viajabessaapp.activity.details.DetailsActivity
import kotlinx.android.synthetic.main.item_view.view.*
import android.content.Intent
import android.support.v4.content.ContextCompat


class MyAdapter(private val myDataSet: ArrayList<Destination>?) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false) as CardView
        return MyViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(position%2 == 0) {
            holder.cardView.relative_card.setBackgroundColor(ContextCompat.getColor(holder.cardView.context,R.color.transparent_blue))
        }
        holder.cardView.price.text = myDataSet!![position].price
        holder.cardView.location.text = myDataSet[position].location
        var url = myDataSet[position].image_url
        Picasso.get().load(url).into(holder.cardView.image)

        holder.cardView.setOnClickListener {
            val i = Intent(holder.cardView.context, DetailsActivity::class.java)
            i.putExtra("image_url", myDataSet[position].image_url)
            i.putExtra("location", myDataSet[position].location)
            i.putExtra("price", myDataSet[position].price)
            i.putExtra("description",myDataSet[position].desc)
            holder.cardView.context.startActivity(i)
        }

    }

    override fun getItemCount() = myDataSet!!.size

}