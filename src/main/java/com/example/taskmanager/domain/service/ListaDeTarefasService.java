package com.example.taskmanager.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.taskmanager.domain.dto.listadetarefas.ListaDeTarefasRequestDTO;
import com.example.taskmanager.domain.dto.listadetarefas.ListaDeTarefasResponseDTO;
import com.example.taskmanager.domain.exception.ResourceNotFoundException;
import com.example.taskmanager.domain.model.ListaDeTarefas;
import com.example.taskmanager.domain.model.Usuario;
import com.example.taskmanager.domain.repository.ListaDeTarefasRepository;

public class ListaDeTarefasService implements ICRUDService<ListaDeTarefasRequestDTO, ListaDeTarefasResponseDTO> {
    @Autowired
    private ListaDeTarefasRepository listaDeTarefasRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public List<ListaDeTarefasResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<ListaDeTarefas> lista = listaDeTarefasRepository.findByUsuario(usuario);
        return lista.stream().map(listaDeTarefas -> mapper.map(listaDeTarefas, ListaDeTarefasResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ListaDeTarefasResponseDTO obterPorId(Long id) {
        Optional<ListaDeTarefas> optListaDeTarefas = listaDeTarefasRepository.findById(id);
        if(optListaDeTarefas.isEmpty()){
            throw new ResourceNotFoundException("Naõ foi possivel encontrar a lista de tarefas com o id " + id);
        }
        return mapper.map(optListaDeTarefas.get(), ListaDeTarefasResponseDTO.class);
    }

    @Override
    public ListaDeTarefasResponseDTO cadastrar(ListaDeTarefasRequestDTO dto) {
        ListaDeTarefas listaDeTarefas = mapper.map(dto, ListaDeTarefas.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        listaDeTarefas.setUsuario(usuario);
        listaDeTarefas.setId(null);
        listaDeTarefas = listaDeTarefasRepository.save(listaDeTarefas);
        return mapper.map(listaDeTarefas, ListaDeTarefasResponseDTO.class);
    }

    @Override
    public ListaDeTarefasResponseDTO atualizar(Long id, ListaDeTarefasRequestDTO dto) {
        obterPorId(id);
        ListaDeTarefas listaDeTarefas = mapper.map(dto, ListaDeTarefas.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        listaDeTarefas.setUsuario(usuario);
        listaDeTarefas.setId(id);
        listaDeTarefas = listaDeTarefasRepository.save(listaDeTarefas);
        return mapper.map(listaDeTarefas, ListaDeTarefasResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        listaDeTarefasRepository.deleteById(id);
    }
    
}
