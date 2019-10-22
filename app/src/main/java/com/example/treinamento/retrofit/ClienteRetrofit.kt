package com.example.treinamento.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteRetrofit {

    companion object {
        private val webservice: Webservice by lazy {
            Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/Felcks/desafio-mobile-lemobs/master/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(Webservice::class.java)
        }
        fun webservice() = webservice
    }
}