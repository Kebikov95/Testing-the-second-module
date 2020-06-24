public class Car {
    private String name;
    private String model;
    private double engine;
    private String registrationNumbers;

    public Car(String name, String model, double engine, String registrationNumbers) {
        this.name = name;
        this.model = model;
        this.engine = engine;
        this.registrationNumbers = registrationNumbers;
    }

    public void upgradeModel() {
        replaceEngine(engine + 0.2);
    }

    private void replaceEngine(double engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", registrationNumbers='" + registrationNumbers + '\'' +
                '}';
    }
}
