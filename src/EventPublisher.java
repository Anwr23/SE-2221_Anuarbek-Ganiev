import java.util.ArrayList;
import java.util.List;

//Observer
public class EventPublisher {
    private List<IFoodstoreObserver> observers = new ArrayList<>();

    public void addObserver(IFoodstoreObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IFoodstoreObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserver(String event) {
        for (IFoodstoreObserver observer : observers) {
            observer.update(event);
        }
    }
}
