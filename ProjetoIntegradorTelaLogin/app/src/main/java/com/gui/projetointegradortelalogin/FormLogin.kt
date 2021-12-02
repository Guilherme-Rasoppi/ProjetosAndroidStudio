package com.gui.projetointegradortelalogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class FormLogin : AppCompatActivity() {

    private lateinit var telaCadastro: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        supportActionBar?.hide();
        iniciarComponentes()


        telaCadastro.setOnClickListener(View.OnClickListener {



        })

    }
    private fun iniciarComponentes(){
        telaCadastro = findViewById(R.id.text_tela_cadastro)
    }
}