package com.example.treinamento.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.treinamento.R

class ListarLivroActivity : AppCompatActivity() {

    lateinit var viewModel: ListarLivroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_livro)

        viewModel =  ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ListarLivroViewModel::class.java)

        viewModel.livros.observe(this, Observer {
            Log.d("teste", it.size.toString())
        })
    }
}
