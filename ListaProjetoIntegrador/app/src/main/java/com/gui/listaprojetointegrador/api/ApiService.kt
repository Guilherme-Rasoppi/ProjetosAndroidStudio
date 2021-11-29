package com.gui.listaprojetointegrador.api

import com.gui.listaprojetointegrador.Tarefa
import  retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("api/todo")
    suspend fun listaTarefas(): Response<List<Tarefa>>

    @POST("api/todo")
    suspend fun adionarTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @PUT("api/todo")
    suspend fun atualizarTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @DELETE("api/todo/{tarefa}")
    suspend fun deletarTarefa(
        @Path("tarefa") valor: Int
    ): Response<Tarefa>

}
