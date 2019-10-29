package com.example.treinamento.db.dto

import com.example.treinamento.db.entity.Livro

class LivroDTO(
    val titulo: String,
    val preco: Double,
    val autor: String,
    val capa: String,
    val dataLancamento: String
) {
    constructor(livro: Livro) : this(
        livro.titulo,
        livro.preco,
        livro.autor,
        livro.capa,
        livro.dataLancamento
    )

    fun toLivroEntity(): Livro {
        return Livro(
            this.titulo,
            this.preco,
            this.autor,
            this.capa,
            this.dataLancamento
        )
    }
}