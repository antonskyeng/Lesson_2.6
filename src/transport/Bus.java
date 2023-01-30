package transport;

import java.util.List;

public class Bus<DriverD> extends Transport {

    private Capacity capacity;

    private enum Capacity {
        EXTRA_SMALL(0, 10),
        SMALL(11, 25),
        MIDDLE(40, 50),
        LARGE(60, 80),
        EXTRA_LARGE(100, 120);

        private int downCapacity;
        private int upCapacity;

        Capacity(int downCapacity, int upCapacity) {
            this.downCapacity = downCapacity;
            this.upCapacity = upCapacity;
        }

        public int getDownCapacity() {
            return downCapacity;
        }

        public void setDownCapacity(int downCapacity) {
            this.downCapacity = downCapacity;
        }

        public int getUpCapacity() {
            return upCapacity;
        }

        public void setUpCapacity(int upCapacity) {
            this.upCapacity = upCapacity;
        }

        @Override
        public String toString() {
            return "Вместимость: " + getDownCapacity() + " - " + getUpCapacity() + " мест";
        }
    }

    public Bus(String brand,
               String model,
               double engineVolume, Driver driver, List<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, mechanics);
    }

    public Capacity getCapacity() {
        return capacity;
    }

    @Override
    public Type getType() {
        return Type.BUS;
    }

    @Override
    public void startMove() {
        System.out.println("Автобус марки " + getBrand() + " начал движение");
    }

    @Override
    public void finishMove() {
        System.out.println("Автобус марки " + getBrand() + " закончил движение");
    }

    @Override
    public void diagnostics() throws TransportTypeException {
        throw new TransportTypeException("«Автобусы» диагностику проходить не должны");
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у автобуса");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 100;
        int maxBound = 150;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Лучшее время круга для автобуса в минутах: " + theBestTimeInMins);
    }

    @Override
    public void maxSpeed() {
        int minBound = 80;
        int maxBound = 120;
        int maxSpeed = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Максимальная скорость для автобуса: " + maxSpeed);
    }

}