package main;

public class Car implements Runnable {
    private String name;
    private Parking parking;

    public Car(String name, Parking parking) {
        this.name = name;
        this.parking = parking;
    }

    private void arrived() {
        System.out.println(name + " arrived at the parking lot.");
    }

    private void stay() {
        long waitingTime = this.await();
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s stay in the parking %d s. +\n", name, waitingTime);
    }

    private void left() {
        System.out.println(name + " left the parking lot.");
    }

    private void leftAfterWaiting() {
        long waitingTime = this.await();
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s wait on the parking and left %d s. -\n", name, waitingTime);
    }

    private void waiting() {
        long waitingTime = this.await();
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s wait...\n", name);
    }

    private long await() {
        long waitingTime = (long) (Math.random() * 3000);
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return waitingTime;
    }

    public void work() {
        parking.acquire();
        this.arrived();
        this.stay();
        this.left();
        parking.release();
    }

    @Override
    public void run() {
        if(parking.availablePermits() > 0) {
            this.work();
        } else {
            this.waiting();
            if(parking.availablePermits() > 0) {
                this.work();
            } else {
                this.leftAfterWaiting();
            }
        }
    }
}
