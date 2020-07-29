package optional.airport;

public class Runway implements Runnable {
    private Airport airport;
    private final int quantity = 5;
    private static int counter = 0;

    public Runway(Airport airport) {
        this.airport = airport;
    }

    private void acceptThePlane() {
        System.out.printf("The runway #%d has accepted the plane.\n", counter);
    }

    private void getFree() {
        System.out.printf("The runway #%d is free.\n", counter);
    }

    private void increment() {
        counter++;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            airport.put();
            increment();
            acceptThePlane();
            getFree();
        }
    }
}
