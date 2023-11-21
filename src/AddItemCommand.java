// Command
public class AddItemCommand implements ICommand{
    private PaymentCart paymentCart;
    private String item;

    public AddItemCommand(PaymentCart paymentCart, String item) {
        this.paymentCart = paymentCart;
        this.item = item;
    }

    @Override
    public void execute() {
        paymentCart.addItem(item);
    }

    @Override
    public void undo() {
        paymentCart.removeItem(item);
    }
}
