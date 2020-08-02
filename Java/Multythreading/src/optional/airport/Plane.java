package optional.airport;

import java.util.ArrayList;
import java.util.List;

public class Plane implements Runnable {
    private final static int WAITING_TIME = 3000;
    private Runway runway;
    private String name;

    Plane(Runway runway, String name) {
        this.runway = runway;
        this.name = name;
    }

    public static List<Plane> createPlanes(Runway runway, int quantity) {
        List<Plane> planes = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Plane plane = new Plane(runway, "Plane " + i);
            planes.add(plane);
        }
        return planes;
    }

    private void enteringTheRunway() {
        System.out.printf("The %s began entering the runway.\n", name);
        try {
            Thread.sleep(WAITING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeOff() {
        System.out.printf("The %s took off.\n", name);
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            enteringTheRunway();
            takeOff();
            runway.work();
            runway.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
