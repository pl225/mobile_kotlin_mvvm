package com.example.treinamento.ui


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.treinamento.R
import com.example.treinamento.domain.model.Livro
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.lista_livro, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =  ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ListarLivroViewModel::class.java)

        rcyLivros.addItemDecoration(DividerItemDecoration(activity, (rcyLivros.layoutManager as LinearLayoutManager).orientation))
        rcyLivros.adapter = LivroAdapter(listOf())

        viewModel.livros.observe(this, Observer {
            if (it.isSuccessful()) {
                val itens = it.data as List<*>
                (rcyLivros.adapter as LivroAdapter).updateDataSet(itens.filterIsInstance<Livro>())
            }
        })
    }

}
