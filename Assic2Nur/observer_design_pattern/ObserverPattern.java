package observer_design_pattern;

// Define an interface 'Subject' for objects that can be observed.
interface Subject 
{
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// Create a concrete class 'DeliveryData' that implements the 'Subject' interface.
class DeliveryData implements Subject
{
    private List<Observer> observers;
    private String location;

    public DeliveryData() 
    {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) 
    {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) 
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {
      for(Observer obj : observers) 
      {
          obj.update(location);
      }
    }

    public void locationChanged()
    {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() 
    {
      return "YPlace";
    }
}

// Define an interface 'Observer' for objects that observe the subject.
interface Observer
{
    public void update(String location);
}

// Create concrete observer classes, 'Seller', 'User', and 'DeliveryWarehouseCenter', which implement the 'Observer' interface.
class Seller implements Observer 
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

class User implements Observer 
{
    private String location;

    @Override
    public void update(String location) 
    {
        this.location = location;
        showLocation();
    }

    public void showLocation() 
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

class DeliveryWarehouseCenter implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

// Create the main class 'ObserverPattern' for demonstrating the Observer Design Pattern.
public class ObserverPattern
{
    public static void main(String[] args)
    {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Register observers with the subject.
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Notify observers about a location change.
        topic.locationChanged();
        
        // Unregister an observer from the subject.
        topic.unregister(obj3);

        System.out.println();

        // Notify remaining observers about another location change.
        topic.locationChanged();
    }
}
