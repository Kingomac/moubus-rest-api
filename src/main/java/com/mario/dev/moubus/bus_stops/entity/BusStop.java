package com.mario.dev.moubus.bus_stops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;

@Data
@Entity
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String city;
    private String province;

    private double latitude;
    private double longitude;

    @Transient
    private String formattedCoordinates;

    public String getFormattedCoordinates() {
        char latitudeChar = latitude > 0 ? 'N' : 'S';
        char longitudeChar = longitude > 0 ? 'E' : 'W';
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.000000", symbols);
        return String.format("%s%s %s%s", df.format(Math.abs(latitude)), latitudeChar, df.format(Math.abs(longitude)),
                longitudeChar);
    }

}
