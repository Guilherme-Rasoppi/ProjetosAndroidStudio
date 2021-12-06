package com.example.interacao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interacao.model.Tarefas
import com.example.interacao.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _myGetResponse = MutableLiveData<Response<List<Tarefas>>>()
    val myResponse: LiveData<Response<List<Tarefas>>> = _myGetResponse

    private val _myDeleteResponse = MutableLiveData<Response<Tarefas>>()
    val myDeleteResponse: LiveData<Response<Tarefas>> = _myDeleteResponse


    val selectedDateLiveData: MutableLiveData<String> = MutableLiveData()

    var tarefaSelecionada: Tarefas? = null

    init {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = formatter.format(Date())
        selectedDateLiveData.postValue(date.toString())
    }

    fun listTarefas(){
        viewModelScope.launch {
            val response = repository.listTarefas()
            _myGetResponse.value = response
        }
    }

    fun addTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            val response = repository.addTarefa(tarefas)
        }
    }

    fun updateTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            val response = repository.updateTarefa(tarefas)
        }
    }

    fun deleteTarefa(valor: Int){
        viewModelScope.launch {
            val response = repository.deleteTarefa(valor)
            _myDeleteResponse.value = response
        }
    }
}