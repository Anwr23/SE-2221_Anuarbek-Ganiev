// Strategy Pattern
public class KaspiGold implements IPaymentStrategy{
    @Override
    public void paymentProcess(double amount) {
        System.out.println("Payment processed with Kaspi Gold, amount including cashback"+amount+"tenge");
    }
}
