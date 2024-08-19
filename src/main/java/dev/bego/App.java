package dev.bego;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
 
  SavingsAccount savingsAccount = new SavingsAccount(15000, 0.035f);

  
  
  savingsAccount.deposit(2000);  
  savingsAccount.withdraw(5000); 
  savingsAccount.withdraw(2000); 
  savingsAccount.withdraw(1000); 
  savingsAccount.withdraw(1000); 
  savingsAccount.withdraw(1000); 
  savingsAccount.monthlyProcess(); 

  
  System.out.println("Savings Account:");
  savingsAccount.print();

  
  CheckingAccount checkingAccount = new CheckingAccount(5000, 0.04f);

  
  checkingAccount.withdraw(6000); 
  checkingAccount.deposit(3000);  
  checkingAccount.monthlyProcess(); 

 
  System.out.println("\nChecking Account:");
  checkingAccount.print();
}
}
