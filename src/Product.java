public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String anme,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public int getQuantity(){return this.quantity;}

    public void reduceQuantity(int amount){
        if(amount>this.quantity){
            throw new IllegalArgumentException("Insufficient quantity");
        } else quantity-=amount;
    }
}
