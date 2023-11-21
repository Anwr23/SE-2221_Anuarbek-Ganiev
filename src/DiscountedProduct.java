// Decorator
public class DiscountedProduct extends ProductDecorator{
    public DiscountedProduct(IProduct decoratedProduct){
        super(decoratedProduct);
    }
    @Override
    public void displayInfo() {
        decoratedProduct.displayInfo();
        System.out.println("10% off a dish:)");
    }
}
