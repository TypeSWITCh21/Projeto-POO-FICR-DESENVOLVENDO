package model;

import java.time.LocalDateTime;

public class Consumo {
    private Socio socio;
    private double valor;
    private LocalDateTime dataHora;

    public Consumo(Socio socio, double valor, LocalDateTime dataHora) {
        this.socio = socio;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
