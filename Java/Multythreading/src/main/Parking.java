package main;

import java.util.concurrent.Semaphore;

class Parking {
    private Semaphore semaphore;

    public Parking(int quantity) {
        this.semaphore = new Semaphore(quantity);
    }

    public void acquire() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        semaphore.release();
    }

    public int availablePermits() {
        return semaphore.availablePermits();
    }
}