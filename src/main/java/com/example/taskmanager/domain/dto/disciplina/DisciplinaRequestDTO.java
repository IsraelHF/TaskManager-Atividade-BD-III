package com.example.taskmanager.domain.dto.disciplina;

public class DisciplinaRequestDTO {
    private Long id;
    private String nome;
    private String professor;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
