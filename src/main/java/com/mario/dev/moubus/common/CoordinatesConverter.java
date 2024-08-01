package com.mario.dev.moubus.common;

import lombok.Data;

public class CoordinatesConverter {

    /**
     * Simple coordinates representation using latitude and longitude.
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
     * @see Coordinates
     * @param coordinates
     * @return
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

    /**
     * Converts coordinates from a Coordinates object to the format:
     * XXXºXXX'XXX"<N/S> XXXºXXX'XXX"<W/E>
     * For example: 23º32'12"N 46º45'12"W
     * 
     * @see Coordinates
     * @param coordinates
     * @return
     */
    public static String doubleToStr(final Coordinates coordinates) {
        StringBuilder sb = new StringBuilder();
        double lat = coordinates.latitude();
        double lon = coordinates.longitude();
        if (lat < 0) {
            sb.append(-lat).append("S ");
        } else {
            sb.append(lat).append("N ");
        }
        if (lon < 0) {
            sb.append(-lon).append("W");
        } else {
            sb.append(lon).append("E");
        }
        return sb.toString();
    }
}
