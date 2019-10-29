package com.example.treinamento

import android.app.Application
import com.example.treinamento.di.network
import com.example.treinamento.di.repositorios
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(network, repositorios))
        }
    }
}