package com.example.treinamento.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.treinamento.db.entity.Livro

@Dao
interface LivroDao {

    @Query("SELECT * FROM livro")
    fun all(): LiveData<List<Livro>>

    @Insert
    suspend fun add(vararg product: Livro)

    @Query("SELECT * FROM livro WHERE livro.titulo = :titulo")
    suspend fun get(titulo: String): List<Livro>

}