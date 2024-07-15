package ru.markin.task1;

import java.time.LocalDateTime;
import java.util.UUID;

public class Offer {
    private UUID id;
    private String serielNumber;
    private LocalDateTime signDate;
    private LocalDateTime endingDate;
    private LocalDateTime startDate;
    private Client client;
    private Stuff stuff;
    private Office office;

    public Offer() {
    }

    public Offer(UUID id, String serielNumber, LocalDateTime signDate, LocalDateTime endingDate, LocalDateTime startDate, Client client, Stuff stuff, Office office) {
        this.id = id;
        this.serielNumber = serielNumber;
        this.signDate = signDate;
        this.endingDate = endingDate;
        this.startDate = startDate;
        this.client = client;
        this.stuff = stuff;
        this.office = office;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerielNumber() {
        return serielNumber;
    }

    public void setSerielNumber(String serielNumber) {
        this.serielNumber = serielNumber;
    }

    public LocalDateTime getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDateTime signDate) {
        this.signDate = signDate;
    }

    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

}
