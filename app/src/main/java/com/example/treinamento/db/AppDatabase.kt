package com.example.treinamento.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.treinamento.App
import com.example.treinamento.db.dao.LivroDao
import com.example.treinamento.db.entity.Livro

@Database(entities = [Livro::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun livroDao() : LivroDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase (): AppDatabase? {
            if (this.INSTANCE != null) {
                return this.INSTANCE
            } else {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        App.instance,
                        AppDatabase::class.java,
                        "livraria").build()
                    this.INSTANCE = instance
                    return instance
                }
            }
        }

    }

}