public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public int getQuantity(){return this.quantity;}

    public void reduceQuantity(int amount){
        if(amount>this.quantity){
            System.out.println("Insufficient quantity");
            return;
        } else quantity-=amount;
    }
}
