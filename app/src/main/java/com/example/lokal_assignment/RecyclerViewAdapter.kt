package com.example.lokal_assignment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(val context: Context, val products : List<Product>?) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>(){
    class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.thumbnail_iv)
        val title_tv = view.findViewById<TextView>(R.id.prod_title_tv)
        val rating_tv = view.findViewById<TextView>(R.id.prod_rating_tv)
        val price_tv = view.findViewById<TextView>(R.id.price_tv)
        val v = view
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        if (products == null) return
        holder.title_tv.text = products[position].title
        holder.rating_tv.text = "Rating: ${products[position].rating}/5"
        holder.price_tv.text = "$${products[position].price}"
        holder.v.setOnClickListener{
            val intent = Intent(context, ProductActivity::class.java)
            ProductActivity.product = products[position]
            context.startActivity(intent)
        }
        Glide.with(context).load(products[position].thumbnail).into(holder.imageView)
    }
    override fun getItemCount(): Int {
        return products?.size ?: 0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.prod_recyclerview_layout, parent, false)
        return CustomViewHolder(view)
    }

}