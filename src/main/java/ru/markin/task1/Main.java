package ru.markin.task1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException{
        OfferService service = LeasingOfferService.getInstance();
        Client client = new Client(
                UUID.randomUUID(),
                "Маркин",
                "Антон",
                "Алексеевич",
                Boolean.FALSE,
                LocalDate.of(2003,10,04),
                "12345",
                "34543579064",
                "89644224848"
        );
        Position position = new Position(
                UUID.randomUUID(),
                "Менеджер",
                145000
        );
        Stuff stuff = new Stuff(
                UUID.randomUUID(),
                "Логиноа",
                "Андрей",
                "Александрович",
                false,
                LocalDate.of(2003, 11, 30),
                0.5,
                position
        );
        Offer offer = service.signNewOffer(LocalDateTime.now(), LocalDateTime.now().plusYears(1L), client, stuff);
    }

}
