package com.example.treinamento.util

import android.content.Context
import android.content.SharedPreferences
import com.example.treinamento.App
import com.example.treinamento.BuildConfig
import me.ibrahimsn.library.LivePreference
import me.ibrahimsn.library.LiveSharedPreferences

object AppSharedPreferences{

    private const val SESSION = "${BuildConfig.APPLICATION_ID}.session"
    private const val KEY_USER_MONEY = "${BuildConfig.APPLICATION_ID}.dinheiro"
    private const val DINHEIRO_INICIAL = 100f

    fun getUserDinheiro(context: Context) : Float{
        val prefs: SharedPreferences = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE)
        return prefs.getFloat(KEY_USER_MONEY, DINHEIRO_INICIAL)
    }

    fun setUserDinheiro(context: Context, value: Float){
        val prefs: SharedPreferences = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putFloat(KEY_USER_MONEY, value)
        editor.apply()
    }

    fun getDinheiroLiveData(): LivePreference<Float> {
        val prefs = App.instance.getSharedPreferences(SESSION, Context.MODE_PRIVATE)
        val livePrefs = LiveSharedPreferences(prefs)
        return livePrefs.getFloat(KEY_USER_MONEY, DINHEIRO_INICIAL)
    }
}