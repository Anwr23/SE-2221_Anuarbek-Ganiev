//Observer
public class User implements IFoodstoreObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name+": Notification about "+event);
    }
}

