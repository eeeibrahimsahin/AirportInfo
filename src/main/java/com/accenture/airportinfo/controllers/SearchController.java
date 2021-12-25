package com.accenture.airportinfo.controllers;

import com.accenture.airportinfo.services.SearchService;
import com.accenture.airportinfo.views.MenuView;

import static com.accenture.airportinfo.constants.Constant.EXIT_MESSAGE;
import static com.accenture.airportinfo.constants.Constant.INVALID_SELECTION;


public final class SearchController {

    public static void start() {
        while (true) {
            int userSelection = MenuView.menu();
            if (userSelection == 1) {
                final String countryCode = MenuView.takeCountryCodeFromUser();
                SearchService.printRunwaysForEachAirportByCountryCode(countryCode);
            } else if (userSelection == 2) {
                final String countryName = MenuView.takeCountryNameFromUser();
                SearchService.printRunwaysForEachAirportByCountryName(countryName);
            } else if (userSelection == 3) {
                SearchService.printTop10CountriesWithHighestNumberOfAirports();
            } else if (userSelection == 4) {
                System.out.println(EXIT_MESSAGE);
                break;
            } else {
                System.out.println(INVALID_SELECTION);
            }
        }
    }

    private SearchController() {
    }
}