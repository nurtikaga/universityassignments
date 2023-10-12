package builder_design_pattern;

// Define a class 'Vehicle' to represent a vehicle with attributes like engine, wheels, and airbags.
class Vehicle 
{
  private String engine;
  private int wheel;
  private int airbags;
  
  public String getEngine() 
  {
    return this.engine;
  }
  
  public int getWheel() 
  {
    return this.wheel;
  }
  
  public int getAirbags()
  {
    return this.airbags;
  }
  
  // Define a private constructor that takes a 'VehicleBuilder' to create a 'Vehicle' object.
  private Vehicle(VehicleBuilder builder)
  {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }
  
  // Create a static nested class 'VehicleBuilder' to build 'Vehicle' objects.
  public static class VehicleBuilder
  {
    private String engine;
    private int wheel;
    private int airbags;
    
    // Constructor to set the required attributes, engine, and wheel.
    public VehicleBuilder(String engine, int wheel)
    {
      this.engine = engine;
      this.wheel = wheel;
    }
    
    // Method to set optional attribute 'airbags' and return the builder instance.
    public VehicleBuilder setAirbags(int airbags) 
    {
      this.airbags = airbags;
      return this;
    }
    
    // Build and return a 'Vehicle' object with the provided attributes.
    public Vehicle build() 
    {
      return new Vehicle(this);
    }
  }
}

// Create the main class 'BuilderPattern' for demonstrating the Builder Design Pattern.
public class BuilderPattern
{
  public static void main(String[] args) 
  {
    // Use the 'VehicleBuilder' to construct a car with specified attributes.
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    
    // Use the 'VehicleBuilder' to construct a bike with specified attributes.
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();
    
    // Display the attributes of the car.
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());
    
    // Display the attributes of the bike.
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
