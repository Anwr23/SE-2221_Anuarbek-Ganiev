import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Singleton
        PaymentCart paymentCart = PaymentCart.getInstance();

        //Factory Method - creating products
        IProductFactory foodFactory = new FoodFactory();
        IProduct food = foodFactory.createProduct();

        //Observer - subscribing to event
        //Creating users
        EventPublisher eventPublisher = new EventPublisher();
        IFoodstoreObserver admin1 = new User("Sanzhar");
        IFoodstoreObserver admin2 = new User("Anuarbek");

        //Adding users to the event notifier
        eventPublisher.addObserver(admin1);
        eventPublisher.addObserver(admin2);
        eventPublisher.notifyObserver(" 10% for all books.");

        //Command - adding and removing
        ICommand food1 = new AddItemCommand(paymentCart, "Manti ");
        ICommand food2 = new AddItemCommand(paymentCart, "Samsa ");


        //Adding books to the cart
        food1.execute();
        food2.execute();
        //Displaying updated cart content
        paymentCart.displayItem();

        //Removing food from the cart
        food2.undo();
        //Displaying cart content
        paymentCart.displayItem();

        //Decorator - adding features to the products
        IProduct discountedFood = new DiscountedProduct(food);
        discountedFood.displayInfo();

        //Strategy - choosing payment metho
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
    }
}