package com.example.treinamento.retrofit

import com.example.treinamento.domain.model.Livro
import retrofit2.http.GET

interface Webservice {

    @GET("products.json")
    suspend fun getAll(): List<Livro>

}