package com.example.treinamento.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.treinamento.repository.LivroRepositorio

class ListarLivroViewModel: ViewModel() {
    private val repositorio: LivroRepositorio = LivroRepositorio()

    val livros = liveData(Dispatchers.IO) {
        val livrosRecebidos = repositorio.getAll()

        emit(livrosRecebidos)
    }
}