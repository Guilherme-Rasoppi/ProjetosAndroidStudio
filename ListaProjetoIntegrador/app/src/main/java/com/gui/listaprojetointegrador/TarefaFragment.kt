package com.gui.listaprojetointegrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class TarefaFragment : Fragment() {

    /*private lateinit var edit_text_time: EditText
    private lateinit var edit_text_data: EditText*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tarefa, container, false)


        val edit_text_time = view.findViewById<EditText>(R.id.editTextTime)
        val edit_text_data = view.findViewById<EditText>(R.id.editTextDate)
        val buttonNavSeg = view.findViewById<Button>(R.id.buttonSalvar)

        fun validarTarefa(): Boolean {

            var error = false

            if (edit_text_time.text.isEmpty()) {
                edit_text_time.error = "Informe a hora"
                error = true
            }else if (edit_text_data.text.isEmpty()) {
                edit_text_data.error = "Informe a data"
                error = true
            }else{
                findNavController().navigate(R.id.action_tarefaFragment_to_listFragment)
            }
            return error
        }

        buttonNavSeg.setOnClickListener {
            validarTarefa()
        }
        return view
    }
}


