package com.example.treinamento.ui.lista_livros


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.treinamento.R
import kotlinx.android.synthetic.main.fragment_lista_livro.*

import com.example.treinamento.databinding.FragmentListaLivroBinding
import com.example.treinamento.db.dto.LivroDTO
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class ListaLivroFragment : Fragment(), ItemClicavel {

    private val listarLivroViewModel: ListarLivroViewModel by viewModel()
    lateinit var binding: FragmentListaLivroBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.setHasOptionsMenu(true)

        this.binding = FragmentListaLivroBinding.inflate(inflater, container, false)
        this.binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
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

        this.binding.viewModel = this.listarLivroViewModel

        rcyLivros.addItemDecoration(DividerItemDecoration(activity, (rcyLivros.layoutManager as LinearLayoutManager).orientation))
        rcyLivros.adapter = LivroAdapter(listOf(), this)

        this.listarLivroViewModel.livros.observe(this, Observer {
            if (it.isSuccessful()) {
                val itens = it.data as List<*>
                (rcyLivros.adapter as LivroAdapter).updateDataSet(itens.filterIsInstance<LivroDTO>())
            }
        })

        this.listarLivroViewModel.saldo.observe(this, Observer {
            this.binding.txtSaldo.text = String.format(getString(R.string.saldo_disponivel), it)
        })
    }

    override fun clicar(livro: Int) {
        this.listarLivroViewModel.selecionarLivro(livro)
        this.findNavController().navigate(ListaLivroFragmentDirections.actionListaLivroFragmentToComprarLivroFragment())
    }

}
