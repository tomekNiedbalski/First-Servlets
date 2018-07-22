package pl.sdacademy.utils;

import pl.sdacademy.model.Museum;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImportFiles {

    public static void main(String[] args) {
//        List<Museum> museums = new ImportFiles().importMuseums();
//
//        System.out.println(museums.size());
//        System.out.println(museums.get(2).getDateOfEntry());

        DatabaseFunction databaseFunction = new DatabaseFunction();
        List<Museum> museums = databaseFunction.getMuseums();
        System.out.println(museums.size());


//        databaseFunction.addMuseumsFromCsv(museums);


    }

    public List<String> importLinks(){
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\niedb\\IdeaProjects\\HelloWeb\\src\\main\\resources\\linki.txt"));
            String line = br.readLine();
            while (line!=null) {
                list.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Museum> importMuseums(){
        List<Museum> museums = new ArrayList<>();
        BufferedReader reader;
        Museum museum;

        try {
            reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("museums.csv")));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                Date dateOfEntry = null;

                String[] splittedMuseum = line.split(";");

                    int id = Integer.parseInt(splittedMuseum[0]);
                    String name = splittedMuseum[1];
                    String postalCode = splittedMuseum[2];
                    String city = splittedMuseum[3];
                    String streetPrefix = splittedMuseum[4];
                    String street = splittedMuseum[5];
                    String streetNumber = splittedMuseum[6];

                    String homeNumber = splittedMuseum[7];
                    String museumFoundator = splittedMuseum[8];

                    String dateToParse = splittedMuseum[9];
//                if(!dateToParse.equals("")) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
//                    String dateInString = dateToParse.replace("\"","").replace(".", "-").substring(0,9);
//                    dateOfEntry = sdf.parse(dateInString);
//                }

                    String status = splittedMuseum[10];

                    museum = Museum.MuseumBuilder.builder()
                            .id(id)
                            .name(name)
                            .postalCode(postalCode)
                            .city(city)
                            .streetPrefix(streetPrefix)
                            .street(street)
                            .streetNumber(streetNumber)
                            .homeNumber(homeNumber)
                            .museumFoundator(museumFoundator)
                            .dateOfEntry(dateToParse)
                            .status(status)
                            .build();

                    museums.add(museum);
                    line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Import data error!!!");
        }

        return museums;
    }
}
