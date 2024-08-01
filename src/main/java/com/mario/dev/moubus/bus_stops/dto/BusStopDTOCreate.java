package com.mario.dev.moubus.bus_stops.dto;

public record BusStopDTOCreate(
                String street,
                String city,
                String province,
                /**
                 * The coordinates of the bus stop in the format: XXXºXXX'XXX"<N/S>
                 * XXXºXXX'XXX"<W/E>.
                 * For example: 23º32'12"N 46º45'12"W
                 * 
                 * @see <a href=
                 *      "https://en.wikipedia.org/wiki/Geographic_coordinate_system">Geographic
                 *      coordinate system</a>
                 */
                String coordinates) {

}
