package com.example.treinamento.domain.repository

import com.example.treinamento.retrofit.ClienteRetrofit
import com.example.treinamento.retrofit.Webservice

class LivroRepositorio {
    var client: Webservice = ClienteRetrofit.webservice()

    suspend fun getAll() = client.getAll()
}