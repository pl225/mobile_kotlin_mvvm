package com.example.treinamento.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.treinamento.db.dao.LivroDao
import com.example.treinamento.db.entity.Livro

@Database(entities = [Livro::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun livroDao() : LivroDao

}