package singleton_design_pattern;

// SingletonEager class: Eager Initialization Singleton Pattern
class SingletonEager 
{
  private static SingletonEager instance = new SingletonEager(); 
  
  private SingletonEager()
  {
    // Private constructor to prevent external instantiation.
  }
  
  public static SingletonEager getInstance()
  {
    return instance;
  }
}

// Singleton class: Lazy Initialization Singleton Pattern
class Singleton 
{
  private static Singleton instance; 
  
  private Singleton()
  {
    // Private constructor to prevent external instantiation.
  }
  
  public static Singleton getInstance() 
  {
    if(instance == null) 
    {
      instance = new Singleton();
    }
    return instance;
  }
}

// SingletonSynchronizedMethod class: Lazy Initialization Singleton Pattern with Synchronized Method
class SingletonSynchronizedMethod
{
  private static SingletonSynchronizedMethod instance; 
  
  private SingletonSynchronizedMethod()
  {
    // Private constructor to prevent external instantiation.
  }
  
  public static synchronized SingletonSynchronizedMethod getInstance() 
  {
    if(instance == null) 
    {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// SingletonSynchronized class: Double-Checked Locking Singleton Pattern
class SingletonSynchronized 
{
  private static SingletonSynchronized instance; 
  
  private SingletonSynchronized()
  {
    // Private constructor to prevent external instantiation.
  }
  
  public static SingletonSynchronized getInstance() 
  {
    if(instance == null) 
    {
      synchronized (SingletonSynchronized.class) 
      {
        if(instance == null) 
        {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

// Main class 'SingletonPattern' for demonstrating different Singleton Design Pattern variations.
public class SingletonPattern 
{
  public static void main(String[] args) 
  {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance(); 
    System.out.println(instance1);
  }
}
