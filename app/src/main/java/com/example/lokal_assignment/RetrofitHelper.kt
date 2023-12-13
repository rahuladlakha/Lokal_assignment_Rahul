package com.example.lokal_assignment

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//Retrofit helper to make HTTP get request to get JSON response from endpoint
object RetrofitHelper {
    //endpoint for retrofit
    val baseUrl = "https://dummyjson.com"
    val instance by lazy {
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val productsApi by lazy {
        instance.create(ProductsApi::class.java)
    }
}

//The interface can be used to send HTTP requests to endpoint
interface ProductsApi {
    @GET("/products")
    fun getProducts(): Call<ProductsList>
}