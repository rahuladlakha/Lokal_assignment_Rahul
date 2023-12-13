package com.example.lokal_assignment

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

object RetrofitHelper {
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
interface ProductsApi {
    @GET("/products")
    fun getProducts(): Call<ProductsList>
}