package com.accenture.airportinfo.exceptions;

public class CountryCodeNotFoundException extends RuntimeException {
    public CountryCodeNotFoundException() {
        this("Country Code not exists");
    }

    public CountryCodeNotFoundException(String message) {
        super(message);
    }
}
