import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new TV("TV",2000,20,2));
        products.add(new Cheese("Cheese",100,20,0.5, LocalDate.of(2025,9,20)));
        products.add(new Biscuits("Biscuits",20,30,LocalDate.of(2026,10,30)));
        products.add(new MobileScratchCard("MobileScratchCard",10,100));
        //we can use a map for quick search in the future
        HashMap<String, User> users = new HashMap<>();
        String choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Fawry Ecommerce");
        do {
            System.out.println("You are: (pick a number)");
            System.out.println("1. New customer");
            System.out.println("2. Customer");
            System.out.println("0. Exit");
            choice = scan.nextLine();
            String name, password;
            switch (choice) {
                case "1" -> {
                    double funds;
                    System.out.print("Enter your name:");
                    name = scan.nextLine();
                    System.out.print("Enter a password:");
                    password = scan.nextLine();
                    System.out.println("Enter the funds you want to add:");
                    funds = scan.nextDouble();
                    scan.nextLine();
                    users.put(name,new Customer(name,password,funds));
                    System.out.println("Your account has been created, you can now log in and shop!");
                }
                case "2" -> {
                    System.out.print("Enter your name:");
                    name = scan.nextLine();
                    System.out.print("Enter a password:");
                    password = scan.nextLine();
                    User cust = users.get(name);
                    if(cust!=null) {
                        if (cust.getRole().equals("Customer")) {
                            Customer customer = (Customer) cust;
                            if (customer != null && customer.getPassword().equals(password)) {
                                System.out.println("Welcome to our store");
                                customer.showMenu(scan, products);
                            }
                        }
                    } else System.out.println("This account does not exist");
                }

                case "0" -> System.out.println("Thank you for visiting, bye");
            }
        } while (!choice.equals("0"));
    }
}