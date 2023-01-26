package transport;

public class Truck<T> extends Transport {

    private T driver;

    private Carring carring;

    private enum Carring {

        N1(0.0f, 3.50f),
        N2(3.51f, 12f),
        N3(12.1f, (Float)null);

        private float downLoadCarring;
        private float upLoadCarring;

        Carring(float downLoadCarring) {
            this.downLoadCarring = downLoadCarring;
        }

        Carring(float downLoadCarring, float upLoadCarring) {
            this.downLoadCarring = downLoadCarring;
            this.upLoadCarring = upLoadCarring;
        }

        public float getDownLoadCarring() {
            return downLoadCarring;
        }

        public void setDownLoadCarring(float downLoadCarring) {
            this.downLoadCarring = downLoadCarring;
        }

        public float getUpLoadCarring() {
            return upLoadCarring;
        }

        public void setUpLoadCarring(float upLoadCarring) {
            this.upLoadCarring = upLoadCarring;
        }



        @Override
        public String toString() {
            if (getUpLoadCarring() == (Float)null) {
                return "Грузоподъемность: от " + getDownLoadCarring() + " тонн";
            } else {
                return "Грузоподъемность: от " + getDownLoadCarring() + " тонн до " + getUpLoadCarring() + " тонн";
            }
        }
    }

    public Truck(String brand,
                 String model,
                 double engineVolume, T driver, String type) {
        super(brand, model, engineVolume, type);
        this.driver = driver;
    }

    public T getDriver() {
        return driver;
    }


    public Carring getCarring() {
        return carring;
    }

    @Override
    public void startMove() {
        System.out.println("Грузовик марки " + getBrand() + " начал движение");
    }

    @Override
    public void finishMove() {
        System.out.println("Грузовик марки " + getBrand() + " закончил движение");
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у грузовика");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 90;
        int maxBound = 140;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Лучшее время круга для грузовика в минутах: " + theBestTimeInMins);
    }

    @Override
    public void maxSpeed() {
        int minBound = 90;
        int maxBound = 130;
        int maxSpeed = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Максимальная скорость для грузовика: " + maxSpeed);
    }

}

