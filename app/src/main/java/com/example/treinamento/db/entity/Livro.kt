package com.example.treinamento.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livro")
class Livro(
    @PrimaryKey
    val titulo: String,
    val preco: Double,
    val autor: String,
    val capa: String,
    @ColumnInfo(name = "data_lancamento") val dataLancamento: String
)