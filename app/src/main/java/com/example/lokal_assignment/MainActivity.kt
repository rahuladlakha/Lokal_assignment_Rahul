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

        val prod_list_recyclerview = findViewById<RecyclerView>(R.id.prod_list_recyclerview)
        prod_list_recyclerview.layoutManager = LinearLayoutManager(this)
        prod_list_recyclerview.adapter = RecyclerViewAdapter(this)

        getDataFromApi()
    }
    fun getDataFromApi(){
        //Using retrofit to obtain JSON response from endpoint as Kotlin objects
        RetrofitHelper.productsApi.getProducts().enqueue(object : Callback<ProductsList?> {
            override fun onResponse(call: Call<ProductsList?>, response: Response<ProductsList?>) {
                Log.i("ApiCall", response.body()?.products.toString())
                Toast.makeText(this@MainActivity, response.body()?.products.toString(), Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<ProductsList?>, t: Throwable) {
                Log.e("ApiCall", t.localizedMessage)
            }
        }
        )
    }
}