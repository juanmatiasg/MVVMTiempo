package com.example.mvmmtiempo.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvmmtiempo.R
import kotlinx.android.synthetic.main.rv_location_child.view.*

class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.tv_location_name)
    val latLang = view.findViewById<TextView>(R.id.tv_lat_lng)
    val rootView = view.child_root
}
