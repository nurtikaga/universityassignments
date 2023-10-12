package facade_design_pattern;

// Create two separate classes for Firefox and Chrome, simulating web browsers.
class Firefox
{
  public static Driver getFirefoxDriver() 
  {
      return null; // Return a mock Firefox driver.
  }
  
  public static void generateHTMLReport(String test, Driver driver) 
  {
      System.out.println("Generating HTML Report for Firefox Driver");
  }
  
  public static void generateJUnitReport(String test, Driver driver) 
  {
      System.out.println("Generating JUNIT Report for Firefox Driver");
  }
}

class Chrome 
{
  public static Driver getChromeDriver() 
  {
    return null; // Return a mock Chrome driver.
  }
  
  public static void generateHTMLReport(String test, Driver driver) 
  {
      System.out.println("Generating HTML Report for Chrome Driver");
  }
  
  public static void generateJUnitReport(String test, Driver driver)
  {
      System.out.println("Generating JUNIT Report for Chrome Driver");
  }
}

// Create a facade class 'WebExplorerHelperFacade' to simplify the interaction with web browsers and report generation.
class WebExplorerHelperFacade 
{
  public static void generateReports(String explorer, String report, String test)
  {
      Driver driver = null;
      switch(explorer)
      {
          case "firefox":
          driver = Firefox.getFirefoxDriver(); // Get a Firefox driver.
          switch(report) 
          {
              case "html":
              Firefox.generateHTMLReport(test, driver); // Generate an HTML report for Firefox.
              break;
              case "junit":
              Firefox.generateJUnitReport(test, driver); // Generate a JUnit report for Firefox.
              break;
          }
          break;
          case "chrome":
          driver = Chrome.getChromeDriver(); // Get a Chrome driver.
          switch(report) 
          {
              case "html":
              Chrome.generateHTMLReport(test, driver); // Generate an HTML report for Chrome.
              break;
              case "junit":
              Chrome.generateJUnitReport(test, driver); // Generate a JUnit report for Chrome.
              break;
          }
      }
  }
}

// Create the main class 'FacadePattern' for demonstrating the Facade Design Pattern.
public class FacadePattern
{
  public static void main(String[] args)
  {
    String test = "CheckElementPresent";
    
    // Use the 'WebExplorerHelperFacade' to generate different reports for Firefox and Chrome.
    WebExplorerHelperFacade.generateReports("firefox", "html", test);
    WebExplorerHelperFacade.generateReports("firefox", "junit", test);
    WebExplorerHelperFacade.generateReports("chrome", "html", test);
    WebExplorerHelperFacade.generateReports("chrome", "junit", test);
  }
}
