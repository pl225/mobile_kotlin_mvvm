package com.example.treinamento.api

import com.example.treinamento.domain.model.Livro
import retrofit2.Response
import retrofit2.http.GET

interface IRestApi {

    @GET("products.json")
    suspend fun getAll(): Response<List<Livro>>

}