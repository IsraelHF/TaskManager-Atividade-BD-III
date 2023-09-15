package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.domain.dto.disciplina.DisciplinaRequestDTO;
import com.example.taskmanager.domain.dto.disciplina.DisciplinaResponseDTO;
import com.example.taskmanager.domain.service.DisciplinaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> obterTodos(){
        return ResponseEntity.ok(disciplinaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(disciplinaService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> cadastrar(@RequestBody DisciplinaRequestDTO dto){
        DisciplinaResponseDTO disciplina = disciplinaService.cadastrar(dto);
        return new ResponseEntity<>(disciplina, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> atualizar(@PathVariable Long id, @RequestBody DisciplinaRequestDTO dto){
        DisciplinaResponseDTO disciplina = disciplinaService.atualizar(id, dto);
        return new ResponseEntity<>(disciplina, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        disciplinaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
