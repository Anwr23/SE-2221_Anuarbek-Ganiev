public class KaspiRed implements IPaymentStrategy{
    @Override
    public void paymentProcess(double amount) {
        System.out.println("Payment processed with Kaspi Red, amount including cashback "+amount+"%");
    }
}
