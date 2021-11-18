package com.gui.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gui.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculagorjeta() }
    }

            fun calculagorjeta() {
                val campoTexto = binding.custoServico.text.toString()
                val cost = campoTexto.toDouble()
                val selecionarId = binding.opcaoDica.checkedRadioButtonId
                val porcn = when (selecionarId) {
                    R.id.opcao_vinte_por_cento -> 0.20
                    R.id.opcao_dezoito_por_cento -> 0.18
                    else -> 0.15
                }
                var gorjeta = porcn * cost
                val arredondameto = binding.interruptorArredondamento.isChecked
                if (arredondameto) {
                    gorjeta = kotlin.math.ceil(gorjeta)
                }
                val dicaForm = NumberFormat.getCurrencyInstance().format(gorjeta)
                binding.valorGorjeta.text = getString(R.string.valor_gorjeta, dicaForm)

            }


       }



