package com.gui.listaprojetointegrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.gui.listaprojetointegrador.adapter.ItemTarefaClick
import com.gui.listaprojetointegrador.adapter.tarefaAdapter
import com.gui.listaprojetointegrador.databinding.FragmentListBinding
import com.gui.listaprojetointegrador.model.TarefaViewModel

class ListFragment : Fragment(), ItemTarefaClick {

    val mainViewModel: TarefaViewModel by activityViewModels()

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)

        val adapter = tarefaAdapter(this, mainViewModel)
        binding.rvList.layoutManager = LinearLayoutManager(context)
        binding.rvList.adapter = adapter
        binding.rvList.setHasFixedSize(true)

        mainViewModel.listaTarefas()
        mainViewModel.pegarResposta.observe(viewLifecycleOwner, {
                response ->
            response.body()?.let { adapter.setData(it) }
        })

        binding.buttonadicionar.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_tarefaFragment)
        }

        return binding.root
    }

    override fun clicarTarefa(tarefa: Tarefa) {
        mainViewModel.atualizar(tarefa)
        findNavController().navigate(R.id.action_listFragment_to_tarefaFragment)

    }

}


