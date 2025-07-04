import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(HashMap<Shippable,Integer> items){
        double totalWeight=0;
        System.out.println("** Shipment notice **");
        for (Map.Entry<Shippable,Integer> item:items.entrySet()){
            double totalItemWeight=(item.getValue()*item.getKey().getWeight());
            System.out.printf("%dx %s\t%.1fg\n",item.getValue(),item.getKey().getName(),totalItemWeight);
            totalWeight+=totalItemWeight;
        }
        System.out.println("Total package weight "+totalWeight);
    }
}
