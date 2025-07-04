import java.time.LocalDate;

public class Biscuits extends Product implements Expirable {
    private LocalDate expiryDate;

    public Biscuits(String name,double price,int quantity,LocalDate expiryDate){
        super(name,price,quantity);
        this.expiryDate=expiryDate;
    }

    @Override
    public LocalDate getExpiryDate(){return this.expiryDate;}
    public boolean isExpired(){ return expiryDate.isBefore(LocalDate.now());}
}
