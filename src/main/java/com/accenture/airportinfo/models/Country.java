package com.accenture.airportinfo.models;

import com.opencsv.bean.CsvBindByName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Country {
    @CsvBindByName
    private int id;
    @CsvBindByName
    private String code;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String continent;
    @CsvBindByName
    private String wikipedia_link;
    @CsvBindByName
    private String keywords;
}
