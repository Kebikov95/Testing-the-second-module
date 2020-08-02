package optional.airport;

import java.util.concurrent.Semaphore;

public class Runway {
    private Semaphore semaphore;

    public Runway(int quantity) {
        if(quantity <= 0) {
            try {
                throw new Exception("The number of permissions allowed" +
                        " to the resource must be greater than zero.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
