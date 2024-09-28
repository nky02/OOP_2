public class Shape {
    // Method to print that this is a shape
    public void printShape() {
        System.out.println("This is a shape");
    }

    // Method to calculate area (to be overridden by subclasses)
    public double area() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    // Override method to calculate circle area
    @Override
    public double area() {
        return Math.PI * radius * radius;  // Area of a circle = π * r²
    }
}

class Square extends Shape {
    private double side;

    // Constructor
    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive.");
        }
        this.side = side;
    }

    // Override method to calculate square area
    @Override
    public double area() {
        return side * side;  // Area of a square = side²
    }

    public static void main(String[] args) {
        try {
            // Test Circle
            Circle circle = new Circle(5.0);
            System.out.println("Circle area: " + circle.area());

            // Test Square
            Square square = new Square(4.0);
            System.out.println("Square area: " + square.area());

            // Uncomment to test invalid dimensions
            // Circle invalidCircle = new Circle(-3.0); // This will throw an exception
            // Square invalidSquare = new Square(0);     // This will throw an exception

        } catch (IllegalArgumentException e) {
            // Handle the exception and print the error message
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
