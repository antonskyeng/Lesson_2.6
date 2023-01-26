import transport.*;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            DriverB driverB = new DriverB(
                    "Driver cat. B №" + i,
                    true,
                    5 + i
            );
            Car car = new Car(
                    "Car brand №" + i,
                    "Car model №" + i,
                    1.6,
                    driverB
            );
            DriverC driverC = new DriverC(
                    "Driver cat. C №" + i,
                    true,
                    7 + i
            );
            Truck truck = new Truck(
                    "Truck brand №" + i,
                    "Truck model №" + i,
                    4.5,
                    driverC
            );
            DriverD driverD = new DriverD(
                    "Driver cat. D №" + i,
                    true,
                    10 + i
            );
            Bus bus = new Bus(
                    "Bus brand №" + i,
                    "Bus model №" + i,
                    4.0,
                    driverD
            );
            printInfo(car);
            printInfo(bus);
            printInfo(truck);
        }
    }

    private static void printInfo(Transport<? extends Driver> transport) {
        System.out.println("Водитель " + transport.getDriver().getName() + " управляет автомобилем " + transport.getBrand() + " и будет участвовать в заезде");
    }

}