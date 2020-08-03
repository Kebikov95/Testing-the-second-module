package main;

import java.util.ArrayList;
import java.util.List;

public class ParkingRunner {
    final static int PARKING_PLACES_QUANTITY = 5;
    final static int CARS_QUANTITY = 10;

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Parking parking = new Parking(PARKING_PLACES_QUANTITY);

        for (int i = 0; i < CARS_QUANTITY; i++) {
            Car car = new Car("Car " + i, parking);
            new Thread(car).start();
        }
    }
}