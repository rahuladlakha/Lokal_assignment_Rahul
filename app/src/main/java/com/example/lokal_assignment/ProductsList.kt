package com.example.lokal_assignment

//The JSON response will be parsed into ProductList and Product class objects
data class ProductsList(val products: List<Product>)
data class Product(
    val id : Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)