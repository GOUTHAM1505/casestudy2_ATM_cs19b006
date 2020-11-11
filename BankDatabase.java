
public class BankDatabase {
	private Account accounts[];
	
	public BankDatabase() {
		accounts=new Account[5];
		accounts[0]=new Account[11111,1111,20000,10000];
		accounts[1]=new Account[22222,2222,30000,15000];
		accounts[2]=new Account[33333,3333,40000,20000];
		accounts[3]=new Account[44444,4444,50000,25000];
		accounts[4]=new Account[55555,5555,60000,30000];
	}
	
	private Account getAcount(int accountNumber) {
		for(Account currentAccount:accounts) {
			if(currentAccount.getAccountNumber().equals(accountNumber))
				return currentAccount;
		}
		return null;
	}
	
	public boolean authenticateUser( int userAccountNumber, int userPIN )
	 {
	
	 Account userAccount = getAccount( userAccountNumber );
	
	 
	 if ( userAccount != null )
		 return userAccount.validatePIN( userPIN );
	 else
		 return false; 
	 } 	
	 
	 public int getAvailableBalance( int userAccountNumber )
	 {
	 return getAccount( userAccountNumber ).getAvailableBalance();
	 }
	 
	 public int getTotalBalance( int userAccountNumber )
	  {
	  return getAccount( userAccountNumber ).getTotalBalance();
	  } 
	 
	 
	  public void credit( int userAccountNumber, double amount )
	  {
	  getAccount( userAccountNumber ).credit( amount );
	  } 
	 
	 
	  public void debit( int userAccountNumber, double amount )
	  {
	  getAccount( userAccountNumber ).debit( amount );
	  } 
	 
	 
}
