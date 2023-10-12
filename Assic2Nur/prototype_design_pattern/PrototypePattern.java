package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Define a class 'Vehicle' that implements the 'Cloneable' interface.
class Vehicle implements Cloneable 
{
  private List<String> vehicleList;
  
  public Vehicle() 
  {
    this.vehicleList = new ArrayList<String>();
  }
  
  public Vehicle(List<String> list) 
  {
    this.vehicleList = list;
  }
  
  public void insertData()
  {
    // Insert vehicle names into the list.
    vehicleList.add("Honda Amaze");
    vehicleList.add("Audi A4");
    vehicleList add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }
  
  public List<String> getVehicleList() 
  {
    return this.vehicleList;
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException 
  {
    List<String> tempList = new ArrayList<String>();
    
    // Clone the vehicle list into a new list.
    for(String s : this.getVehicleList()) 
    {
      tempList.add(s);
    }
    
    return new Vehicle(tempList);
  }
}

// Create the main class 'PrototypePattern' for demonstrating the Prototype Design Pattern.
public class PrototypePattern
{
  public static void main(String[] args) throws CloneNotSupportedException 
  {
    Vehicle a = new Vehicle();
    a.insertData();
    
    // Clone the 'a' object to create 'b'.
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    list.add("Honda New Amaze");
    
    System.out.println(a.getVehicleList());
    System.out.println(list);
    
    // Modify the list in 'b'.
    b.getVehicleList().remove("Audi A4");
    System.out.println(list);
    
    // Show that the original list in 'a' is not affected by changes in 'b'.
    System.out.println(a.getVehicleList());
  }
}
