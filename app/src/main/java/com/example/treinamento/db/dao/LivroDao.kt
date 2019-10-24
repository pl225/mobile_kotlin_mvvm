package com.example.treinamento.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.treinamento.db.entity.Livro

@Dao
interface LivroDao {

    @Query("SELECT * FROM livro")
    fun all(): List<Livro>

    @Insert
    fun add(vararg product: Livro)


}