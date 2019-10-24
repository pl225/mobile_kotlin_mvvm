package com.example.treinamento.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.treinamento.R
import kotlinx.android.synthetic.main.fragment_lista_livro.*

/**
 * A simple [Fragment] subclass.
 */
class ListaLivroFragment : Fragment() {

    lateinit var viewModel: ListarLivroViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_lista_livro, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =  ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ListarLivroViewModel::class.java)

        viewModel.livros.observe(this, Observer {
            rcyLivros.addItemDecoration(DividerItemDecoration(activity, (rcyLivros.layoutManager as LinearLayoutManager).orientation))
            rcyLivros.adapter = LivroAdapter(it)
        })
    }

}
