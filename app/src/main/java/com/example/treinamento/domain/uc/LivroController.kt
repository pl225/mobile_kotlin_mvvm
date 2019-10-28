package com.example.treinamento.domain.uc

import com.example.treinamento.domain.model.Livro
import com.example.treinamento.domain.repository.LivroRepositorio
import com.example.treinamento.exceptions.SaldoInsuficienteThrowable
import com.example.treinamento.util.AppSharedPreferences

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

    fun comprarLivro(livro: Livro): Float {
        var dinheiro = AppSharedPreferences.getUserDinheiro()
        if (dinheiro >= livro.preco) {
            dinheiro -= livro.preco.toFloat()
            AppSharedPreferences.setUserDinheiro(dinheiro)
            return dinheiro
        } else {
            throw SaldoInsuficienteThrowable()
        }
    }

}