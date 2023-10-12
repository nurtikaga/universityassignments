package factory_design_pattern;

// Define an abstract class 'Vehicle' to represent common features of vehicles.
abstract class Vehicle 
{
	 public abstract int getWheel(); // Abstract method to get the number of wheels.
	 public String toString() 
	 {
	    return "Wheel: " + this.getWheel(); // Return a string representation of the vehicle.
	 }
}

// Create a concrete class 'Car' that extends 'Vehicle'.
class Car extends Vehicle 
{
     int wheel;
	 Car(int wheel)
	 {
	    this.wheel = wheel;
	 }

	 @Override
	 public int getWheel() 
	 {
	    return this.wheel; // Implement the 'getWheel' method for the car.
	 }
}

// Create another concrete class 'Bike' that extends 'Vehicle'.
class Bike extends Vehicle 
{
	 int wheel;
	 Bike(int wheel) 
	 {
	    this.wheel = wheel;
	 }
	  
	 @Override
	 public int getWheel()
	 {
	    return this.wheel; // Implement the 'getWheel' method for the bike.
	 }
}

// Create a 'VehicleFactory' class to produce instances of 'Vehicle' based on the type and the number of wheels.
class VehicleFactory
{
	 public static Vehicle getInstance(String type, int wheel)
	 {
	    if(type.equals("car")) // Use 'equals' method to compare strings.
	    {
	       return new Car(wheel); // Create and return a car instance.
	    } 
	    else if(type.equals("bike"))
	    {
	       return new Bike(wheel); // Create and return a bike instance.
	    }
	    return null; // Return null if an invalid type is provided.
	 }
}

// Create the main class 'FactoryPattern' for demonstrating the Factory Design Pattern.
public class FactoryPattern
{
     public static void main(String[] args) 
	 {
	    // Use the 'VehicleFactory' to create car and bike instances with the specified number of wheels.
	    Vehicle car = VehicleFactory.getInstance("car", 4);
	    System.out.println(car); // Display the car's wheel count.
	    
	    Vehicle bike = VehicleFactory.getInstance("bike", 2);
	    System.out.println(bike); // Display the bike's wheel count.
	 }
}
