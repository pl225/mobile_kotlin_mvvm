package com.example.treinamento.domain.repository

import com.example.treinamento.domain.model.Livro
import com.example.treinamento.api.RestApi
import com.example.treinamento.api.IRestApi
import retrofit2.Response

class LivroRepositorio {
    var client: IRestApi = RestApi.webservice()

    suspend fun getAll(): Response<List<Livro>> {
        return client.getAll()
    }
}