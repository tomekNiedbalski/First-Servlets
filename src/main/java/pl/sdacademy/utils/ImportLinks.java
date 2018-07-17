package pl.sdacademy.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportLinks {

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
}
