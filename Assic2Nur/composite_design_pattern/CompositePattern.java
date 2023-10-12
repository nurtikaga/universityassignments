package composite_design_pattern;

// Define an abstract class 'Account' representing a bank account.
abstract class Account 
{
  public abstract float getBalance();
}

// Create a concrete class 'DepositeAccount' that extends 'Account'.
class DepositeAccount extends Account
{
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance) 
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;
  }
}

// Create another concrete class 'SavingAccount' that extends 'Account'.
class SavingAccount extends Account 
{
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) 
  {
    super();
    this.accountNo = accountNo;
    this accountBalance = accountBalance;
  }

  public float getBalance() 
  {
    return accountBalance;
  }
}

// Create a composite class 'CompositeAccount' that extends 'Account'.
class CompositeAccount extends Account
{
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() 
  {
    totalBalance = 0;
    for (Account acc : accountList)
    {
      totalBalance = totalBalance + acc.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) 
  {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) 
  {
    accountList.remove(acc);
  }
}

// Create the main class 'CompositePattern' for demonstrating the Composite Design Pattern.
public class CompositePattern
{
  public static void main(String[] args) 
  {
    // Create a 'CompositeAccount' instance to represent a composite account.
    CompositeAccount compositeAccount = new CompositeAccount();

    // Add individual accounts (DepositeAccount and SavingAccount) to the composite account.
    compositeAccount.addAccount(new DepositeAccount("DA001", 100));
    compositeAccount.addAccount(new DepositeAccount("DA002", 150));
    compositeAccount.addAccount(new SavingAccount("SA001", 200));

    // Calculate and display the total balance of the composite account.
    float totalBalance = compositeAccount.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}
