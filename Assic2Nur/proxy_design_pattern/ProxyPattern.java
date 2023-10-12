package proxy_design_pattern;

// Define an interface 'DatabaseExecuter' for executing database queries.
interface DatabaseExecuter 
{
    public void executeDatabase(String query) throws Exception;
}

// Create a concrete class 'DatabaseExecuterImpl' that implements the 'DatabaseExecuter' interface.
class DatabaseExecuterImpl implements DatabaseExecuter
{
    @Override
    public void executeDatabase(String query) throws Exception
    {
        System.out.println("Going to execute Query: " + query);
    }
}

// Create a proxy class 'DatabaseExecuterProxy' that also implements the 'DatabaseExecuter' interface.
class DatabaseExecuterProxy implements DatabaseExecuter
{
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;
  
    // Constructor for the proxy class, where authentication is checked.
    public DatabaseExecuterProxy(String name, String passwd)
    {
        if (name.equals("Admin") && passwd.equals("Admin@123")) 
        {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception
    {
        if (ifAdmin) 
        {
            // If the user is an admin, allow executing any query.
            dbExecuter.executeDatabase(query);
        } 
        else 
        {
            if (query.equals("DELETE")) 
            {
                // Non-admin users are not allowed to execute DELETE queries.
                throw new Exception("DELETE not allowed for non-admin user");
            }
            else 
            {
                // For other queries, execute them.
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

// Create the main class 'ProxyPattern' for demonstrating the Proxy Design Pattern.
public class ProxyPattern
{
    public static void main(String[] args) throws Exception
    {
        // Create instances of the proxy class with different user credentials.
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE");  // Incorrect query

        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE");  // Non-admin user trying to DELETE

        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE");  // Admin executing DELETE
    }
}
