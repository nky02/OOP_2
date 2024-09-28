// Base class
public class Payment {
    public void processPayment() {
        System.out.println("Processing payment...");
    }
}

// CreditCardPayment class
class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;

    // Constructor
    public CreditCardPayment(String cardNumber, String cardHolderName, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment() {
        // Implement credit card payment logic
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("CVV: " + cvv);
        System.out.println("Credit Card transaction complete...");
    }
}

// PayPalPayment class
class PayPalPayment extends Payment {
    private String email;

    // Constructor
    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment() {
        // Implement PayPal payment logic
        System.out.println("Email: " + email);
        System.out.println("PayPal Payment transaction complete...");
    }

    public static void main(String[] args) {
        try {
            // Creating an instance of CreditCardPayment
            CreditCardPayment creditCardPayment = new CreditCardPayment("52312512", "Juan dela Cruz", "12/25", "052");
            creditCardPayment.processPayment();

            // Creating an instance of PayPalPayment
            PayPalPayment payPalPayment = new PayPalPayment("juandelacruz@gmail.com");
            payPalPayment.processPayment();

        } catch (Exception e) {
            // Handle any unexpected exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
