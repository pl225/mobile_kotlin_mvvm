package com.example.treinamento.ui.meus_livros

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.treinamento.api.Response
import com.example.treinamento.db.dto.LivroDTO
import com.example.treinamento.domain.uc.LivroController

class MeusLivrosViewModel : ViewModel() {

    private val livros = LivroController.getMeusLivros()

    val meusLivros: LiveData<Response> = Transformations.map(this.livros) {
        val livrosDTO = ArrayList<LivroDTO>()
        for (livro in it) {
            livrosDTO.add(LivroDTO(livro))
        }
        Response.success(livrosDTO)
    }

}



