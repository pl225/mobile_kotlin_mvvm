package com.example.treinamento.domain.repository

import com.example.treinamento.domain.model.Livro
import com.example.treinamento.api.RestApi
import com.example.treinamento.api.IRestApi

class LivroRepositorio {
    var client: IRestApi = RestApi.webservice()

    suspend fun getAll(): List<Livro> {
        val response = client.getAll()

        if (!response.isSuccessful)
            throw Throwable(response.errorBody()?.string())
        else
            return response.body() ?: listOf()

    }
}