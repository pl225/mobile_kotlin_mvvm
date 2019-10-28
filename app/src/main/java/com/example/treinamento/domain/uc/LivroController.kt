package com.example.treinamento.domain.uc

import com.example.treinamento.domain.model.Livro
import com.example.treinamento.domain.repository.LivroRepositorio

object LivroController {

    private var posSelecionado: Int = 0
    private lateinit var livros: List<Livro>
    private var livroRepository: LivroRepositorio = LivroRepositorio()

    suspend fun getAll(): List<Livro> {

        val response = livroRepository.getAll()

        if (response.isSuccessful) {
            this.livros = response.body() ?: listOf()
            return this.livros
        } else {
            throw Throwable(response.errorBody()?.string())
        }
    }

    fun selecionarLivro(posLivro: Int) {
        if (posLivro >= this.livros.size)
            throw Throwable("Livro não encontrado.")
        else
            this.posSelecionado = posLivro
    }

    fun getLivroSelecionado (): Livro {
        return this.livros[this.posSelecionado]
    }

}