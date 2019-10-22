package com.example.treinamento.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApi {
        private val I_REST_API: IRestApi by lazy {
            Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/Felcks/desafio-mobile-lemobs/master/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(IRestApi::class.java)
        }
        fun webservice() = I_REST_API
}