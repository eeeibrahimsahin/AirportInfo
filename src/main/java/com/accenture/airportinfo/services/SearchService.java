package com.accenture.airportinfo.services;

import com.accenture.airportinfo.exceptions.CountryCodeNotFoundException;
import com.accenture.airportinfo.models.Airport;
import com.accenture.airportinfo.models.Country;
import com.accenture.airportinfo.models.Runway;

import java.util.*;
import java.util.stream.Collectors;

import static com.accenture.airportinfo.constants.Constant.*;

public final class SearchService {

    static {
        countries = CsvConverterService.convert(PATH_COUNTRIES_CSV_FILE, Country.class);
        airports = CsvConverterService.convert(PATH_AIRPORTS_CSV_FILE, Airport.class);
        runways = CsvConverterService.convert(PATH_RUNWAYS_CSV_FILE, Runway.class);
    }

    public static void printRunwaysForEachAirportByCountryName(final String countryName) {

        final List<Country> countryList = countries
                .stream()
                .filter(c ->
                        c.getName().toUpperCase().startsWith(countryName.toUpperCase()))
                .collect(Collectors.toList());


        countryList.forEach(
                country -> printByCountryName(country.getCode())
        );

    }

    public static void printTop10CountriesWithHighestNumberOfAirports() {
        setSortedMapWithHighestNumberOfAirports()
                .entrySet()
                .stream()
                .limit(10)
                .forEach(
                        entry -> System.out.println(COUNTRY_NAME + entry.getKey().getName() + ", "
                                + AIRPORT_NUMBER + entry.getValue().size())
                );
    }

    public static void printRunwaysForEachAirportByCountryCode(String countryCode) {
        try {
            getRunwaysForEachAirportByCountryCode(countryCode)
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(o -> o.getValue().size()))
                    .forEach((entry) -> System.out.println(SEPARATION +
                            AIRPORT_NAME + entry.getKey().getName() + "\n" +
                            RUNWAYS_NUMBER + entry.getValue().size() + "\n" +
                            RUNWAYS_INFORMATION + entry.getValue() + "\n" +
                            SEPARATION));
        } catch (CountryCodeNotFoundException e) {
            System.out.println(COUNTRY_CODE_NOT_EXIST);
        }
    }

    private static void printByCountryName(final String countryCode) {
        getRunwaysForEachAirportByCountryCode(countryCode)
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().size()))
                .forEach((entry) -> System.out.println(SEPARATION +
                        AIRPORT_NAME + entry.getKey().getName() + " - " +
                        entry.getKey().getIso_country() + "\n" +
                        RUNWAYS_NUMBER + entry.getValue().size() + "\n" +
                        RUNWAYS_INFORMATION + entry.getValue() + "\n" +
                        SEPARATION));
    }


    private static Map<Airport, List<Runway>> getRunwaysForEachAirportByCountryCode(final String countryCode)
            throws CountryCodeNotFoundException {

        final Map<Airport, List<Runway>> airportAndRunways = new HashMap<>();

        final Country country = countries
                .stream()
                .filter(
                        c -> c.getCode().equalsIgnoreCase(countryCode))
                .findFirst()
                .orElseThrow(CountryCodeNotFoundException::new);

        final List<Airport> airportList = airports
                .stream()
                .filter(airport -> airport.getIso_country().equalsIgnoreCase(country.getCode()))
                .collect(Collectors.toList());


        airportList.forEach(airport ->
                airportAndRunways
                        .put(airport, runways
                                .stream()
                                .filter(runway -> runway.getAirport_ref() == airport.getId())
                                .collect(Collectors.toList())
                        )
        );

        return airportAndRunways;
    }

    private static Map<Country, List<Airport>> setMapCountryAirportPair() {
        Map<Country, List<Airport>> hashmapCountryAirport = new HashMap<>();

        countries.forEach(
                country -> hashmapCountryAirport.put(
                        country, airports
                                .stream()
                                .filter(airport -> airport.getIso_country().equals(country.getCode()))
                                .collect(Collectors.toList())
                )
        );
        return hashmapCountryAirport;
    }

    private static Map<Country, List<Airport>> setSortedMapWithHighestNumberOfAirports() {
        return setMapCountryAirportPair()
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
    }


    private static final List<Country> countries;
    private static final List<Airport> airports;
    private static final List<Runway> runways;

    private SearchService() {
    }
}
