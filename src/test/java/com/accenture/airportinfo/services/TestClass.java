package com.accenture.airportinfo.services;

import com.opencsv.bean.CsvBindByName;


public class TestClass {
    @CsvBindByName
    private String testHeader;

    @Override
    public String toString() {
        return "testHeader=" + testHeader;
    }
}
