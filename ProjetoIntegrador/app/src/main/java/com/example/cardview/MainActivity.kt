package com.example.cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardview.adapter.TarefaAdapter
import com.example.cardview.model.Tarefas

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tarefas = mutableListOf<Tarefas>(
            Tarefas("Paula",
                "28/11/2021",
                "08:00",
                "Verde"
            ),
            Tarefas("Rafael",
                "28/11/2021",
                "08:30",
                "Vermelho"
            ),
            Tarefas("Giovanna",
                "28/11/2021",
                "08:45",
                "Verde"
            ),
            Tarefas("Tiago",
                "28/11/2021",
                "08:50",
                "Verde"
            ),
            Tarefas("Luan",
                "28/11/2021",
                "09:00",
                "Verde"
            )
        )

        val recyclerTarefa = findViewById<RecyclerView>(R.id.recyclerTarefa)
        recyclerTarefa.layoutManager = LinearLayoutManager(this)
        recyclerTarefa.adapter = TarefaAdapter(this, tarefas)
        recyclerTarefa.setHasFixedSize(true)

    }


}