package com.example.treinamento.repository

import com.example.treinamento.retrofit.ClienteRetrofit
import com.example.treinamento.retrofit.Webservice

class LivroRepositorio {
    var client: Webservice = ClienteRetrofit.webservice()

    suspend fun getAll() = client.getAll()
}