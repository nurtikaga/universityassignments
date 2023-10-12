package adapter_design_pattern;

// Define an interface 'WebDriver' with two methods, 'getElement' and 'selectElement'.
interface WebDriver 
{
    public void getElement();
    public void selectElement();
}

// Create a class 'ChromeDriver' that implements the 'WebDriver' interface.
class ChromeDriver implements WebDriver 
{
    @Override
    public void getElement() 
    {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement() 
    {
        System.out.println("Select element from ChromeDriver");
    }
}

// Create a separate class 'IEDriver' with methods for finding and clicking elements.
class IEDriver
{
    public void findElement() 
    {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement()
    {
        System.out.println("Click element from IEDriver");
    }
}

// Define a class 'WebDriverAdapter' that implements the 'WebDriver' interface
// and wraps an 'IEDriver' instance, adapting its methods to the WebDriver interface.
class WebDriverAdapter implements WebDriver 
{
    IEDriver ieDriver;

    // Constructor that initializes the adapter with an 'IEDriver'.
    public WebDriverAdapter(IEDriver ieDriver) 
    {
        this.ieDriver = ieDriver;
    }
  
    @Override
    public void getElement() 
    {
        // Adapt the 'getElement' method to call 'findElement' from 'IEDriver'.
        ieDriver.findElement();
    }

    @Override
    public void selectElement() 
    {
        // Adapt the 'selectElement' method to call 'clickElement' from 'IEDriver'.
        ieDriver.clickElement();
    }
}

// Create a public class 'AdapterPattern' for demonstrating the Adapter Design Pattern.
public class AdapterPattern
{
    public static void main(String[] args) 
    {
        // Create an instance of 'ChromeDriver' and use it to demonstrate its methods.
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();
        
        // Create an instance of 'IEDriver' and use it to demonstrate its methods.
        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();
        
        // Create a 'WebDriverAdapter' and adapt 'IEDriver' to the 'WebDriver' interface.
        // Then, use it to demonstrate the adapted methods.
        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement();
        wID.selectElement();
    }
}
