package com.example.interacao

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interacao.model.Tarefas
import com.example.interacao.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val selectedDateLiveData: MutableLiveData<String> = MutableLiveData()

    var tarefaSelecionada: Tarefas? = null

    lateinit var myQueryResponse: Flow<List<Tarefas>>

    init {


        viewModelScope.launch {
            myQueryResponse = repository.queryAllTarefas()
        }
    }

    fun listTarefas(){
        viewModelScope.launch {
           try{
               val response = repository.listTarefas()

               if(response.isSuccessful){
                   val listTarefas = response.body()!!
                   for(tarefa in listTarefas){
                       val findTarefas = repository.queryById(tarefa.id)
                       if(findTarefas.first() != null){
                           repository.updateRoom(tarefa)
                       }else{
                           repository.insertTarefa(tarefa)
                       }
                   }
               }else{
                   Log.d("Desenvolvedor", "Erro: ${response.errorBody().toString()}")
               }
           }catch(e:Exception){
               Log.d("Desenvolvedor", e.message.toString())
           }
        }
    }

    fun addTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            try{
                val response = repository.addTarefa(tarefas)
                if(response.isSuccessful){
                    repository.insertTarefa(response.body()!!)
                }else {
                    repository.insertTarefa(tarefas)
                }
            }catch(e: Exception){
                repository.insertTarefa(tarefas)
            }
        }
    }

    fun updateTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            try{
                repository.updateTarefa(tarefas)
                repository.updateRoom(tarefas)
            }catch(e: Exception){
                repository.updateRoom(tarefas)
            }
        }
    }

    fun deleteTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            try{
                repository.deleteTarefa(tarefas.id)
                repository.deleteTarefaRoom(tarefas)
            }catch (e: Exception){
                repository.deleteTarefaRoom(tarefas)
            }
        }
    }
}