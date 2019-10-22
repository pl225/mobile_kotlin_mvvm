package com.example.treinamento.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.treinamento.domain.repository.LivroRepositorio

class ListarLivroViewModel: ViewModel() {
    private val repositorio: LivroRepositorio = LivroRepositorio()

    val livros = liveData(Dispatchers.IO) {
        val livrosRecebidos = repositorio.getAll()

        emit(livrosRecebidos)
    }
}