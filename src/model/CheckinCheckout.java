package model;

import java.time.LocalDateTime;

public class CheckinCheckout {
    private int id;
    private int idSocio;
    private LocalDateTime dataHoraCheckin;
    private LocalDateTime dataHoraCheckout;

    public CheckinCheckout(int id, int idSocio, LocalDateTime dataHoraCheckin, LocalDateTime dataHoraCheckout) {
        this.id = id;
        this.idSocio = idSocio;
        this.dataHoraCheckin = dataHoraCheckin;
        this.dataHoraCheckout = dataHoraCheckout;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public LocalDateTime getDataHoraCheckin() {
        return dataHoraCheckin;
    }

    public void setDataHoraCheckin(LocalDateTime dataHoraCheckin) {
        this.dataHoraCheckin = dataHoraCheckin;
    }

    public LocalDateTime getDataHoraCheckout() {
        return dataHoraCheckout;
    }

    public void setDataHoraCheckout(LocalDateTime dataHoraCheckout) {
        this.dataHoraCheckout = dataHoraCheckout;
    }
}
