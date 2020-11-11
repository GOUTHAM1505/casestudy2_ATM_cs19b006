
public class Account {
	private int accountNumber;
	private int pin;
	private int availableBalance;
	private int totalBalance;
	
	public Account(int  theAccountNumber,int thepin,int theTotalBlance,int theAvailableBalnce) {
		accountNumber=theAccountNumber
				pin=thepin;
				availableBalance=theAvailableBalance;
				totalBalance=theTotalBalance;
	}
	
	public boolean validatePin()(int userPin){
		if(userPin==pin) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getAvailableBalance() {
		return availableBalance;
	}
	
	public int getTotalBalance() {
		return totalBalance;
	}
	
	public void credit(int amount) {
		totalBalance+=amount;
	}
	
	public void debit(int amount) {
		availableBalance-=amount;
		totalBalance-=amount;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
}
