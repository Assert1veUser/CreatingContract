package ru.markin.task3;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import ru.markin.task1.*;
import ru.markin.task2.Main2;

public class Main3 {
    public static Integer RandomSerialNumber(){
        return new Random().nextInt(100, 1000000000);
    }
    private static Map<String, Integer> mapStuff = new TreeMap<>();
    private static Map<String, Integer> mapClient = new TreeMap<>();
    private static Map<String, Integer> mapSurnameClient = new TreeMap<>();
    private static Set<String> setSurnameClient = new HashSet<>();
    private static List<Offer> offers = new ArrayList<Offer>();
    private static List<Client> clients = new ArrayList<Client>();
    private static List<Stuff> stuffs = new ArrayList<Stuff>();
    public static void main(String[] args) throws IOException{

        stuffs.add(new Stuff(
                UUID.randomUUID(),
                "Иванов",
                "Иван",
                "Иванович",
                false,
                LocalDate.of(1980,10, 03),
                3.14,
                new Position(
                        UUID.randomUUID(),
                        "Менеджер",
                        145000
                )
        ));
        Integer count = 0;
        Integer countOffer = 0;
        Integer countStuffs = stuffs.size();
        Boolean indicatorCreate = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите дейтсвие:");
        if( reader.readLine().equals("Новый договор")){
            indicatorCreate = true;
        }
        else{
            indicatorCreate = false;
        }
        while(indicatorCreate == true){
            Integer numberOfContracts = 0;
            String numb = RandomSerialNumber().toString();
            Integer numberStauff = new Random().nextInt(0, countStuffs);
            clients.add(new Client());
            clients.get(count).setId(UUID.randomUUID());
            String day;
            String sex1;
            System.out.println("Введите информацию о клиенте.");
            System.out.print("Фамилия*: ");
            clients.get(count).setSurname(reader.readLine());
            if (clients.get(count).getSurname().equals("")){
                while (clients.get(count).getSurname().equals("")){
                    System.out.println("Это поле обязательно к заполнению!");
                    System.out.print("Фамилия*: ");
                    clients.get(count).setSurname(reader.readLine());
                }
            }
            System.out.print("Имя*: ");
            clients.get(count).setName(reader.readLine());
            if (clients.get(count).getName().equals("")){
                while (clients.get(count).getName().equals("")){
                    System.out.println("Это поле обязательно к заполнению!");
                    System.out.print("Имя*: ");
                    clients.get(count).setName(reader.readLine());
                }
            }
            System.out.print("Отчество*: ");
            clients.get(count).setPatronymic(reader.readLine());
            if (clients.get(count).getPatronymic().equals("")){
                while (clients.get(count).getPatronymic().equals("")){
                    System.out.println("Это поле обязательно к заполнению!");
                    System.out.print("Отчество*: ");

                    clients.get(count).setPatronymic(reader.readLine());
                }
            }
            System.out.print("Дата рождения* - ");
            day = reader.readLine();
            if (day.equals("")){
                while (day.equals("")){
                    System.out.println("Это поле обязательно к заполнению!");
                    System.out.print("Дата рождения*: ");
                    day = reader.readLine();
                }
            }
            clients.get(count).setBirthDate(LocalDate.parse(day));
            System.out.print("ИНН*: ");
            clients.get(count).setInn(reader.readLine());
            if (clients.get(count).getInn().equals("")){
                while (clients.get(count).getInn().equals("")){
                    System.out.println("Это поле обязательно к заполнению!");
                    System.out.print("ИНН*: ");
                    clients.get(count).setInn(reader.readLine());
                }
            }
            System.out.print("Серия номер паспорта*: ");
            clients.get(count).setPasspartSeriel(reader.readLine());
            if (clients.get(count).getPasspartSeriel().equals("")){
                while (clients.get(count).getPasspartSeriel().equals("")){
                    System.out.println("Это поле обязательно к заполнению!");
                    System.out.print("Серия номер паспорта*: ");
                    clients.get(count).setPasspartSeriel(reader.readLine());
                }
            }
            System.out.print("Пол: ");
            sex1 = reader.readLine();
            if (sex1.equals("М")) {
                clients.get(count).setSex(false);
            } else if (sex1.equals("Ж")) {
                clients.get(count).setSex(true);
            }
            System.out.print("Номер телефона (Пример: 89565678954): ");
            clients.get(count).setPhone(reader.readLine());
            Main2.recordJson(clients.get(count));
            offers.add(new Offer(
                    UUID.randomUUID(),
                    numb,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusYears(1L),
                    LocalDateTime.now(),
                    clients.get(count),
                    stuffs.get(numberStauff),
                    new Office(
                            UUID.randomUUID(),
                            "г.Москва, ул.Пушкина, д.10, стр.1",
                            "г.Хабаровск, ул.Пушкина, д.10, стр.1",
                            124
                    )
            ));
            count += 1;

            for (int j = 0; j < offers.size(); j++){
                if (offers.get(j).getStuff().getId().equals(stuffs.get(numberStauff).getId())){
                    numberOfContracts += 1;
                }
            }
            mapStuff.put(stuffs.get(numberStauff).getSurname(), numberOfContracts);

            countOffer += 1;
            mapClient.put("Договор", countOffer);

            List<String> clientsSurname = new ArrayList<String>();
            for (int k = 0; k < clients.size(); k++){
                clientsSurname.add(clients.get(k).getSurname());
                setSurnameClient.add(clients.get(k).getSurname());
            }
            for (int l = 0; l < clientsSurname.size(); l++){
                Integer countA = Collections.frequency(clientsSurname,clients.get(l).getSurname());
                mapSurnameClient.put(clients.get(l).getSurname(), countA);
            }

            System.out.print("Введите дейтсвие:");
            if( reader.readLine().equals("Новый договор")){
                indicatorCreate = true;
            }
            else{
                indicatorCreate = false;
            }
        }
        for (int i = 0; i < offers.size(); i++){
            System.out.println(offers.get(i).getSerielNumber());
        }
        System.out.println("Найти договор?");
        String indicatorSearch = reader.readLine();
        while (indicatorSearch.equals("Да")){
            System.out.println("По фамилии, по номеру, по сотруднику?");
            String coun = reader.readLine();
            if (coun.equals("По номеру")){
                Boolean indicatorSearchId = false;
                String numId = reader.readLine();
                for (int i = 0; i < offers.size(); i++){
                    if(offers.get(i).getSerielNumber().equals(numId)){
                        indicatorSearchId = true;
                        break;
                    }
                }
                if (indicatorSearchId == true){
                    System.out.println("Договор найден");
                }else{
                    System.out.println("Договор не найден");
                }
                System.out.println("Найти договор?");
                indicatorSearch = reader.readLine();
            } else if (coun.equals("По фамилии")) {
                Boolean indicatorSearchSurname = false;
                Integer countOfferr = 0;;
                String numSurname = reader.readLine();
                for (int i = 0; i < offers.size(); i++){
                    if(offers.get(i).getClient().getSurname().equals(numSurname)){
                        indicatorSearchSurname = true;
                        countOfferr += 1;
                    }
                }
                if (indicatorSearchSurname == true){
                    System.out.println("Договоров найдено - " + countOfferr);
                }else{
                    System.out.println("Договор не найден");
                }
                System.out.println("Найти договор?");
                indicatorSearch = reader.readLine();
            } else if (coun.equals("По сотруднику")) {
                Integer countOfferSearchStuff = 0;
                Boolean indicatorSearchStuff = false;
                String numStuff = reader.readLine();
                for(int i = 0; i < offers.stream().count();i++){
                    if (offers.get(i).getStuff().getSurname().equals(numStuff)){
                        countOfferSearchStuff += 1;
                        indicatorSearchStuff = true;
                    }
                }
                if (indicatorSearchStuff == true){
                    System.out.println("Договоров найдено - " + countOfferSearchStuff);
                }else{
                    System.out.println("Договор не найден");
                }
                System.out.println("Найти договор?");
                indicatorSearch = reader.readLine();
            }
        }
        reader.close();
    }
}
