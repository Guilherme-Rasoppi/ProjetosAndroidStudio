package com.gui.listaprojetointegrador.repository

import com.gui.listaprojetointegrador.api.RetrofitInstance



import com.gui.listaprojetointegrador.Tarefa
import retrofit2.Response

class TarefaRepository {


    suspend fun listaTarefas(): Response<List<Tarefa>>{
        return RetrofitInstance.api.listaTarefas()
    }

    suspend fun adicionarTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.adionarTarefa(tarefa)
    }

    suspend fun atualizarTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.atualizarTarefa(tarefa)
    }

    suspend fun deletarTarefa(valor: Int): Response<Tarefa>{
        return RetrofitInstance.api.deletarTarefa(valor)
    }

}