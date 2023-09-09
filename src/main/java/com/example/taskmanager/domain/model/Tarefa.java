package com.example.taskmanager.domain.model;

import java.sql.Date;
import java.util.List;

import com.example.taskmanager.domain.Enum.EStatusTarefa;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTitulo")
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    private EStatusTarefa status;
    @ManyToMany
    @JoinTable(name = "tarefa_listadetarefas", joinColumns = @JoinColumn(name = "idTarefa"), inverseJoinColumns = @JoinColumn(name = "idListaDeTarefas"))
    private List<ListaDeTarefas> listasDeTarefas;
    @Column(nullable = false)
    private Date dataCriacao;
    private Date dataLimite;
    private Date dataTermino;
    @Column(columnDefinition = "TEXT")
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EStatusTarefa getStatus() {
        return status;
    }

    public void setStatus(EStatusTarefa status) {
        this.status = status;
    }

    public List<ListaDeTarefas> getListasDeTarefas() {
        return listasDeTarefas;
    }

    public void setListasDeTarefas(List<ListaDeTarefas> listasDeTarefas) {
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
