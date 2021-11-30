package com.gui.listaprojetointegrador.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gui.listaprojetointegrador.Tarefa
import com.gui.listaprojetointegrador.repository.TarefaRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TarefaViewModel @Inject constructor(

    private val tarefaRepository: TarefaRepository) :ViewModel(){

    private val _pegarResposta = MutableLiveData<Response<List<Tarefa>>>()
    val pegarResposta: LiveData<Response<List<Tarefa>>> = _pegarResposta

    private val _deletarResposta = MutableLiveData<Response<Tarefa>>()
    val deletarResposta: LiveData<Response<Tarefa>> = _deletarResposta

    private val _atualizarResposta = MutableLiveData<Response<Tarefa>>()
    val atualizarResposta: LiveData<Response<Tarefa>> = _atualizarResposta





    val selectedDateLiveData: MutableLiveData<String> = MutableLiveData()

    var tarefaSelecionada: Tarefa? = null

    init {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val data = formatter.format(Date())
        selectedDateLiveData.postValue(data.toString())
    }

    fun listaTarefas(){
        viewModelScope.launch {
            val response = tarefaRepository.listaTarefas()
            _pegarResposta.value = response
        }
    }
    fun adicionar(tarefa: Tarefa){
        viewModelScope.launch {
            val response = tarefaRepository.adicionarTarefa(tarefa)
        }
    }

    fun atualizar(tarefa: Tarefa){
        viewModelScope.launch {
            val response = tarefaRepository.atualizarTarefa(tarefa)

        }
    }

    fun deletarTarefa(valor: Int){
        viewModelScope.launch {
            val response = tarefaRepository.deletarTarefa(valor)
            _deletarResposta.value = response
        }
    }



}