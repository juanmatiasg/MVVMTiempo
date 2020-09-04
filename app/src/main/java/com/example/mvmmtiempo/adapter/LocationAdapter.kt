package com.example.mvmmtiempo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvmmtiempo.R
import com.example.mvmmtiempo.network.model.Location
import com.example.mvmmtiempo.view.DetailsActivity

class LocationAdapter(): RecyclerView.Adapter<ViewHolder>(){
    private var list:List<Location> = ArrayList()

    fun setLocation(list:List<Location>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.rv_location_child, parent, false))    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(list.get(position).title)
        holder.latLang.setText(list.get(position).latt_long)
        holder.rootView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View) {
                val intent = Intent(v.context,DetailsActivity::class.java)
                intent.putExtra("Location",list[position].woeid)
                intent.putExtra("name",list[position].title)
                v.context.startActivity(intent)
            }

        })
    }


}