package model;

import java.time.LocalDate;

public class Fatura {
    private int idEvento;
    private double valor;
    private LocalDate dataVencimento;

    public Fatura(int idEvento, double valor, LocalDate dataVencimento) {
        this.idEvento = idEvento;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
    }

    
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
