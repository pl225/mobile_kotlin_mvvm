package com.example.treinamento.ui.comprar_livro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treinamento.api.Response
import com.example.treinamento.db.dto.LivroDTO
import com.example.treinamento.domain.uc.LivroController
import kotlinx.coroutines.launch

class ComprarLivroViewModel : ViewModel() {

    var livro: LivroDTO = LivroController.getLivroSelecionado()
    private set

    val sucessoCompra = MutableLiveData<Response>()

    fun comprarLivro () = viewModelScope.launch {
        try {
            val novoSaldo = LivroController.comprarLivro()
            sucessoCompra.postValue(Response.success(novoSaldo))
        } catch (e: Throwable) {
            sucessoCompra.postValue(Response.error(e))
        }
    }

}
