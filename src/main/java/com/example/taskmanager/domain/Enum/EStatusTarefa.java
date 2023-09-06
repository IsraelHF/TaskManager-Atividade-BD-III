package com.example.taskmanager.domain.Enum;

public enum EStatusTarefa {
    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDA("Concluída");

    private String estado;

    private EStatusTarefa(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
