package pl.sdacademy.utils;

import pl.sdacademy.enums.Sex;
import pl.sdacademy.model.Museum;
import pl.sdacademy.model.Person;
import pl.sdacademy.model.User;

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

                    Person person = new Person(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            Sex.FEMALE);
                if(sexString.equals("M")){
                 person.setSex(Sex.MALE);
                }
                personList.add(person);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;
    }

    public boolean checkForLogin(String login){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite://d:users.db");
            String query = "SELECT * FROM users WHERE login = '"+login+"'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeAccessToDatabase(connection, preparedStatement, resultSet);
        }
        return true;
    }

    private void closeAccessToDatabase(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String login){
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite://d:users.db");
            String query = "SELECT * FROM users WHERE login = '"+login+"'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            user = new User(resultSet.getString(1),resultSet.getString(2));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeAccessToDatabase(connection, preparedStatement, resultSet);
        }
        return user;
    }

    public void addMuseumsFromCsv(List<Museum> museums){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite://d:museums.db");
            String addingQuery = "INSERT INTO museums(name, postal_code, city, street_prefix, street, street_number, " +
                                                        "home_number, museum_foundator, date_of_singin, status ) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(addingQuery);
            for (Museum museum : museums) {
                insertStatement = connection.prepareStatement(addingQuery);
                insertStatement.setString(1, museum.getName());
                insertStatement.setString(2, museum.getPostalCode());
                insertStatement.setString(3, museum.getCity());
                insertStatement.setString(4, museum.getStreetPrefix());
                insertStatement.setString(5, museum.getStreet());
                insertStatement.setString(6, museum.getStreetNumber());
                insertStatement.setString(7, museum.getHomeNumber());
                insertStatement.setString(8, museum.getMuseumFoundator());
                insertStatement.setString(9, museum.getDateOfEntry());
                insertStatement.setString(10, museum.getStatus());

                insertStatement.executeUpdate();
            }
            insertStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Museum> getMuseums(){
        List<Museum> museums = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite://d:museums.db");
            String addingQuery = "SELECT * FROM museums";
            PreparedStatement selectStatement = connection.prepareStatement(addingQuery);

            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()){
                Museum museum = new Museum(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11));
                museums.add(museum);
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return museums;
    }
}
