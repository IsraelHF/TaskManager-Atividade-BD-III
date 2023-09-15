package com.example.taskmanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanager.domain.model.Disciplina;
import com.example.taskmanager.domain.model.Usuario;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
    List<Disciplina> findByUsuario(Usuario usuario);
}
