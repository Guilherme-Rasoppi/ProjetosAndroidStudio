package com.gui.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClique: Button = findViewById(R.id.ButtonClique)

        buttonClique.setOnClickListener{
            /*val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            textViewResultado.text = "6"*/
            rolardado()
        }
    }

    private fun rolardado() {
        val dado = Dado(6)
        val dadorodado = dado.rolar()
        val dadoImage: ImageView = findViewById(R.id.imageView)


        val drawableResource = when (dadorodado) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dadoImage.setImageResource(drawableResource)
        dadoImage.contentDescription = dadorodado.toString()
    }
}

class Dado(private val numdado: Int) {

    fun rolar(): Int {
        return (1..numdado).random()
    }
}