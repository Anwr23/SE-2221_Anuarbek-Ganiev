//Decorator
abstract class ProductDecorator implements IProduct {
    protected IProduct decoratedProduct;

    public ProductDecorator(IProduct decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    public abstract void displayInfo();
}
