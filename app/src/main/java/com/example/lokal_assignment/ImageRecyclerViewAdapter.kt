package com.example.lokal_assignment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageRecyclerViewAdapter(val context: Context, val images: List<String>?) : RecyclerView.Adapter<ImageRecyclerViewAdapter.CustomViewHolder>() {
    class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.imageView)
    }
    override fun onBindViewHolder(holder: ImageRecyclerViewAdapter.CustomViewHolder, position: Int) {
        if (images == null) return
        Glide.with(context).load(images[position]).into(holder.imageView)
    }
    override fun getItemCount(): Int {
        return images?.size ?: 0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageRecyclerViewAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_image_listview_layout, parent, false)
        return ImageRecyclerViewAdapter.CustomViewHolder(view)
    }
}