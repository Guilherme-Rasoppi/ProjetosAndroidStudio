package com.gui.listaprojetointegrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

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

        rvList.layoutManager=LinearLayoutManager(context)
            adapter.updateList(
                arrayListOf(
                    Tarefa("Luan", "28/11/2021", "09:00", "Verde"),
                    Tarefa("Rafael", "28/11/2021", "09:10", "Verde")
                )
            )

        val buttonNavSeg = view.findViewById<FloatingActionButton>(R.id.buttonadicionar)

       buttonNavSeg.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_listFragment_to_tarefaFragment)
        }
            return view
       }
}


