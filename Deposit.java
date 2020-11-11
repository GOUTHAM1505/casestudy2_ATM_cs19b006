
public class Deposit extends Transaction {
	private int  amount; 
	 
	 private DepositSlot depositSlot; 
	 private final static int CANCELED = 0; 
	
	
	 public Deposit( int userAccountNumber,BankDatabase atmBankDatabase, DepositSlot atmDepositSlot )
	 {
	 
	 super( userAccountNumber,  atmBankDatabase );
	
	
	 depositSlot = atmDepositSlot;
	 } 
	
	 
	 public void execute()
	 {
	 BankDatabase bankDatabase=getBankDatabase(); // get reference
	 Scanner s=new Scanner;
	 amount = promptForDepositAmount(); 
	 if ( amount != CANCELED )
	 {
	 
		 System.out.println("Please insert a deposit envelope containing " );
		 System.out.println( amount );
		 System.out.println( "." );
	
	 
	 boolean envelopeReceived = depositSlot.isEnvelopeReceived();
	
	
	 if ( envelopeReceived )
	 {
		 System.out.println( "Your envelope has been " +"received.  NOTE: The money just deposited will not " + "be available until we verify the amount of any " +"enclosed cash and your checks clear." );
	
	 else 
	 {
		 System.out.println( "\nYou did not insert an " +"envelope, so the ATM has canceled your transaction." );
	 } 
	 } 
	 else 
	 {
		 System.out.println( "Canceling transaction..." );
 } 
	 } 
	
	 
	 private int promptForDepositAmount()
	 {
	
		 System.out.println( "\nPlease enter a deposit amount in " + "ruppes()multiples of 500 (or 0 to cancel): " );
	 int input = s.nextInt(); 
	
	 
	 if ( input == CANCELED )
	 return CANCELED;
	 else
	 {
	 return ( int ) input / 100; 
	 } 
	 } 
}
