import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    private double balance;
    private Cart cart = new Cart();

    public Customer(String username, String password) {
        super(username, password, "Customer");
    }

    public Customer(String username, String password, double balance) {
        super(username, password, "Customer");
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public Cart getCart() {
        return this.cart;
    }

    ;

    public void addFunds(double amount) {
        this.balance += amount;
    }

    public void deductFunds(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public void showMenu(Scanner scanner, List<Product> products) {
        String choice;
        do {
            int i = 1;
            System.out.printf("\tAvailable funds:\t%.2f", this.balance);
            System.out.println("\n--- Customer Menu ---");
            System.out.print("\tAvailable Products\t\n");
            System.out.println("1. TV");
            System.out.println("2. Cheese");
            System.out.println("3. Biscuits");
            System.out.println("4. Mobile Scratch Card");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextLine();
            int amount = 0;
            Product product = null;
            switch (choice) {
                case "1" -> {
                    for (Product p : products) {
                        if (p.getName().equals("TV")) {
                            System.out.println("Price is: $" + p.getPrice() + " and the quantity available: " + p.getQuantity());
                            System.out.println("How many do you want to add to your cart?");
                            amount = scanner.nextInt();
                            scanner.nextLine();
                            product = p;
                        }
                    }
                    if (product != null) {
                        this.cart.addProduct(product, amount);
                        product.reduceQuantity(amount);
                    }
                }
                case "2" -> {

                    for (Product p : products) {
                        if (p.getName().equals("Cheese")) {
                            System.out.println("Price is: $" + p.getPrice() + " and the quantity available: " + p.getQuantity());
                            System.out.println("How many do you want to add to your cart?");
                            amount = scanner.nextInt();
                            scanner.nextLine();
                            product = p;
                        }
                    }
                    if (product != null) {
                        this.cart.addProduct(product, amount);
                        product.reduceQuantity(amount);
                    }
                }
                case "3" -> {
                    for (Product p : products) {
                        if (p.getName().equals("Biscuits")) {
                            System.out.println("Price is: $"+ p.getPrice()+" and the quantity available: "+p.getQuantity());
                            System.out.println("How many do you want to add to your cart?");
                            amount = scanner.nextInt();
                            scanner.nextLine();
                            product = p;
                        }
                    }
                    if (product != null) {
                        this.cart.addProduct(product, amount);
                        product.reduceQuantity(amount);
                    }
                }
                case "4" -> {
                    for (Product p : products) {
                        if (p.getName().equals("MobileScratchCard")) {
                            System.out.println("Price is: $"+ p.getPrice()+" and the quantity available: "+p.getQuantity());
                            System.out.println("How many do you want to add to your cart?");
                            amount = scanner.nextInt();
                            scanner.nextLine();
                            product = p;
                        }
                    }
                    if (product != null) {
                        this.cart.addProduct(product, amount);
                        product.reduceQuantity(amount);
                    }
                }
            }
            System.out.println("Ready to checkout? (Y for yes, N for no)");
            choice = scanner.nextLine();
            if (choice.equals("Y")) {
                choice = "0";
                CheckoutService.checkout(this);
            }
            ;
        } while (!choice.equals("0"));
    }

    ;
}
