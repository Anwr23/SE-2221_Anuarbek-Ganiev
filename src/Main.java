import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Singleton
        PaymentCart paymentCart = PaymentCart.getInstance();

        // Fabric method
        IProductFactory foodFactory = new FoodFactory();
        IProduct foodProduct = foodFactory.createProduct();

        // Decorator
        IProduct discountedFood = new DiscountedProduct(foodProduct);
        discountedFood.displayInfo();

        // Strategy
        IPaymentStrategy kaspiGold = new KaspiGold();
        IPaymentStrategy kaspiRed = new KaspiRed();

        System.out.println("Choose payment (KaspiGold or KaspiRed): ");
        String payment = scanner.nextLine();

        IPaymentStrategy paymentMethod;

        if (("KaspiGold").equalsIgnoreCase(payment)) {
            paymentMethod=kaspiGold;
        } else if (("KaspiRed").equalsIgnoreCase(payment))
            paymentMethod=kaspiRed;
        else {
            System.out.println("Invalid payment method.");
            return;
        }
        paymentMethod.paymentProcess(10);

        // Command
        PaymentCart cart = PaymentCart.getInstance();
        cart.addItem("Dish1");
        cart.addItem("Dish2");
        cart.displayItem();
        cart.removeItem("Dish1");
        cart.displayItem();

        // Observer
        Admin admin1 = new Admin("Sanzhar");
        Admin admin2 = new Admin("Anuarbek");

        EventPublisher eventPublisher = new EventPublisher();
        eventPublisher.addObserver(admin1);
        eventPublisher.addObserver(admin2);

        eventPublisher.notifyObserver("new order");
    }
}
