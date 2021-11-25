package com.gui.listaprojetointegrador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class tarefaAdapter()

    : RecyclerView.Adapter<tarefaAdapter.TarefaViewHolder>() {
    val listTarefas: MutableList<Tarefa> = mutableListOf()
    class TarefaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textNome = view.findViewById<TextView>(R.id.textNome)
        val textData = view.findViewById<TextView>(R.id.textData)
        val textHora = view.findViewById<TextView>(R.id.textHora)
        val textStatus = view.findViewById<TextView>(R.id.textStatus)

        fun binding(tarefa: Tarefa){
            textNome.text = tarefa.nome
            textData.text = tarefa.data
            textHora.text = tarefa.hora
            textStatus.text = tarefa.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val layoutAdapter = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_list, parent, false)

        return TarefaViewHolder(layoutAdapter)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.binding(listTarefas[position])

    }
    fun updateList(list: List<Tarefa>){
        this.listTarefas.clear()
        this.listTarefas.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listTarefas.size
    }




}