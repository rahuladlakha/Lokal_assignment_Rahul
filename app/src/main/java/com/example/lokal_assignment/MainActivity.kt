package com.example.lokal_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Products"

        //Fetches the JSON response from endpoint using Retrofit
        getDataFromApi()
    }
    fun getDataFromApi(){ //fetches JSON response from endpoint using Retrofit
        //Using retrofit to obtain JSON response from endpoint as Kotlin objects
        RetrofitHelper.productsApi.getProducts().enqueue(object : Callback<ProductsList?> {
            override fun onResponse(call: Call<ProductsList?>, response: Response<ProductsList?>) {
                val prod_list_recyclerview = findViewById<RecyclerView>(R.id.prod_list_recyclerview)
                prod_list_recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                prod_list_recyclerview.adapter = RecyclerViewAdapter(this@MainActivity, response.body()?.products)
            }
            override fun onFailure(call: Call<ProductsList?>, t: Throwable) {
                Log.e("ApiCall", t.localizedMessage)
            }
        }
        )
    }
}