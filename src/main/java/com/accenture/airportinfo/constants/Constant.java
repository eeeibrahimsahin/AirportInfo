package com.accenture.airportinfo.constants;

public final class Constant {
    public static final String PATH_AIRPORTS_CSV_FILE = "src/main/resources/airports.csv";
    public static final String PATH_COUNTRIES_CSV_FILE = "src/main/resources/countries.csv";
    public static final String PATH_RUNWAYS_CSV_FILE = "src/main/resources/runways.csv";
    public static final String SEPARATION = "----------------\n";
    public static final String AIRPORT_NAME = "Airport Name: ";
    public static final String RUNWAYS_NUMBER = "Number of runways: ";
    public static final String RUNWAYS_INFORMATION = "Runways Information: ";
    public static final String COUNTRY_CODE_NOT_EXIST = "Country Code not exist!";
    public static final String COUNTRY_NAME = "Country Name: ";
    public static final String AIRPORT_NUMBER = "Number of Airports: ";
    public static final String INVALID_SELECTION = "Invalid selection please choose an option that just in the list";
    public static final String EXIT_MESSAGE = "Fijne Dagg...";
    public static final String ENTER_COUNTRY_CODE = "Enter a country code: ";
    public static final String ENTER_COUNTRY_NAME = "Enter a country name: ";
    public static final String ENTER_A_NUMBER = "Enter just a number! ";
    public static final String ENTER_SELECTION = "Enter your selection: ";
    public static final String SELECTION_MENU = "-----------Selection Menu-----------\n" +
            "Choose an option from the following list\n" +
            "1- Print runways for each airport by a country code\n" +
            "2- Print runways for each airport by a country name\n" +
            "3- Print runways for each airport by a country name\n" +
            "4- Exit\n";

    private Constant() {
    }
}
