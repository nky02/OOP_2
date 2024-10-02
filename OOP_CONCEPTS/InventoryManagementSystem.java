import java.util.ArrayList;
import java.util.List;

class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void updateStock(int amount) throws InvalidQuantityException, InsufficientStockException {
        throw new UnsupportedOperationException("updateStock() not implemented");
    }
}

class PerishableProduct extends Product {
    private String expirationDate;

    public PerishableProduct(String productId, String productName, int quantity, double price, String expirationDate) {
        super(productId, productName, quantity, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void updateStock(int amount) throws InvalidQuantityException, InsufficientStockException {
        if (amount < 0) {
            if (getQuantity() + amount < 0) { // Use getQuantity() here
                throw new InsufficientStockException("Insufficient stock for product " + getProductName());
            }
            throw new InvalidQuantityException("Quantity cannot be negative");
        }
        if (getQuantity() + amount > 100) {
            throw new InvalidQuantityException("Cannot exceed maximum quantity of 100 for perishable products.");
        }
        setQuantity(getQuantity() + amount);
    }
}

class NonPerishableProduct extends Product {
    private int shelfLife;

    public NonPerishableProduct(String productId, String productName, int quantity, double price, int shelfLife) {
        super(productId, productName, quantity, price);
        this.shelfLife = shelfLife;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    @Override
    public void updateStock(int amount) throws InvalidQuantityException, InsufficientStockException {
        if (amount < 0) {
            if (getQuantity() + amount < 0) {
                throw new InsufficientStockException("Insufficient stock for product " + getProductName());
            }
            throw new InvalidQuantityException("Quantity cannot be negative");
        }
        setQuantity(getQuantity() + amount);
    }
}

abstract class InventoryOperation {
    public abstract void addProduct(Product product);

    public abstract void removeProduct(String productId) throws InsufficientStockException;
}

class Inventory extends InventoryOperation {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getProductName() + " with quantity " + product.getQuantity());
    }

    @Override
    public void removeProduct(String productId) throws InsufficientStockException {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product " + productId + " removed successfully.");
        } else {
            throw new InsufficientStockException("Product not found.");
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        PerishableProduct apple = new PerishableProduct("P001", "Apple", 50, 0.5, "2024-12-31");
        inventory.addProduct(apple);

        NonPerishableProduct rice = new NonPerishableProduct("NP001", "Rice", 200, 1.0, 365);
        inventory.addProduct(rice);

        try {
            apple.updateStock(30);
            System.out.println("Stock updated: Apple new quantity is " + apple.getQuantity());
        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        try {
            apple.updateStock(30);
        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        try {
            inventory.removeProduct("P001");
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        try {
            apple.updateStock(-60);
        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        try {
            apple.updateStock(-10);
        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
