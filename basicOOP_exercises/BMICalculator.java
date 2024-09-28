import java.util.Scanner;

class BMICalculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(
                "\t\tThis program calculates your BMI and determines its \n\t\t corresponding classification of weight status.\n");

        double weight = getWeight(scan);
        double height = getHeight(scan);

        double bmi = calcBMI(weight, height);
        String classification = classifyBMI(bmi);

        System.out.printf("\nYour Body Mass Index is %.2f.\n", bmi);
        System.out.println("BMI Classification: " + classification);

    }

    static double getWeight(Scanner scan) {

        double weight;

        do {

            System.out.print("Enter weight in kilograms(kg): ");
            weight = scan.nextDouble();
            if (weight <= 0)
                System.out.println("Invalid weight input. Please enter a positive number.");

        } while (weight <= 0);
        return weight;

    }

    static double getHeight(Scanner scan) {

        double height;

        do {

            System.out.print("Enter height in meters(m): ");
            height = scan.nextDouble();
            if (height <= 0)
                System.out.println("Invalid height input. Please enter a positive number.");

        } while (height <= 0);
        return height;

    }

    static double calcBMI(double weight, double height) {
        return weight / (height * height);
    }

    static String classifyBMI(double bmi) {

        if (bmi < 18.5)
            return "Underweight";

        else if (bmi >= 18.5 && bmi < 24.9)
            return "Normal weight";

        else if (bmi >= 25 && bmi < 29.9)
            return "Overweight";

        else
            return "Obese";
    }
}
