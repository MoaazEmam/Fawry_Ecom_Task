import java.util.HashMap;

public class CheckoutService {
    public static void checkout(Customer customer){
        Cart cart=customer.getCart();

        if(cart.getItems().isEmpty()){
            System.out.println("Error: Cart is empty");
            return;
        }

        double total= cart.getTotal();
        HashMap<Shippable,Integer> shippable=new HashMap<Shippable,Integer>();
        for (CartItem item: cart.getItems().values()){
            Product prod=item.getProduct();
            if(item.getQuantity()> prod.getQuantity()){
                System.out.println("Insufficient stock");
                return;
            }
            if(prod instanceof Expirable){
                if(((Expirable) prod).isExpired()){
                    System.out.println("Error: "+prod.getName()+" is expired");
                    return;
                }
            }
            if(prod instanceof Shippable) {
                Shippable s = (Shippable) prod;
                shippable.put(s, prod.getQuantity());
            }
        }
        if(total>customer.getBalance()){
            System.out.println("Insufficient funds");
            return;
        }
        customer.deductFunds(total);
        for (CartItem item: cart.getItems().values()){
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        if(!shippable.isEmpty()){
            ShippingService.ship(shippable);
        }
        System.out.println("** Checkout receipt **");
        for (CartItem item: cart.getItems().values()){
            System.out.printf("%dx %s\t%.1fg\n",item.getQuantity(),item.getProduct().getName(),item.getTotal());
        }
        System.out.println("--------------------");
        System.out.printf("Subtotal\t%.2f\n",total);
        System.out.printf("Shipping\t%.2f\n",30);
        System.out.printf("Amount\t%.2f\n",total+30);

        cart.clear();
    }
}
