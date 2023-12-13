package com.example.lokal_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductActivity : AppCompatActivity() {
    companion object{
        var product : Product? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        supportActionBar?.hide()

        val title_tv = findViewById<TextView>(R.id.prod_title_tv)
        val rating_tv = findViewById<TextView>(R.id.prod_rating_tv)
        val thumbnail_iv = findViewById<ImageView>(R.id.thumbnail_iv)
        val price_tv = findViewById<TextView>(R.id.price_tv)
        val des_tv = findViewById<TextView>(R.id.des_tv)
        title_tv.text = product?.title
        rating_tv.text = "Rating: ${product?.rating}/5"
        price_tv.text = "$${product?.price}"
        des_tv.text = "Description:\n${product?.description}"
        Glide.with(this).load(product?.thumbnail).into(thumbnail_iv)

        val img_recyclerview = findViewById<RecyclerView>(R.id.image_recyclerview)
        img_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        img_recyclerview.adapter = ImageRecyclerViewAdapter(this, product?.images)

    }

}