
public class BalanceEnquiry extends Transaction {
	public BalanceEnquiry( int userAccountNumber, BankDatabase atmBankDatabase )
			 {
			 super( userAccountNumber, atmBankDatabase );
			 } 
			 public void execute()
			 {
			
			 BankDatabase bankDatabase=getBankDatabase();
			
			 int availableBalance =
			 bankDatabase.getAvailableBalance( getAccountNumber() );
			
			
			 int totalBalance =
			 bankDatabase.getTotalBalance( getAccountNumber() );
			
			 System.out.println( "Balance Information:" );
			 System.out.print( " - Available balance: " ); 
			 System.out.println( availableBalance );
			 System.out.print( " - Total balance: " );
			 System.out.println( totalBalance );
			 System.out.println( "" );
}
}
