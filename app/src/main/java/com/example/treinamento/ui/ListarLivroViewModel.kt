package com.example.treinamento.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.treinamento.api.Response
import kotlinx.coroutines.Dispatchers
import com.example.treinamento.domain.repository.LivroRepositorio
import java.lang.Exception

class ListarLivroViewModel: ViewModel() {
    private val repositorio: LivroRepositorio = LivroRepositorio()

    val livros = liveData(Dispatchers.IO) {
        try {
            val livrosRecebidos = repositorio.getAll()

            emit(Response.success(livrosRecebidos))
        } catch (e: Exception) {
            emit(Response.error(Throwable(e.message)))
        }
    }
}