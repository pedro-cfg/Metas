package com.example.greetingcard


import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics




class MainActivity : Activity() {

    var principal:Principal = Principal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val con = this.applicationContext

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val altura = displayMetrics.heightPixels
        val largura = displayMetrics.widthPixels

        principal.cria_Gerenciador(con, null)
        Principal.getGGrafico().inicia(altura,largura)
        principal.comeca()

        Principal.getGGrafico().setOnTouchListener(Principal.getGInteracao())

        setContentView(Principal.getGGrafico())

    }
}



