public class Helicopter extends Vehicle {

    int numberOfBlades;
    int maxAltitude;

    public Helicopter(String brand, int speed, int fuel, String color, int numberOfBlades, int maxAltitude) {
        super(brand, speed, fuel, color);
        this.numberOfBlades = numberOfBlades;
        this.maxAltitude = maxAltitude;
    }

    // first methof
    public void checkBlades() {
        System.out.println("Helicopter " + brand + " has " + numberOfBlades + " blades.");
    }

    // second method
    public int getMaxAltitude() {
        return maxAltitude;
    }

    // third method w/ overriding
    @Override
    public void displayDetails() {
        // Call the superclass's displayDetails() method
        super.displayDetails();
        System.out.println("Number of Blades: " + numberOfBlades);
        System.out.println("Max Altitude: " + maxAltitude + " meters\n\n");
    }
}
