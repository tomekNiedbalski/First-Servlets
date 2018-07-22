package pl.sdacademy.model;

import java.util.Date;

public class Museum {

    private int id;
    private String name;
    private String postalCode;
    private String city;
    private String streetPrefix;
    private String street;
    private String streetNumber;
    private String homeNumber;
    private String museumFoundator;
    private String dateOfEntry;
    private String status;

    public Museum(int id, String name, String postalCode, String city, String streetPrefix,
                  String street, String streetNumber, String homeNumber, String museumFoundator,
                  String dateOfEntry, String status) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.city = city;
        this.streetPrefix = streetPrefix;
        this.street = street;
        this.streetNumber = streetNumber;
        this.homeNumber = homeNumber;
        this.museumFoundator = museumFoundator;
        this.dateOfEntry = dateOfEntry;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreetPrefix() {
        return streetPrefix;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMuseumFoundator() {
        return museumFoundator;
    }

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public String getStatus() {
        return status;
    }

    public static class MuseumBuilder{

        private int id;
        private String name;
        private String postalCode;
        private String city;
        private String streetPrefix;
        private String street;
        private String streetNumber;
        private String homeNumber;
        private String museumFoundator;
        private String dateOfEntry;
        private String status;

        public static MuseumBuilder builder(){
            return new MuseumBuilder();
        }

        public MuseumBuilder id(int id){
            this.id = id;
            return this;
        }
        public MuseumBuilder name(String name){
            this.name = name;
            return this;
        }public MuseumBuilder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }public MuseumBuilder city(String city){
            this.city = city;
            return this;
        }public MuseumBuilder streetPrefix(String streetPrefix){
            this.streetPrefix = streetPrefix;
            return this;
        }public MuseumBuilder street(String  street){
            this.street = street;
            return this;
        }public MuseumBuilder streetNumber(String streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }public MuseumBuilder homeNumber(String homeNumber){
            this.homeNumber = homeNumber;
            return this;
        }public MuseumBuilder museumFoundator(String museumFoundator){
            this.museumFoundator = museumFoundator;
            return this;
        }public MuseumBuilder dateOfEntry(String dateOfEntry){
            this.dateOfEntry = dateOfEntry;
            return this;
        }public MuseumBuilder status(String status){
            this.status = status;
            return this;
        }

        public Museum build(){
            return new Museum(id, name, postalCode, city, streetPrefix, street, streetNumber, homeNumber, museumFoundator, dateOfEntry, status);
        }

    }
}
