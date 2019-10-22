package com.example.treinamento.domain.model

import com.google.gson.annotations.SerializedName

data class Livro (@SerializedName("title") val titulo: String,
                  @SerializedName("price") val preco: Double,
                  @SerializedName("writer") val autor: String,
                  @SerializedName("thumbnailHd") val capa: String,
                  @SerializedName("date") val dataLancamento: String)
