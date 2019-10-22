package com.example.treinamento.model

import com.google.gson.annotations.SerializedName

data class Livro (@SerializedName("title") val titulo: String,
                  val preco: Double,
                  val autor: String,
                  val capa: String,
                  val dataLancamento: String)
