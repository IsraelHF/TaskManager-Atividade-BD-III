package com.example.taskmanager.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanager.domain.model.ListaDeTarefas;
import com.example.taskmanager.domain.model.Usuario;

public interface ListaDeTarefasRepository extends JpaRepository<ListaDeTarefas, Long> {
    
    List<ListaDeTarefas> findByUsuario(Usuario usuario);
}
