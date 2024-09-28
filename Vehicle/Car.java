
public class Car extends Vehicle {

    // S1: declare attributes
    int numOfSeats;
    boolean isAutomatic;

    public Car(String brand, int speed, int fuel, String color, int numOfSeats, boolean isAutomatic) {
        // S2: instantiate
        super(brand, speed, fuel, color);
        this.numOfSeats = numOfSeats;
        this.isAutomatic = isAutomatic;
    }

    // S3: define methods
    // first method
    public void displayNumOfSeats() {
        System.out.println(brand + " has " + numOfSeats + " seats");
    }

    // second method
    public void isAutonomous() {
        System.out.println(brand + " is a self-driving car.");
    }

    // third method with overriding
    @Override
    public void displayDetails() {
        // Call the superclass's displayDetails() method
        super.displayDetails();
        System.out.println("Number of Seats: " + numOfSeats);
        System.out.println("Is it Automatic?: " + (isAutomatic ? "Yes" : "No"));
    }
}
