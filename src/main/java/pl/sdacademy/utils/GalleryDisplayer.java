package pl.sdacademy.utils;

import java.util.List;

public class GalleryDisplayer {

    public String prepareTableData(String choice, List<String> linkList){
        int choiceInt;
        if (choice == null){
            choiceInt = 3;
        }
        else {
            choiceInt = Integer.parseInt(choice);
        }
        StringBuilder tableDataBuilder = new StringBuilder();
        StringBuilder tableRowBuilder = new StringBuilder();
        StringBuilder returnValue = new StringBuilder();
        for (int i = 1; i <= linkList.size(); i++) {
            if(i%choiceInt != 0){
                tableDataBuilder.append("<td><img src='" + linkList.get(i-1) + "' , width='200', height='150'></td>");
            }
            else {
                tableDataBuilder.append("<td><img src='" + linkList.get(i-1) + "' , width='200', height='150'></td>");
                tableRowBuilder.append("<tr>")
                        .append(tableDataBuilder)
                        .append("</tr>");
                returnValue.append(tableRowBuilder);
                tableDataBuilder = new StringBuilder();
                tableRowBuilder = new StringBuilder();
            }
            if (linkList.size()%choiceInt != 0 && i == linkList.size()){
                tableRowBuilder.append("<tr>")
                        .append(tableDataBuilder)
                        .append("</tr>");
                returnValue.append(tableRowBuilder);
            }
        }
        return returnValue.toString();
    }

}
