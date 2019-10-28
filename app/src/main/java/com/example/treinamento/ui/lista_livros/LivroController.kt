package com.example.treinamento.ui.lista_livros

import com.example.treinamento.domain.model.Livro
import com.example.treinamento.domain.repository.LivroRepositorio

class LivroController(private val livroRepository: LivroRepositorio) {

    suspend fun getAll(): List<Livro> {

        val response = livroRepository.getAll()

        if (response.isSuccessful)
            return response.body() ?: listOf()
        else
            throw Throwable(response.errorBody()?.string())
    }

}