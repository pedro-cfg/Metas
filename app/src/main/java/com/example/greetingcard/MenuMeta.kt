package com.example.greetingcard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter


class MenuMeta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu_meta2);

        le()

        val cancela: Button = findViewById(R.id.cancela)
        cancela.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                fecha()
            }
        })

        val ok: Button = findViewById(R.id.ok)
        ok.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                setMeta()
            }
        })

    }

    fun fecha()
    {
        this.finish()
        val a = Intent(applicationContext, MainActivity::class.java)
        a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(a)
    }

    fun setMeta()
    {
        val box = findViewById<EditText>(R.id.numero)
        val metast = box.text.toString()
        if (metast != "")
        {
            val meta = metast.toInt()
            escreve(meta)
        }
        else
            escreve(0)
        this.finish()
        val a = Intent(applicationContext, MainActivity::class.java)
        a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(a)
    }

    fun escreve(meta: Int)
    {
        val arquivo = File(filesDir, "Meta.txt")
        try {
            val file = FileOutputStream(arquivo)
            val bw = OutputStreamWriter(file)
            bw.write(meta)
            bw.flush()
            bw.close()
        } catch (e: IOException) {
            println(e.message)
        }
    }

    fun le()
    {
        val arquivo = File(filesDir, "Meta.txt")
        try {
            val file = FileInputStream(arquivo)
            val reader = BufferedReader(InputStreamReader(file))
            val meta = reader.read()
            reader.close()
            val box = findViewById<EditText>(R.id.numero)
            box.setText(meta.toString())
        } catch (e: IOException) {
            println(e.message)
        }
    }
}

