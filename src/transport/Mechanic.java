package transport;

public class Mechanic {

    private String firstName;
    private String lastName;
    private String company;

    public Mechanic(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public void maintenance() {
        System.out.println(getFirstName() + " " + getLastName() + " из компании "
                + getCompany() + " проводит техобслуживание");
    }

    public void fixing() {
        System.out.println(getFirstName() + " " + getLastName() + " из компании "
                + getCompany() + " чинит автомобиль");
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
