package optional.airport;

import java.util.concurrent.Semaphore;

public class Runway {
    private Semaphore semaphore;

    public Runway(int quantity) {
        semaphore = new Semaphore(quantity);
    }

    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    public void release() {
        semaphore.release();
    }

    public int availablePermits() {
        return semaphore.availablePermits();
    }

    private void acceptThePlane() {
        System.out.printf("The runway has accepted the plane.\n");
    }

    private void getFree() {
        System.out.printf("The runway is free.\n");
    }

    public void work() {
        acceptThePlane();
        getFree();
    }
}
