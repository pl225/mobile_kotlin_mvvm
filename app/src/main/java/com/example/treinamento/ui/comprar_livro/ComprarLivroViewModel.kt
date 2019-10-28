package com.example.treinamento.ui.comprar_livro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.treinamento.api.Response
import com.example.treinamento.domain.model.Livro
import com.example.treinamento.domain.uc.LivroController

class ComprarLivroViewModel : ViewModel() {

    var livro: Livro = LivroController.getLivroSelecionado()
    private set

    val sucessoCompra = MutableLiveData<Response>()

    fun comprarLivro () {
        try {
            val novoSaldo = LivroController.comprarLivro()
            sucessoCompra.postValue(Response.success(novoSaldo))
        } catch (e: Throwable) {
            sucessoCompra.postValue(Response.error(e))
        }
    }

}
