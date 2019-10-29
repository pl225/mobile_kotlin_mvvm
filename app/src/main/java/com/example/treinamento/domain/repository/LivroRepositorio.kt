package com.example.treinamento.domain.repository

import androidx.lifecycle.Transformations
import com.example.treinamento.api.RestApi
import com.example.treinamento.api.IRestApi
import com.example.treinamento.db.AppDatabase
import com.example.treinamento.db.dto.LivroDTO
import com.example.treinamento.exceptions.LivroJaCompradoThrowable

class LivroRepositorio {
    private var client: IRestApi = RestApi.webservice()
    private var livroDao = AppDatabase.getDatabase()!!.livroDao()

    suspend fun getAll(): List<LivroDTO> {
        val response = client.getAll()

        if (response.isSuccessful) {
            return if (response.body() != null) {
                response.body()!!.map { livro ->
                    LivroDTO(
                        livro.titulo,
                        livro.preco,
                        livro.autor,
                        livro.capa,
                        livro.dataLancamento
                    )
                }
            } else {
                listOf()
            }
        } else {
            throw Throwable(response.errorBody()?.string())
        }
    }

    fun getAllDb () =  Transformations.map(this.livroDao.all()) {
        val livrosDTO = ArrayList<LivroDTO>()
        for (livro in it) {
            livrosDTO.add(LivroDTO(livro))
        }
        livrosDTO
    }

    suspend fun insert (livro: LivroDTO) {
        if (this.livroDao.get(livro.titulo).isEmpty())
            livroDao.add(livro.toLivroEntity())
        else
            throw LivroJaCompradoThrowable()
    }

}