package com.example.treinamento.domain.uc

import com.example.treinamento.db.dto.LivroDTO
import com.example.treinamento.domain.repository.LivroRepositorio
import com.example.treinamento.exceptions.SaldoInsuficienteThrowable
import com.example.treinamento.util.AppSharedPreferences
import org.koin.core.KoinComponent
import org.koin.core.inject

object LivroController: KoinComponent {

    private var posSelecionado: Int = 0
    private lateinit var livros: List<LivroDTO>
    private val livroRepository: LivroRepositorio by inject()

    suspend fun getAll(): List<LivroDTO> {
        this.livros = livroRepository.getAll()
        return this.livros
    }

    fun selecionarLivro(posLivro: Int) {
        if (posLivro >= this.livros.size)
            throw Throwable("Livro não encontrado.")
        else
            this.posSelecionado = posLivro
    }

    fun getLivroSelecionado (): LivroDTO {
        return this.livros[this.posSelecionado]
    }

    suspend fun comprarLivro(): Float {
        var dinheiro = AppSharedPreferences.getUserDinheiro()
        if (dinheiro >= livros[posSelecionado].preco) {
            this.livroRepository.insert(livros[posSelecionado])
            dinheiro -= livros[posSelecionado].preco.toFloat()
            AppSharedPreferences.setUserDinheiro(dinheiro)
            return dinheiro
        } else {
            throw SaldoInsuficienteThrowable()
        }
    }

    fun getMeusLivros () = this.livroRepository.getAllDb()

}