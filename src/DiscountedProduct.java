//Decorator
public class DiscountedProduct extends ProductDecorator{
    public DiscountedProduct(IProduct decoratedProduct){
        super(decoratedProduct);
    }
    @Override
    public void displayInfo() {
        decoratedProduct.displayInfo();
        System.out.println("Now we do not have discounts:(");
    }
}
