package com.example.interacao.repository

import com.example.interacao.api.RetrofitInstance
import com.example.interacao.model.Tarefas
import retrofit2.Response

class Repository {


    suspend fun listTarefas(): Response<List<Tarefas>>{
        return RetrofitInstance.api.listTarefas()
    }

    suspend fun addTarefa(tarefas: Tarefas): Response<Tarefas>{
        return RetrofitInstance.api.addTarefa(tarefas)
    }

    suspend fun updateTarefa(tarefas: Tarefas): Response<Tarefas>{
        return RetrofitInstance.api.updateTarefa(tarefas)
    }

    suspend fun deleteTarefa(valor: Int): Response<Tarefas>{
        return RetrofitInstance.api.deleteTarefa(valor)
    }

}