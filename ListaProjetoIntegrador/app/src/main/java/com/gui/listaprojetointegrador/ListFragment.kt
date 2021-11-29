package com.gui.listaprojetointegrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.gui.listaprojetointegrador.adapter.ItemTarefaClick
import com.gui.listaprojetointegrador.adapter.tarefaAdapter
import com.gui.listaprojetointegrador.model.TarefaViewModel

class ListFragment : Fragment(), ItemTarefaClick{

    val mainViewModel: TarefaViewModel by activityViewModels()

    val adapter = tarefaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_list,container,false)
        val rvList:RecyclerView by lazy {
            view.findViewById(R.id.rv_list)
        }
        rvList.adapter = adapter

        mainViewModel.listaTarefas()
        mainViewModel.pegarResposta.observe(viewLifecycleOwner, {
                response ->
            response.body()?.let { adapter.setData(it) }
        })


        val buttonAcessar = view.findViewById<Button>(R.id.buttonAcessar)
        val buttonNavSeg = view.findViewById<FloatingActionButton>(R.id.buttonadicionar)

       buttonNavSeg.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_listFragment_to_tarefaFragment)
        }


            return view

        }


    override fun clicarTarefa(tarefa: Tarefa) {
        mainViewModel.tarefaSelecionada = tarefa
        findNavController().navigate(R.id.action_listFragment_to_tarefaFragment)

    }
}


