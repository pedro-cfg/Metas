package com.example.metas


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics

class MainActivity : Activity() {

    var principal:Principal = Principal(this, 0)

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
        principal.setMeta();

        Principal.getGGrafico().setOnTouchListener(Principal.getGInteracao())

        setContentView(Principal.getGGrafico())

    }

    override fun onResume() {
        super.onResume()
        principal.setMeta()
    }

    fun troca()
    {
        val a = Intent(applicationContext, MenuMeta::class.java)
        a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(a)
    }
}



