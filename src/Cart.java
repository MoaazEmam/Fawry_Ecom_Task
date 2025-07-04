import java.util.HashMap;

public class Cart {
    private HashMap<String,CartItem> items=new HashMap<>();
    
    public void addProduct(Product product,int quantity){
        String prodName=product.getName();
        //check if it exists
        CartItem existing=this.items.get(prodName);
        //if item exists incerment its quant
        if(existing!=null){
            int newQuant= existing.getQuantity()+quantity;
            if(newQuant>product.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock");
            } else {
                existing.setQuantity(newQuant);
            }
        } else {
            this.items.put(prodName,new CartItem(product,quantity));
        }
    }
    public void removeProduct(String productName){
        if(this.items.remove(productName)!=null){
            System.out.println("Removed "+productName+" from cart");
        } else {
            System.out.println("Product not found in cart");
        }
    }
    public HashMap<String,CartItem> getItems(){return this.items;};
    public double getTotal(){
        return this.items.values().stream().mapToDouble(CartItem::getTotal).sum();
    }
    public void clear(){this.items.clear();}
}
