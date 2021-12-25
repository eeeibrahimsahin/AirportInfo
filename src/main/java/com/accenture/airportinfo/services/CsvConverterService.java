package com.accenture.airportinfo.services;


import com.accenture.airportinfo.exceptions.CsvFileNotFoundException;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public final class CsvConverterService {

    public static <T> List<T> convert(final String path, final Class<T> tClass) {

        try {
            return new CsvToBeanBuilder<T>(new FileReader(path))
                    .withType(tClass).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CsvFileNotFoundException();
        }
    }

    private CsvConverterService() {
    }
}
