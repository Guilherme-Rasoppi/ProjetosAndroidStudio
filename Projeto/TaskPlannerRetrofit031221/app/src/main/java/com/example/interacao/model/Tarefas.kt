package com.example.interacao.model

data class Tarefas (
    val id: Int,
    var name: String,
    var description: String,
    var assignetTo: String,
    var dueDate: String,
    var status: String
    ) {
}