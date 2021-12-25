package com.accenture.airportinfo.exceptions;

public class CsvFileNotFoundException extends RuntimeException {
    public CsvFileNotFoundException() {
    }

    public CsvFileNotFoundException(String message) {
        super(message);
    }
}
