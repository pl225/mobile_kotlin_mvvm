package com.example.treinamento.di

import com.example.treinamento.api.IRestApi
import com.example.treinamento.domain.repository.LivroRepositorio
import com.example.treinamento.ui.comprar_livro.ComprarLivroViewModel
import com.example.treinamento.ui.lista_livros.ListarLivroViewModel
import com.example.treinamento.ui.meus_livros.MeusLivrosViewModel
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val network = module {
    single { provideRetrofit() }
    single { provideIRestAPI(get())}
}

fun provideIRestAPI(retrofit: Retrofit): IRestApi = retrofit.create(IRestApi::class.java)

fun provideRetrofit (): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/Felcks/desafio-mobile-lemobs/master/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
}

val repositorios = module {
    single { LivroRepositorio(get()) }
}

val viewModels = module {
    factory { ComprarLivroViewModel() }
    factory { ListarLivroViewModel() }
    factory { MeusLivrosViewModel() }
}