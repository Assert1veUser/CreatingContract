package ru.markin.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class LeasingOfferService implements OfferService{
    private final Office office;
    private static LeasingOfferService instance;

    private LeasingOfferService() {
        office = new Office();
        office.setId(UUID.randomUUID());
        office.setAddres("Москва, Стромынка");
        office.setLawAddress("Москва, пр-т. Вернадского");
        office.setCabinetsCount(100);
    }

    public static LeasingOfferService getInstance() {
        if (instance == null){
            instance = new LeasingOfferService();
        }
        return instance;
    }
    public String generateSerialNumber() {
        return String.format("№228%d%s", new Random().nextInt(10),
                DateTimeFormatter.ISO_DATE.format(LocalDate.now()));
    }
    @Override
    public Offer signNewOffer(LocalDateTime startDate, LocalDateTime endingDate, Client client, Stuff stuff) {
        Offer offer = new Offer(
                UUID.randomUUID(),
                generateSerialNumber(),
                LocalDateTime.now(),
                endingDate,
                startDate,
                client,
                stuff,
                office
        );
        return offer;
    }

}
