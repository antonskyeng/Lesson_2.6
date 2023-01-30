package transport;

import java.util.List;

public class Car<DriverB> extends Transport {

    private BodyType bodyType;

    private enum BodyType {
        TYPE1("Седан"),
        TYPE2("Хетчбек"),
        TYPE3("Купе"),
        TYPE4("Универсал"),
        TYPE5("Внедорожник"),
        TYPE6("Кроссовер"),
        TYPE7("Пикап"),
        TYPE8("Фургон"),
        TYPE9("Минивэн");

        private String name;

        BodyType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Тип кузова " + name;
        }
    }

    public Car(String brand,
               String model,
               double engineVolume, Driver driver, List<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, mechanics);
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public Type getType() {
        return Type.CAR;
    }

    @Override
    public void startMove() {
        System.out.println("Автомобиль марки " + getBrand() + " начал движение");
    }

    @Override
    public void finishMove() {
        System.out.println("Автомобиль марки " + getBrand() + " закончил движение");
    }

    @Override
    public void diagnostics() {
        System.out.println("Автомобиль марки " + getBrand() + " прошел диагностику");
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у автомобиля");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 70;
        int maxBound = 120;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Лучшее время круга для автомобиля в минутах: " + theBestTimeInMins);
    }

    @Override
    public void maxSpeed() {
        int minBound = 100;
        int maxBound = 160;
        int maxSpeed = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Максимальная скорость для автомобиля: " + maxSpeed);
    }

}