package optional;

import optional.airport.Airport;
import optional.airport.Plane;
import optional.airport.Runway;

public class AirportRunner {
    public static void main(String[] args) {
        Airport airport = new Airport();
        Runway runway = new Runway(airport);
        Plane plane = new Plane(airport);
        new Thread(runway).start();
        new Thread(plane).start();
    }
}
