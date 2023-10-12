package decorator_design_pattern;

// Define an interface 'Dress' for dressing features.
interface Dress
{
	 public void assemble();
}

// Create a concrete class 'BasicDress' that implements the 'Dress' interface.
class BasicDress implements Dress 
{
	 @Override
	 public void assemble()
	 {
	    System.out.println("Basic Dress Features");
	 }
}

// Create an abstract class 'DressDecorator' that implements the 'Dress' interface and contains a reference to another 'Dress' object.
class DressDecorator implements Dress
{
	 protected Dress dress;
	 public DressDecorator(Dress c)
	 {
	    this.dress = c;
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    this.dress.assemble();
	  }
}

// Create concrete decorator classes, 'CasualDress', 'SportyDress', and 'FancyDress', which extend 'DressDecorator'.
class CasualDress extends DressDecorator 
{
	 public CasualDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Casual Dress Features");
	 }
}

class SportyDress extends DressDecorator 
{
	 public SportyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Sporty Dress Features");
	 }
}

class FancyDress extends DressDecorator
{
	 public FancyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble()
	 {
	    super.assemble();
	    System.out.println("Adding Fancy Dress Features");
	 }
}

// Create the main class 'DecoratorPattern' for demonstrating the Decorator Design Pattern.
public class DecoratorPattern
{
	  public static void main(String[] args) 
	  {
	      // Create instances of dress decorators and decorate the basic dress.
	      Dress sportyDress = new SportyDress(new BasicDress());
	      sportyDress.assemble();
	      System.out.println();
	     
	      Dress fancyDress = new FancyDress(new BasicDress());
	      fancyDress.assemble();
	      System.out.println();
	    
	      Dress casualDress = new CasualDress(new BasicDress());
	      casualDress.assemble();
	      System.out.println();
	    
	      // Create complex combinations of dress decorators.
	      Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
	      sportyFancyDress.assemble();
	      System.out.println();
	    
	      Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
	      casualFancyDress.assemble();
	  }
}
