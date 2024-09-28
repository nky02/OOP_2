1port java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double f, c;

        System.out.print("Enter temperature in fahrenheit: ");
        f = scan.nextDouble();

        c = ((f - 32) * 5 / 9);

        if (f <= 32) {
            System.out.printf("%.2f degrees fahrenheit is %.2f degree celsius.\n", f, c);
            System.out.println("Temperature is below freezing point.");
        } else if (f >= 212) {
            System.out.printf("%.2f degrees fahrenheit is %.2f degree celsius.\n", f, c);
            System.out.println("Temperature is above boiling point.");
        } else {
            System.out.printf("%.2f degrees fahrenheit is %.2f degree celsius.\n", f, c);
            System.out.println("Temperature is in between freezing and boiling point.");
        }

    }
}
