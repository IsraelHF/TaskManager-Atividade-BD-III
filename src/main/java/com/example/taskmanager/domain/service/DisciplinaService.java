package com.example.taskmanager.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.taskmanager.domain.dto.disciplina.DisciplinaRequestDTO;
import com.example.taskmanager.domain.dto.disciplina.DisciplinaResponseDTO;
import com.example.taskmanager.domain.exception.ResourceNotFoundException;
import com.example.taskmanager.domain.model.Disciplina;
import com.example.taskmanager.domain.model.Usuario;
import com.example.taskmanager.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService implements ICRUDService<DisciplinaRequestDTO, DisciplinaResponseDTO>{
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<DisciplinaResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Disciplina> lista = disciplinaRepository.findByUsuario(usuario);
        return lista.stream().map(disciplina -> mapper.map(disciplina, DisciplinaResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DisciplinaResponseDTO obterPorId(Long id) {
        Optional<Disciplina> optDisciplina = disciplinaRepository.findById(id);
        if(optDisciplina.isEmpty()){
            throw new ResourceNotFoundException("Naõ foi possivel encontrar a disciplina com o id " + id);
        }
        return mapper.map(optDisciplina.get(), DisciplinaResponseDTO.class);
    }

    @Override
    public DisciplinaResponseDTO cadastrar(DisciplinaRequestDTO dto) {
        Disciplina disciplina = mapper.map(dto, Disciplina.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        disciplina.setUsuario(usuario);
        disciplina.setId(null);
        disciplina = disciplinaRepository.save(disciplina);
        return mapper.map(disciplina, DisciplinaResponseDTO.class);
    }

    @Override
    public DisciplinaResponseDTO atualizar(Long id, DisciplinaRequestDTO dto) {
        obterPorId(id);
        Disciplina disciplina = mapper.map(dto, Disciplina.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        disciplina.setUsuario(usuario);
        disciplina.setId(id);
        disciplina = disciplinaRepository.save(disciplina);
        return mapper.map(disciplina, DisciplinaResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        disciplinaRepository.deleteById(id);
    }
    
}
