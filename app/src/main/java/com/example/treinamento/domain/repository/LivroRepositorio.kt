package com.example.treinamento.domain.repository

import com.example.treinamento.api.RestApi
import com.example.treinamento.api.IRestApi
import com.example.treinamento.db.AppDatabase
import com.example.treinamento.db.dto.LivroDTO

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

    fun getAllDb () = livroDao.all()

    fun insert (livro: LivroDTO) = livroDao.add(livro.toLivroEntity())
}