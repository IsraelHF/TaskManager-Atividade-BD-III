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

import com.example.taskmanager.domain.dto.listadetarefas.ListaDeTarefasRequestDTO;
import com.example.taskmanager.domain.dto.listadetarefas.ListaDeTarefasResponseDTO;
import com.example.taskmanager.domain.service.ListaDeTarefasService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/listadetarefas")
public class ListaDeTarefasController {
    @Autowired
    private ListaDeTarefasService listaDeTarefasService;

    @GetMapping
    public ResponseEntity<List<ListaDeTarefasResponseDTO>> obterTodos(){
        return ResponseEntity.ok(listaDeTarefasService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeTarefasResponseDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(listaDeTarefasService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<ListaDeTarefasResponseDTO> cadastrar(@RequestBody ListaDeTarefasRequestDTO dto){
        ListaDeTarefasResponseDTO listaDeTarefas = listaDeTarefasService.cadastrar(dto);
        return new ResponseEntity<>(listaDeTarefas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDeTarefasResponseDTO> atualizar(@PathVariable Long id, @RequestBody ListaDeTarefasRequestDTO dto){
        ListaDeTarefasResponseDTO listaDeTarefas = listaDeTarefasService.atualizar(id, dto);
        return new ResponseEntity<>(listaDeTarefas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        listaDeTarefasService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
