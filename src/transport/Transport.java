package transport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Transport<T extends Driver> implements Competing {

    private final String brand;
    private final String model;
    private double engineVolume;

    private Driver driver;

    private List<Mechanic> mechanics;

    public Transport(String brand,
                     String model,
                     double engineVolume, Driver driver, List<Mechanic> mechanics) {
        if (brand == null || brand.isEmpty()) {
            brand = "default";
        }
        this.brand = brand;
        if (model == null || model.isEmpty()) {
            model = "default";
        }
        this.model = model;
        setEngineVolume(engineVolume);
        this.driver = driver;
        this.mechanics = mechanics;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public abstract Type getType();

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            engineVolume = 1.6;
        }
        this.engineVolume = engineVolume;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public boolean checkTransportNeedSTO() {
        try {
            diagnostics();
        } catch (TransportTypeException e) {
            return false;
        }
        return true;
    }

    public abstract void startMove();

    public abstract void finishMove();

    public abstract void diagnostics() throws TransportTypeException;

    public void printType() {
        System.out.println("Тип кузова данного транспортного средства: " + getType());
    }

    @Override
    public String toString() {
        return "Марка: " + brand + ", " +
                "модель: " + model + ", " +
                "объем двигателя: " + engineVolume;
    }

    public Driver getDriver() {
        return driver;
    }
}