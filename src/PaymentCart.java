import java.util.ArrayList;
import java.util.List;

//Singleton
public class PaymentCart {
    private static PaymentCart instance;
    private List<String> items;

    private PaymentCart() {
        this.items=new ArrayList<>();
    }

    public static PaymentCart getInstance(){
        if (instance==null) {
            instance=new PaymentCart();
        }
        return instance;
    }

    public void addItem(String item) {
        items.add(item);
        System.out.println(item +" added to the shopping cart");
    }

    public void removeItem(String item) {
        items.remove(item);
        System.out.println(item +" removed from the shopping cart");
    }

    public void displayItem() {
        System.out.println("Shopping cart items: ");
        for (String item : items) {
            System.out.println("- "+item);
        }
    }
}
