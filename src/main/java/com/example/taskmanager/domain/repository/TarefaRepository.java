package com.example.taskmanager.domain.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanager.domain.model.Tarefa;
import com.example.taskmanager.domain.model.Usuario;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
    List<Tarefa> findByUsuario(Usuario usuario);
}
