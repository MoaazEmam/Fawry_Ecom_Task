import java.time.LocalDate;

public class Cheese extends Product implements Shippable, Expirable {
    private double weight;
    private LocalDate expiryDate;

    public Cheese(String name,double price,int quantity,double weight,LocalDate expiryDate){
        super(name,price,quantity);
        this.weight=weight;
        this.expiryDate=expiryDate;
    }

    @Override
    public double getWeight(){return this.weight;}
    @Override
    public LocalDate getExpiryDate(){return this.expiryDate;}
    @Override
    public boolean isExpired(){return this.expiryDate.isBefore(LocalDate.now());}
}
