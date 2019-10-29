package com.example.treinamento.api

import com.example.treinamento.api.response.LivroResponse
import retrofit2.Response
import retrofit2.http.GET

interface IRestApi {

    @GET("products.json")
    suspend fun getAll(): Response<List<LivroResponse>>

}