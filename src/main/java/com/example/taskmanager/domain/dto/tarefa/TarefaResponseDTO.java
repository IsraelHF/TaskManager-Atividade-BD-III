package com.example.taskmanager.domain.dto.tarefa;

import java.util.Date;

import com.example.taskmanager.domain.Enum.EStatusTarefa;
import com.example.taskmanager.domain.dto.disciplina.DisciplinaResponseDTO;

public class TarefaResponseDTO {
    private Long id;
    private String descricao;
    private EStatusTarefa status;
    private DisciplinaResponseDTO disciplina;
    private Double nota;
    private Date dataCriacao;
    private Date dataLimite;
    private Date dataTermino;
    private String observacao;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public EStatusTarefa getStatus() {
        return status;
    }
    public void setStatus(EStatusTarefa status) {
        this.status = status;
    }
    public DisciplinaResponseDTO getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(DisciplinaResponseDTO disciplina) {
        this.disciplina = disciplina;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Date getDataLimite() {
        return dataLimite;
    }
    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }
    public Date getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
