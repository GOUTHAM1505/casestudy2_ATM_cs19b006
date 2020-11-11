
public class Withdrawl extends Transaction{
	private int amount; 
	
	 private CashDispenser cashDispenser; 
	
	
	 private final static int CANCELED = 6;
	
	 
	 public Withdrawal( int userAccountNumber BankDatabase atmBankDatabase,  CashDispenser atmCashDispenser )
	 {
	 
	 super( userAccountNumber, atmBankDatabase );
	
	 
	 cashDispenser = atmCashDispenser;
	 } 
	 public void execute()
	 {
	 boolean cashDispensed = false; 
	 double availableBalance; 
	 Scanner s=new Scanner;
	 BankDatabase bankDatabase=getBankDatabase(); 

	 do
	 {
	
	 amount = displayMenuOfAmounts();
	
	 if ( amount != CANCELED )
	 {
	
	 availableBalance =bankDatabase.getAvailableBalance( getAccountNumber() );
	
	 
	 if ( amount <= availableBalance )
	 {
	
	 if ( cashDispenser.isSufficientCashAvailable( amount ) )
	 {
	
	 bankDatabase.debit( getAccountNumber(), amount );
	
	 cashDispenser.dispenseCash( amount ); // dispense cash
	 cashDispensed = true; // cash was dispensed
	
	 System.out.println("");
	 System.out.println( "Your cash has been" +" dispensed. Please take your cash now." );
	 } 
	 else 
		 System.out.println( "Insufficient cash available in the. ATM."  );
	 	 System.out.println("Please choose a smaller amount.");
	 } 
	 else 
	 {
		 System.out.println("Insufficient funds in your account." ); 
		 System.out.println( "Please choose a smaller amount." );
	 } 
	 } 
	 else 
	 {
		 System.out.println( "\nCanceling transaction..." );
	 return; 
	 } 
	 } while ( !cashDispensed );
	
	 }
	 private int displayMenuOfAmounts()
	  {
	  int userChoice = 0; 
	  int amounts[] = { 0, 500, 1000, 1500, 2000, 2500 };
	  
	   
	   while ( userChoice == 0 )
	   {
	   // display the menu
		   System.out.println( "Withdrawal Menu:" );
		   System.out.println( "1 - $20" );
		   System.out.println( "2 - $40" );
		   System.out.println( "3 - $60" );
		   System.out.println( "4 - $100" );
		   System.out.println( "5 - $200" );
		   System.out.println( "6 - Cancel transaction" );
		   System.out.println( "Choose a withdrawal amount: " );
	  
	   int input = s.nextInt();
	  
	   switch ( input )
	   {
	   case 1: 
	   case 2: 
	   case 3: 
	   case 4:
	   case 5:
	   userChoice = amounts[ input ]; 
	   break; 
	   case CANCELED: 
	   userChoice = CANCELED; 
	   break;
	   default: 
		   System.out.println("Invalid selection. Try again." );
	   } 
	   } 
	  
	   return userChoice; 
	   } 
	 
	 
}
