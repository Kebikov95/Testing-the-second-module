package optional.airport;

import java.util.List;

public class Airport implements Runnable {
    final private int runwayQuantity;
    final private int planeQuantity;
    private Runway runway;
    private List<Plane> planes;

    public Airport(int runwayQuantity, int planeQuantity) {
        this.runwayQuantity = runwayQuantity;
        this.planeQuantity = planeQuantity;
        this.runway = new Runway(runwayQuantity);
        this.planes = Plane.createPlanes(runway, planeQuantity);
    }

    @Override
    public void run() {
        for (int i = 0; i < planes.size(); i++) {
            new Thread(planes.get(i)).start();
        }
    }
}
