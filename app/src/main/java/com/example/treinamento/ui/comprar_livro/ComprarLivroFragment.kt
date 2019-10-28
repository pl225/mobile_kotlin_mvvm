package com.example.treinamento.ui.comprar_livro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.treinamento.databinding.ComprarLivroFragmentBinding

class ComprarLivroFragment : Fragment() {

    private lateinit var viewModel: ComprarLivroViewModel
    private lateinit var binding: ComprarLivroFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setHasOptionsMenu(true)
        this.binding = ComprarLivroFragmentBinding.inflate(inflater, container, false)
        this.binding.lifecycleOwner = this.viewLifecycleOwner

        return this.binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.viewModel = ViewModelProvider(this).get(ComprarLivroViewModel::class.java)
        this.binding.viewModel = viewModel

        this.viewModel.sucessoCompra.observe(this, Observer {
            if (it.isSuccessful()) {
                this.findNavController().navigate(ComprarLivroFragmentDirections.actionComprarLivroFragmentToListaLivroFragment())
            } else {
                Toast.makeText(activity, it.error!!.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}
