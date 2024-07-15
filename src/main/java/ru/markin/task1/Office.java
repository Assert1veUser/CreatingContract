package ru.markin.task1;

import java.util.UUID;

public class Office {
    private UUID id;
    private String addres;
    private String lawAddress;
    private Integer cabinetsCount;

    public Office() {
    }

    public Office(UUID id, String addres, String lawAddress, Integer cabinetsCount) {
        this.id = id;
        this.addres = addres;
        this.lawAddress = lawAddress;
        this.cabinetsCount = cabinetsCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getLawAddress() {
        return lawAddress;
    }

    public void setLawAddress(String lawAddress) {
        this.lawAddress = lawAddress;
    }

    public Integer getCabinetsCount() {
        return cabinetsCount;
    }

    public void setCabinetsCount(Integer cabinetsCount) {
        this.cabinetsCount = cabinetsCount;
    }
}
