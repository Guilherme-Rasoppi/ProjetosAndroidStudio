package com.gui.listaprojetointegrador

import com.gui.listaprojetointegrador.repository.TarefaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ModuloServico {

    @Provides
    @Singleton
    fun servTarefa(): TarefaRepository {
        return TarefaRepository()
    }

}
