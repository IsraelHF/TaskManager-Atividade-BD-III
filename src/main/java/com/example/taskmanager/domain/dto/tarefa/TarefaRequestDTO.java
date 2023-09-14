package com.example.taskmanager.domain.dto.tarefa;

import java.util.Date;
import java.util.List;

import com.example.taskmanager.domain.Enum.EStatusTarefa;
import com.example.taskmanager.domain.dto.listadetarefas.ListaDeTarefasRequestDTO;

public class TarefaRequestDTO {
    private Long id;
    private String descricao;
    private EStatusTarefa status;
    private List<ListaDeTarefasRequestDTO> listasDeTarefas;
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
    public List<ListaDeTarefasRequestDTO> getListasDeTarefas() {
        return listasDeTarefas;
    }
    public void setListasDeTarefas(List<ListaDeTarefasRequestDTO> listasDeTarefas) {
        this.listasDeTarefas = listasDeTarefas;
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
