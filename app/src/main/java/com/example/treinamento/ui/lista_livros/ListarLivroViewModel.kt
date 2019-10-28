package com.example.treinamento.ui.lista_livros

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.treinamento.api.Response
import kotlinx.coroutines.Dispatchers
import com.example.treinamento.domain.uc.LivroController
import com.example.treinamento.util.AppSharedPreferences
import java.lang.Exception

class ListarLivroViewModel: ViewModel() {

    val loading = ObservableBoolean(false)
    val isError = ObservableBoolean(false)
    val saldo = AppSharedPreferences.getDinheiroLiveData()

    val livros = liveData(Dispatchers.IO) {
        try {
            loading.set(true)
            val livrosRecebidos = LivroController.getAll()
            isError.set(false)

            emit(Response.success(livrosRecebidos))
        } catch (e: Exception) {
            isError.set(true)
            emit(Response.error(Throwable(e.message)))
        } finally {
            loading.set(false)
        }
    }

    fun selecionarLivro(posLivro: Int) {
        return LivroController.selecionarLivro(posLivro)
    }
}