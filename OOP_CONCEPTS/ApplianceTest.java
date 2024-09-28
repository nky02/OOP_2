abstract class Appliance {
    abstract void turnOn();

    abstract void turnOff();
}

// WashingMachine class
class WashingMachine extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Washing Machine Turning on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Washing Machine Turning off...");
    }
}

// Refrigerator class
class Refrigerator extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Refrigerator Turning on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Refrigerator Turning off...");
    }
}

// Test class
public class ApplianceTest {
    public static void main(String[] args) {
        try {
            // Create instances of WashingMachine and Refrigerator
            Appliance washingMachine = new WashingMachine();
            Appliance refrigerator = new Refrigerator();

            // Call turnOn and turnOff methods
            refrigerator.turnOn();
            refrigerator.turnOff();
            washingMachine.turnOn();
            washingMachine.turnOff();

        } catch (Exception e) {
            // Handle any unexpected exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}