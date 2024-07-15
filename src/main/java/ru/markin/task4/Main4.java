package ru.markin.task4;

import com.opencsv.CSVReader;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Main4 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        readCsv();
        nameStat();
        sexStat();
        mounthStat();
        salaryStat();
    }
    static final Integer ID_COLUMN_INDEX = 0;
    static final Integer SURNAME_COLUMN_INDEX = 1;
    static final Integer NAME_COLUMN_INDEX = 2;
    static final Integer PATRONYMIC_COLUMN_INDEX = 3;
    static final Integer SEX_COLUMN_INDEX = 4;
    static final Integer BIRTHDATE_COLUMN_INDEX = 5;
    static final Integer SALARY_COLUMN_INDEX = 6;
    private static List<ru.markin.task4.Stuff> stuffss = new ArrayList<>();
    public static void readCsv() throws IOException{
        CSVReader csvReader = new CSVReader(new FileReader("D:\\java fails\\CreatingContract\\Stuff.csv"));
        String[] nextline = csvReader.readNext();
        
        while ((nextline = csvReader.readNext()) != null){
            Stuff stuff = new Stuff(
                    UUID.fromString(nextline[ID_COLUMN_INDEX]),
                    nextline[SURNAME_COLUMN_INDEX],
                    nextline[NAME_COLUMN_INDEX],
                    nextline[PATRONYMIC_COLUMN_INDEX],
                    Boolean.valueOf(nextline[SEX_COLUMN_INDEX]),
                    LocalDate.parse(nextline[BIRTHDATE_COLUMN_INDEX]),
                    Integer.parseInt(nextline[SALARY_COLUMN_INDEX])
                    );
            stuffss.add(stuff);

        }
    }
    public static void nameStat(){
        List<String> nameStuff = new ArrayList<>();
        for (int i = 0; i < stuffss.size(); i++){
            nameStuff.add(stuffss.get(i).getName());
        }
        Stream stream = nameStuff.stream();
        Long countIvan = stream.filter(x-> x.equals("Иван")).count();
        System.out.println("Колличество людей с именем Иван: " + countIvan);
    }
    public static void sexStat(){
        List<String> sexStuff = new ArrayList<>();
        for (int i = 0; i < stuffss.size(); i++){
            sexStuff.add(stuffss.get(i).getSex().toString());
        }
        Stream<String> streamSexWoman = sexStuff.stream();
        Long countTrue = streamSexWoman.filter(x-> x.equals("true")).count();

        Stream<String> streamSexMan = sexStuff.stream();
        Long countFalse = streamSexMan.filter(x -> x.equals("false")).count();

        System.out.println("Колличество мужчин: " + countFalse);
        System.out.println("Колличесвто женщин: " + countTrue);
    }
    public static void mounthStat(){
        List<String> mounthStuff = new ArrayList<>();
        for (int i = 0; i < stuffss.size(); i++){
            mounthStuff.add(stuffss.get(i).getBirthDate().getMonth().toString());
        }
        Stream<String> streamMounth = mounthStuff.stream();
        Long countSeptember = streamMounth.filter(x-> x.equals("SEPTEMBER")).count();
        System.out.println("Колличество людей рожденных в сентябре: " + countSeptember);
    }
    public static void salaryStat(){
        List<Integer> salaryStuff = new ArrayList<>();
        for (int i = 0; i < stuffss.size(); i++ ){
            salaryStuff.add(stuffss.get(i).getSalary());
        }
        Stream<Integer> streamSalary1 = salaryStuff.stream();
        Long count1 = streamSalary1.filter(x-> x.hashCode() < 40000).count();
        System.out.println("Колличество людей, имеющих зарплату мешьне 40.000: " + count1);
        Stream<Integer> streamSalary2 = salaryStuff.stream();
        Long count2 = streamSalary2.filter(x-> x.hashCode() <= 80000 & x.hashCode() >= 40000).count();
        System.out.println("Колличество людей, имеющих зарплату от 40.000 до 80.000: " + count2);
        Stream<Integer> streamSalary3 = salaryStuff.stream();
        Long count3 = streamSalary3.filter(x-> x.hashCode() >= 80000).count();
        System.out.println("Колличество людей, имеющих зарплату больше 80.000: " + count3);

    }
}
