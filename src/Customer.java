import java.util.Scanner;

public class Customer extends User{
    private double balance;
    private Cart cart = new Cart();

    public Customer(String username,String password,double balance){
        super(username,password,"Customer");
        this.balance=balance;
    }

    public double getBalance(){return this.balance;}
    public Cart getCart(){return this.cart;};

    public void addFunds(double amount){
        this.balance+=amount;
    }
    public void deductFunds(double amount){
        if(amount>this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        } else {
            this.balance-=amount;
        }
    }

    @Override
    public void showMenu(Scanner scanner){
        System.out.println("Customer menu");
    };
}
