package com.example.treinamento.api.response

import com.google.gson.annotations.SerializedName

class LivroResponse(
    @SerializedName("title") val titulo: String,
    @SerializedName("price") val preco: Double,
    @SerializedName("writer") val autor: String,
    @SerializedName("thumbnailHd") val capa: String,
    @SerializedName("date") val dataLancamento: String
)