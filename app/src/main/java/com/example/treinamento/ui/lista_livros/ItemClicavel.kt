package com.example.treinamento.ui.lista_livros

import com.example.treinamento.domain.model.Livro

interface ItemClicavel {

    fun clicar(livro: Livro)

}