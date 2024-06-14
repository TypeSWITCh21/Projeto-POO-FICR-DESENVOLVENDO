package model;

import java.time.LocalDateTime;

public class Evento {
    private int id;
    private String nome;
    private LocalDateTime dataHora;
    private int idSocio;

    public Evento(int id, String nome, LocalDateTime dataHora, int idSocio) {
        this.id = id;
        this.nome = nome;
        this.dataHora = dataHora;
        this.idSocio = idSocio;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
}
