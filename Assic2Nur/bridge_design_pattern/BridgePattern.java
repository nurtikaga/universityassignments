package bridge_design_pattern;

// Define an abstract class 'TV' representing a television.
abstract class TV 
{
    Remote remote;  // Reference to a remote control.
    
    // Constructor to initialize the TV with a specific remote.
    TV(Remote r) 
    {
        this.remote = r;
    }
    
    // Abstract methods for turning the TV on and off.
    abstract void on();
    abstract void off();
}

// Create a concrete TV class 'Sony' that extends 'TV'.
class Sony extends TV
{
    Remote remoteType;  // Reference to the remote control type.
    
    // Constructor to initialize the Sony TV with a specific remote.
    Sony(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }
  
    // Implement the 'on' method for Sony TV.
    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }
    
    // Implement the 'off' method for Sony TV.
    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}
    
// Create another concrete TV class 'Philips' that extends 'TV'.
class Philips extends TV 
{
    Remote remoteType;  // Reference to the remote control type.
    
    // Constructor to initialize the Philips TV with a specific remote.
    Philips(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }
  
    // Implement the 'on' method for Philips TV.
    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }
    
    // Implement the 'off' method for Philips TV.
    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Create an interface 'Remote' for defining remote control methods.
interface Remote
{
    public void on();
    public void off();
}

// Create a concrete implementation of the 'Remote' interface, 'OldRemote'.
class OldRemote implements Remote 
{
    @Override
    public void on()  
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with Old Remote");
    }
}

// Create another concrete implementation of the 'Remote' interface, 'NewRemote'.
class NewRemote implements Remote 
{
    @Override
    public void on() 
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with New Remote");
    }
}

// Create the main class 'BridgePattern' for demonstrating the Bridge Design Pattern.
public class BridgePattern 
{
    public static void main(String[] args) 
    {
        // Create Sony TV with the old remote and demonstrate its functionality.
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();
    
        // Create Sony TV with the new remote and demonstrate its functionality.
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();
    
        // Create Philips TV with the old remote and demonstrate its functionality.
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();
    
        // Create Philips TV with the new remote and demonstrate its functionality.
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();  
    }
}
