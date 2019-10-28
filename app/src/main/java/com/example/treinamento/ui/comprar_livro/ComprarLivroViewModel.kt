package com.example.treinamento.ui.comprar_livro

import androidx.lifecycle.ViewModel
import com.example.treinamento.domain.model.Livro
import com.example.treinamento.domain.uc.LivroController
import com.example.treinamento.exceptions.SaldoInsuficienteThrowable
import com.example.treinamento.util.AppSharedPreferences

class ComprarLivroViewModel : ViewModel() {

    var livro: Livro = LivroController.getLivroSelecionado()
    private set

    fun comprarLivro () {
        var dinheiro = AppSharedPreferences.getUserDinheiro()
        if (dinheiro >= this.livro.preco) {
            dinheiro -= this.livro.preco.toFloat()
            AppSharedPreferences.setUserDinheiro(dinheiro)
        } else {
            throw SaldoInsuficienteThrowable()
        }
    }

}
