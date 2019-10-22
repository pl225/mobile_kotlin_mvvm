package com.example.treinamento.retrofit

import com.example.treinamento.model.Livro
import retrofit2.Call
import retrofit2.http.GET

interface Webservice {

    @GET("products.json")
    suspend fun getAll(): List<Livro>

}