package optional.airport;

public class Airport {
    private int quantityPlane = 10;

    public synchronized void get() {
        while (quantityPlane < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        quantityPlane--;
        notify();
    }

    public synchronized void put() {
        while (quantityPlane >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        quantityPlane++;
        notify();
    }
}
