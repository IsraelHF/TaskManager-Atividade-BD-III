package com.example.taskmanager.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.taskmanager.domain.Enum.EStatusTarefa;
import com.example.taskmanager.domain.dto.tarefa.TarefaRequestDTO;
import com.example.taskmanager.domain.dto.tarefa.TarefaResponseDTO;
import com.example.taskmanager.domain.exception.ResourceNotFoundException;
import com.example.taskmanager.domain.model.Tarefa;
import com.example.taskmanager.domain.model.Usuario;
import com.example.taskmanager.domain.repository.TarefaRepository;

@Service
public class TarefaService implements ICRUDService<TarefaRequestDTO, TarefaResponseDTO> {
    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TarefaResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Tarefa> tarefas = tarefaRepository.findByUsuario(usuario);
        return tarefas.stream().map(tarefa -> mapper.map(tarefa, TarefaResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TarefaResponseDTO obterPorId(Long id) {
        Optional<Tarefa> optTarefa = tarefaRepository.findById(id);
        if(optTarefa.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar a tarefa com o id: " + id);
        }
        return mapper.map(optTarefa.get(), TarefaResponseDTO.class);
    }

    @Override
    public TarefaResponseDTO cadastrar(TarefaRequestDTO dto) {
        Tarefa tarefa = mapper.map(dto, Tarefa.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tarefa.setUsuario(usuario);
        tarefa.setId(null);
        tarefa.setDataCriacao(new Date());
        tarefa.setStatus(EStatusTarefa.EM_ANDAMENTO);
        tarefa = tarefaRepository.save(tarefa);
        return mapper.map(tarefa, TarefaResponseDTO.class);
    }

    @Override
    public TarefaResponseDTO atualizar(Long id, TarefaRequestDTO dto) {
        TarefaResponseDTO tarefaBanco = obterPorId(id);
        Tarefa tarefa = mapper.map(dto, Tarefa.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tarefa.setUsuario(usuario);
        tarefa.setId(null);
        tarefa.setDataCriacao(tarefaBanco.getDataCriacao());
        tarefa = tarefaRepository.save(tarefa);
        return mapper.map(tarefa, TarefaResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        tarefaRepository.deleteById(id);
    }
    
}
