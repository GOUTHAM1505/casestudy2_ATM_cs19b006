
public abstract class Transaction {
	private int accountNumber; 
	 private BankDatabase bankDatabase; 
	
	 // Transaction constructor invoked by subclasses using super()
	 public Transaction( int userAccountNumber,BankDatabase atmBankDatabase )
	 {
	 accountNumber = userAccountNumber;
	 bankDatabase = atmBankDatabase;
	 } 
	 public int getAccountNumber()
	 {
	 return accountNumber; 
	 } 
	 public Screen getScreen()
	 {
	 return screen;
	 }
	 public BankDatabase getBankDatabase()
	 {
	 return bankDatabase;
	 } 
	 abstract public void execute();
}
