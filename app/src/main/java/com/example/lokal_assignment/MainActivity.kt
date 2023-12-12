package com.example.lokal_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prod_list_recyclerview = findViewById<RecyclerView>(R.id.prod_list_recyclerview)
        prod_list_recyclerview.layoutManager = LinearLayoutManager(this)
        prod_list_recyclerview.adapter = RecyclerViewAdapter()

    }
}