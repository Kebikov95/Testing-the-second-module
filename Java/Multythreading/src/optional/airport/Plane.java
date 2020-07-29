package optional.airport;

public class Plane implements Runnable {
    private Airport airport;
    private final int quantity = 10;
    private static int counter = 0;

    public Plane(Airport airport) {
        this.airport = airport;
    }

    private void enteringTheRunway() {
        System.out.printf("The plane #%d began entering the runway.\n", counter);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeOff() {
        System.out.printf("The plane #%d took off.\n", counter);
    }

    private void increment() {
        counter++;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            airport.get();
            increment();
            enteringTheRunway();
            takeOff();
        }
    }
}
