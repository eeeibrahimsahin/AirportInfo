package com.accenture.airportinfo.models;

import com.opencsv.bean.CsvBindByName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Runway {
    @CsvBindByName
    private int id;
    @CsvBindByName
    private int airport_ref;
    @CsvBindByName
    private String airport_ident;
    @CsvBindByName
    private int length_ft;
    @CsvBindByName
    private int width_ft;
    @CsvBindByName
    private String surface;
    @CsvBindByName
    private int lighted;
    @CsvBindByName
    private int closed;
    @CsvBindByName
    private String le_ident;
    @CsvBindByName
    private double le_latitude_deg;
    @CsvBindByName
    private double le_longitude_deg;
    @CsvBindByName
    private int le_elevation_ft;
    @CsvBindByName
    private double le_heading_degT;
    @CsvBindByName
    private int le_displaced_threshold_ft;
    @CsvBindByName
    private String he_ident;
    @CsvBindByName
    private double he_latitude_deg;
    @CsvBindByName
    private double he_longitude_deg;
    @CsvBindByName
    private int he_elevation_ft;
    @CsvBindByName
    private double he_heading_degT;
    @CsvBindByName
    private int he_displaced_threshold_ft;

}
