package com.example.lokal_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>(){
    class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.prod_image_iv)
        val title_tv = view.findViewById<TextView>(R.id.prod_title_tv)
        val rating_tv = view.findViewById<TextView>(R.id.prod_rating_tv)
}
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

    }
    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.prod_recyclerview_layout, parent, false)
        return CustomViewHolder(view)
    }
}