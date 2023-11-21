//Observer
public class Admin implements IFoodstoreObserver {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name+": Notification about "+event);
    }
}

