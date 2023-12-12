package com.example.lokal_assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>(){
    class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.prod_image_iv)
        val title_tv = view.findViewById<TextView>(R.id.prod_title_tv)
        val rating_tv = view.findViewById<TextView>(R.id.prod_rating_tv)
        val v = view
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.v.setOnClickListener{
            Toast.makeText(context, "Position - $position", Toast.LENGTH_SHORT).show()
        }
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