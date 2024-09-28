public class Vehicle {
    public String brand, color; // instance variables
    public int speed, fuel;

    public Vehicle(String brand, int speed, int fuel, String color) { // constructor
        this.brand = brand;
        this.speed = speed;
        this.fuel = fuel;
        this.color = color;
    }

    public void move() {
        System.out.println("The " + brand + " is moving at " + speed + " km/h");
    }

    public void stop() { // Renamed from speed() to stop()
        System.out.println("The " + brand + " has stopped");
    }

    public void refuel(int amount) {
        fuel += amount;
        System.out.println("Refueled " + amount + " liters\n" + "Current fuel level: " + fuel + " liters");
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel: " + fuel + " liters");
    }

    public static void main(String[] args) {
        // Car instance
        Car car = new Car("Tesla", 150, 50, "Red", 5, true);
        System.out.println("\n=== Car Information ===");
        car.move();
        car.displayNumOfSeats();
        car.isAutonomous();
        car.displayDetails();
        System.out.println();

        // Motorcycle instance
        Motorcycle motorcycle = new Motorcycle("Ducati Scrambler Nightshift", 100, 15, "Black", "Sport", 803);
        System.out.println("=== Motorcycle Information ===");
        motorcycle.move();
        motorcycle.checkEnginePower();
        motorcycle.replaceTires("Off-road");
        motorcycle.displayDetails();
        System.out.println();

        // Helicopter instance
        Helicopter helicopter = new Helicopter("AgustaWestland AW139", 270, 1000, "White", 5, 6000);
        System.out.println("=== Helicopter Information ===");
        helicopter.move();
        helicopter.checkBlades();
        System.out.println("Max Altitude: " + helicopter.getMaxAltitude() + " meters");
        helicopter.displayDetails();
    }
}
