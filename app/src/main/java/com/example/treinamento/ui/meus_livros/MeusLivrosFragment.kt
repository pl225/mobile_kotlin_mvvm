package com.example.treinamento.ui.meus_livros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.treinamento.databinding.MeusLivrosFragmentBinding

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
    }

}
