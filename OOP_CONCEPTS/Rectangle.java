// encapsualtion goes:
// 1. Declaration
// 2. Intialization: constructor of the class e.g. shape (int x, int y)
// -this.x = x, this.y = y;
// 3. Setters&Getters: private set(), get()
// 4. Test class/main method

public class Rectangle {
    // Attributes
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getters
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Methods to implement
    public void setDimensions(double width, double height) {
        if (width <= 0 ){

            throw new IllegalArgumentException ("Measurements must be in positive values");
        }

    }

    public double calculateArea() {
        double area = width * height;
        return area;
    }

    public double calculatePerimeter() {
        double perimeter = 2 * (width + height);
        return perimeter;
    }

    public static void main(String[] args) {

        try{
        Rectangle rectangle = new Rectangle(12, 15);

        System.out.printf("Area: %.2f\n", rectangle.calculateArea());
        System.out.printf("Perimeter: %.2f\n", rectangle.calculatePerimeter());}

        catch (IllegalArgumentException e){
            System.out.println("Error");
        }

    }

}
