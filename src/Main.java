import transport.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Mechanic mechanic3 = new Mechanic("Oleg", "Smirnov", "XRace");
        Mechanic mechanic1 = new Mechanic("Ivan", "Ivanov", "Drive");
        Mechanic mechanic2 = new Mechanic("Petr", "Petrov", "XDrive");

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
                    driverB, List.of(mechanic1, mechanic2));

            DriverC driverC = new DriverC(
                    "Driver cat. C №" + i,
                    true,
                    7 + i
            );

            Truck truck = new Truck(
                    "Truck brand №" + i,
                    "Truck model №" + i,
                    4.5,
                    driverC, List.of(mechanic1, mechanic3));
            DriverD driverD = new DriverD(
                    "Driver cat. D №" + i,
                    true,
                    10 + i
            );
            Bus bus = new Bus(
                    "Bus brand №" + i,
                    "Bus model №" + i,
                    4.0,
                    driverD, List.of(mechanic3));

            List<Transport> racers = new ArrayList<>();

            racers.add(car);
            racers.add(bus);
            racers.add(truck);

            Queue<Transport> transportsOnSTO = new LinkedList<>();

            STO sto = new STO(transportsOnSTO);


            printInfo(car);
            printInfo(bus);
            printInfo(truck);

            car.printType();
            bus.printType();
            truck.printType();

            car.diagnostics();
            truck.diagnostics();

            try {
                bus.diagnostics();
            } catch (TransportTypeException e) {
                System.out.println(e.getMessage());
            }

            for (Transport transport : racers) {
                System.out.println(transport + " " + transport.getDriver() + " " + transport.getMechanics());
            }

            for (Transport transport: racers) {
                sto.addCarYoQueue(transport);
            }


            for (int j = 0; j <= transportsOnSTO.size(); j++) {
                sto.carryOutAVehicleInspection(transportsOnSTO);
            }

            Map<Transport, List<Mechanic>> transportAndMechanics = new HashMap<>();

            transportAndMechanics.put(car, car.getMechanics());
            transportAndMechanics.put(bus, bus.getMechanics());
            transportAndMechanics.put(truck, truck.getMechanics());

            for (Map.Entry<Transport, List<Mechanic>> map: transportAndMechanics.entrySet()) {
                System.out.println(map);
            }

        }
    }

    private static void printInfo(Transport<? extends Driver> transport) {
        System.out.println("Водитель " + transport.getDriver().getName() + " управляет автомобилем " + transport.getBrand() + " и будет участвовать в заезде");
    }



}