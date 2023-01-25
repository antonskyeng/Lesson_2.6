package transport;

public class DriverB extends Driver {

    public DriverB(String name,
                   boolean hasDriverLicense,
                   int experienceInYears) {
        super(name, hasDriverLicense, experienceInYears);
    }

    @Override
    public void startMove() {
        System.out.println("Водитель категории B " + getName() + " начал движение");
    }

    @Override
    public void finishMove() {
        System.out.println("Водитель категории B " + getName() + " закончил движение");
    }

    @Override
    public void refill() {
        System.out.println("Водитель категории B " + getName() + " заправляет авто");
    }

}
