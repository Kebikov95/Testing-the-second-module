package optional;

import optional.airport.Airport;

public class AirportRunner {
    final static int runwayQuantity = 5;
    final static int planeQuantity = 10;

    public static void main(String[] args) {
        Airport airport = new Airport(5, 10);
        Thread thread = new Thread(airport);
        thread.start();
    }
}
