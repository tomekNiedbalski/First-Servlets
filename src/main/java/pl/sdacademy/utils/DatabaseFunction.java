package pl.sdacademy.utils;

import pl.sdacademy.enums.Sex;
import pl.sdacademy.model.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFunction {

    public List<Person> getPersons(){
        List<Person> personList = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite://d:peopleDB.db");
            String selectQuery = "SELECT * FROM people";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()){
                String sexString = resultSet.getString(5);

                    Person person = new Person(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            Sex.FEMALE);
                if(sexString.equals("M")){
                 person.setSex(Sex.MALE);
                }
                personList.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;
    }
}
