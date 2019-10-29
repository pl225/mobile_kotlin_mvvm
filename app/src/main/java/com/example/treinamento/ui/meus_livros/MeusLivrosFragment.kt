package com.example.treinamento.ui.meus_livros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.treinamento.databinding.MeusLivrosFragmentBinding
import com.example.treinamento.db.dto.LivroDTO
import com.example.treinamento.ui.lista_livros.LivroAdapter
import kotlinx.android.synthetic.main.fragment_lista_livro.*

class MeusLivrosFragment : Fragment() {

    private lateinit var viewModel: MeusLivrosViewModel
    private lateinit var binding: MeusLivrosFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        this.binding = MeusLivrosFragmentBinding.inflate(inflater, container, false)
        this.binding.lifecycleOwner = this.viewLifecycleOwner

        return this.binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeusLivrosViewModel::class.java)

        rcyLivros.addItemDecoration(DividerItemDecoration(activity, (rcyLivros.layoutManager as LinearLayoutManager).orientation))
        rcyLivros.adapter = LivroAdapter(listOf())

        viewModel.meusLivros.observe(this, Observer {
            if (it.isSuccessful()) {
                val itens = it.data as List<*>
                (rcyLivros.adapter as LivroAdapter).updateDataSet(itens.filterIsInstance<LivroDTO>())
            }
        })
    }

}
