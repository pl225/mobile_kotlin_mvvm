package com.example.treinamento.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.treinamento.api.Response
import kotlinx.coroutines.Dispatchers
import com.example.treinamento.domain.repository.LivroRepositorio
import java.lang.Exception

class ListarLivroViewModel: ViewModel() {
    private val repositorio: LivroRepositorio = LivroRepositorio()

    private var _loading = MutableLiveData(false)
    private var _isError = MutableLiveData(false)

    var loading :    LiveData<Boolean> = _loading
    var isError : LiveData<Boolean> = _isError

    val livros = liveData(Dispatchers.IO) {
        try {
            _loading.postValue(true)
            val livrosRecebidos = repositorio.getAll()
            _isError.postValue(false)

            emit(Response.success(livrosRecebidos))
        } catch (e: Exception) {
            _isError.postValue(true)
            emit(Response.error(Throwable(e.message)))
        } finally {
            _loading.postValue(false)
        }
    }
}