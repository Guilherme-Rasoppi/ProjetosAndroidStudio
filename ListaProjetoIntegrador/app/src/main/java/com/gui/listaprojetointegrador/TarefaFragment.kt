package com.gui.listaprojetointegrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.gui.listaprojetointegrador.model.OrderViewModel
import java.text.SimpleDateFormat
import java.util.*

class TarefaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tarefa, container, false)

        val buttonNavSeg = view.findViewById<Button>(R.id.buttonSalvar)
        val validaData = view.findViewById<TextView>(R.id.textData)
        val validaHora = view.findViewById<TextView>(R.id.textHora)
        buttonNavSeg.setOnClickListener{
            fun validarTarefa(){

            }
            Navigation.findNavController(view).navigate(R.id.action_tarefaFragment_to_listFragment)
        }
        return view
    }

}