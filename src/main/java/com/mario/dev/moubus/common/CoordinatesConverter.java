package com.mario.dev.moubus.common;

import lombok.Data;

public class CoordinatesConverter {

    /**
     * Coordinates
     */
    public record Coordinates(double latitude, double longitude) {
    }

    /**
     * Converts coordintates from the format: XXXºXXX'XXX"<N/S>
     * XXXºXXX'XXX"<W/E> to a Coordinates object.
     * For example: 23º32'12"N 46º45'12"W
     * 
     * @see <a href=
     *      "https://en.wikipedia.org/wiki/Geographic_coordinate_system">Geographic
     *      coordinate system</a>
     */
    public static Coordinates strToDouble(final String coordinates) {
        String[] coordsStr = coordinates.split(" ");
        if (coordsStr.length != 2) {
            throw new IllegalArgumentException("Invalid coordinates format");
        }
        double[] coords = new double[2];
        for (int i = 0; i < 2; i++) {
            char lastChar = coordsStr[i].charAt(coordsStr[i].length() - 1);
            String[] degreesMinutesSeconds = coordsStr[i].substring(0, coordsStr[i].length() - 1).split("º|'|\"");
            coords[i] = Double.parseDouble(degreesMinutesSeconds[0])
                    + Double.parseDouble(degreesMinutesSeconds[1]) / 60
                    + Double.parseDouble(degreesMinutesSeconds[2]) / 3600;
            if (lastChar == 'S' || lastChar == 'W') {
                coords[i] *= -1;
            }
        }
        return new Coordinates(coords[0], coords[1]);
    }
}
