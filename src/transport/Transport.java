package transport;

public abstract class Transport<T> implements Competing {

    private final String brand;
    private final String model;
    private double engineVolume;

    private final Type type;


    public Transport(String brand,
                     String model,
                     double engineVolume, String type) {
        this.type = Type.valueOf(type);
        if (brand == null || brand.isEmpty()) {
            brand = "default";
        }
        this.brand = brand;
        if (model == null || model.isEmpty()) {
            model = "default";
        }
        this.model = model;
        setEngineVolume(engineVolume);
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

    public Type getType() {
        return type;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            engineVolume = 1.6;
        }
        this.engineVolume = engineVolume;
    }

    public abstract void startMove();

    public abstract void finishMove();

    public void printType() {
        if (getType() == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println("Тип кузова данного транспортного средства: " + getType());
        }
    }

    @Override
    public String toString() {
        return "Марка: " + brand + ", " +
                "модель: " + model + ", " +
                "объем двигателя: " + engineVolume;
    }

    public abstract T getDriver();
}
