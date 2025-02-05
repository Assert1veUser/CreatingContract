package ru.markin.task1;

import java.time.LocalDate;
import java.util.UUID;

public class Client {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private Boolean sex;
    private LocalDate birthDate;
    private String inn;
    private String passpartSeriel;
    private String phone;

    public Client() {
    }

    public Client(UUID id, String surname, String name, String patronymic, Boolean sex, LocalDate birthDate, String inn, String passpartSeriel, String phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.birthDate = birthDate;
        this.inn = inn;
        this.passpartSeriel = passpartSeriel;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPasspartSeriel() {
        return passpartSeriel;
    }

    public void setPasspartSeriel(String passpartSeriel) {
        this.passpartSeriel = passpartSeriel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
