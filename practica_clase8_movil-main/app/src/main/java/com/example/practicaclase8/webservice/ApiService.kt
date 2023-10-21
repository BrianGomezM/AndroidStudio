package com.example.practicaclase8.webservice

import com.example.practicaclase8.model.Product
import com.example.practicaclase8.utils.Constants.END_POINT
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getProducts(): MutableList<Product>
}