package com.example.treinamento.ui.lista_livros

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.treinamento.R
import com.example.treinamento.db.dto.LivroDTO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_livro.view.*

class LivroAdapter(private var livros: List<LivroDTO>): RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {

    private var clicavel: ItemClicavel? = null

    constructor(livros: List<LivroDTO>, clicavel: ItemClicavel?): this (livros) {
        this.clicavel = clicavel
    }

    inner class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                clicavel?.clicar(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livro, parent, false)

        return LivroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.livros.size
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        holder.itemView.txtTitulo.text = livros[position].titulo
        holder.itemView.txtAutor.text = livros[position].autor
        holder.itemView.txtPreco.text = String.format(holder.itemView.context.getString(R.string.preco), livros[position].preco)
        Picasso
            .get()
            .load(livros[position].capa)
            .into(holder.itemView.img)
    }

    fun updateDataSet(list: List<LivroDTO>) {
        this.livros = list
        notifyDataSetChanged()
    }
}

