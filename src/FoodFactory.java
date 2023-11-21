//Factory
public class FoodFactory implements IProductFactory{
    @Override
    public IProduct createProduct() {
        return new Food();
    }
}
