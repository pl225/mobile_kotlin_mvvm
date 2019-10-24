package com.example.treinamento.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.treinamento.R
import kotlinx.android.synthetic.main.activity_listar_livro.*

class ListarLivroActivity : AppCompatActivity() {

    lateinit var viewModel: ListarLivroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_livro)

        viewModel =  ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ListarLivroViewModel::class.java)

        viewModel.livros.observe(this, Observer {
            rcyLivros.addItemDecoration(DividerItemDecoration(this, (rcyLivros.layoutManager as LinearLayoutManager).orientation))
            rcyLivros.adapter = LivroAdapter(it)
        })
    }
}
