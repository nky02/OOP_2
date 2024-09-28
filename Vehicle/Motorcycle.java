public class Motorcycle extends Vehicle {

    int engineCapacity; // The engine size in cubic centimeters (cc)
    String tireType; // Type of tires (e.g., slick, knobby, touring)

    public Motorcycle(String brand, int speed, int fuel, String color, String tireType, int engineCapacity) {
        super(brand, speed, fuel, color);
        this.engineCapacity = engineCapacity;
        this.tireType = tireType;
    }

    // first method
    public void checkEnginePower() {
        if (engineCapacity <= 300) {
            System.out.println(brand + " has a small-displacement engine.");
        } else if (engineCapacity <= 600) {
            System.out.println(brand + " has a medium-displacement engine.");
        } else {
            System.out.println(brand + " has a large-displacement engine.");
        }
    }

    // second method
    public void replaceTires(String newTireType) {
        this.tireType = newTireType;
        System.out.println("Tires replaced with " + newTireType + " tires.");
    }

    // third method with overriding
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
        System.out.println("Tire Type: " + tireType);
        
    }
}
