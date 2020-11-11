
public class CashDispenser {
	private final static int INITIAL_COUNT=500;
	private int count;
	
	public cashDispenser(){
		count=INITIAL_COUNT;
	}
	
	public void dispenseCash(int amount) {
		int billsRequired=amount/500;
		count-=billsRequired;	
	}
	public boolean isSufficientCashAvailable(int amount) {
		int billsRequired=amount/500;
		if ( count >= billsRequired ) {
			return true;
		}
		else {
			return false;
		}
	}
}
