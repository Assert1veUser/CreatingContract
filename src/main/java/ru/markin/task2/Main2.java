package ru.markin.task2;

import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.UUID;
import com.google.gson.GsonBuilder;
import ru.markin.task1.Client;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Client client = new ru.markin.task1.Client();
        client.setId(UUID.randomUUID());
        String day;
        String sex1;
        System.out.println("Введите информацию о клиенте.");
        System.out.print("Фамилия*: ");
        client.setSurname(reader.readLine());
        if (client.getSurname().equals("")){
            while (client.getSurname().equals("")){
                System.out.println("Это поле обязательно к заполнению!");
                System.out.print("Фамилия*: ");
                client.setSurname(reader.readLine());
            }
        }
        System.out.print("Имя*: ");
        client.setName(reader.readLine());
        if (client.getName().equals("")){
            while (client.getName().equals("")){
                System.out.println("Это поле обязательно к заполнению!");
                System.out.print("Имя*: ");
                client.setName(reader.readLine());
            }
        }
        System.out.print("Отчество*: ");
        client.setPatronymic(reader.readLine());
        if (client.getPatronymic().equals("")){
            while (client.getPatronymic().equals("")){
                System.out.println("Это поле обязательно к заполнению!");
                System.out.print("Отчество*: ");

                client.setPatronymic(reader.readLine());
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
        client.setBirthDate(LocalDate.parse(day));
        System.out.print("ИНН*: ");
        client.setInn(reader.readLine());
        if (client.getInn().equals("")){
            while (client.getInn().equals("")){
                System.out.println("Это поле обязательно к заполнению!");
                System.out.print("ИНН*: ");
                client.setInn(reader.readLine());
            }
        }
        System.out.print("Серия номер паспорта*: ");
        client.setPasspartSeriel(reader.readLine());
        if (client.getPasspartSeriel().equals("")){
            while (client.getPasspartSeriel().equals("")){
                System.out.println("Это поле обязательно к заполнению!");
                System.out.print("Серия номер паспорта*: ");
                client.setPasspartSeriel(reader.readLine());
            }
        }
        System.out.print("Пол: ");
        sex1 = reader.readLine();
        if (sex1.equals("М")) {
            client.setSex(false);
        } else if (sex1.equals("Ж")) {
            client.setSex(true);
        }
        System.out.print("Номер телефона (Пример: 89565678954): ");
        client.setPhone(reader.readLine());
        recordJson(client);
        reader.close();
    }
    public static void recordJson(Client client) throws IOException{
        String path = "client.json";
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            String jsonString = gson.toJson(client);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
