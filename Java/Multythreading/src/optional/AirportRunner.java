package optional;

import optional.airport.Airport;

public class AirportRunner {
    final static int RUNWAY_QUANTITY = 5;
    final static int PLANE_QUANTITY = 10;

    public static void main(String[] args) {
        Airport airport = new Airport(RUNWAY_QUANTITY, PLANE_QUANTITY);
        Thread thread = new Thread(airport);
        thread.start();
    }
}
