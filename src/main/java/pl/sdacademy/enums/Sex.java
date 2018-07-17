package pl.sdacademy.enums;

public enum Sex { MALE("M"), FEMALE("F");

    String symbol;

    Sex(String shorSex) {
        this.symbol = shorSex;
    }

    public String getSymbol() {
        return symbol;
    }
}
