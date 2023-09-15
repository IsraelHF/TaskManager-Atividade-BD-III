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

import com.example.taskmanager.domain.dto.tarefa.TarefaRequestDTO;
import com.example.taskmanager.domain.dto.tarefa.TarefaResponseDTO;
import com.example.taskmanager.domain.service.TarefaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tarefas")
public class TarefasController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> obterTodos(){
        return ResponseEntity.ok(tarefaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> cadastrar(@RequestBody TarefaRequestDTO dto){
        TarefaResponseDTO responseDTO = tarefaService.cadastrar(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @RequestBody TarefaRequestDTO dto){
        TarefaResponseDTO responseDTO = tarefaService.atualizar(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
