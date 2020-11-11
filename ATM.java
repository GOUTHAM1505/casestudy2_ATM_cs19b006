import java.util.Scanner;

public class ATM {
	private int presentAccountNumber;
	private boolean userRecognised;
	private BankDatabase bankDatabase;
	private CashDispenser cashDispenser;
	private DepositSlot depositSlot;
	
		public ATM{
			presentAccountNumber=0;
			userRecognised=false;
			bankDatabase=new BankDatabase();
			cashDispenser=new CashDispenser();
			depositSlot=new DepositSlot();
			Scanner s=new Scanner();
		}
		
		public void run(){
			while(true) {
				while(!userRecognised) {
					System.out.println("Welcome to the ATM");
					recogniseUser();
				}
				doTransactions();
				userRecognised=false;
				presentAccountNumber=0;
				System.out.println("Thank You,Visit again");
			}
		}
		
		
		private void recogniseUser(){
			System.out.println("Enter your accountNumber");
			
			int accountNumber=s.nextInt();
			
			System.out.println("Enter the pin");
			int pin=s.nextInt();
			
			userRecognised=bankDatabase.recogniseUser(accountNumber,pin);
			
			if(userRecognised) {
				presentAccountNumber=accountNumber;
				
			}else {
				System.out.println("Invalid accountnumber or pin");
				
			}
		}
		
		
		private void doTransactions() {
			Transaction currentTransaction=null;
			boolean userExited=false;
			while(!userExited) {
				System.out.println("press 1 for Balance Enquiry");
				System.out.println("Press 2 for cash deposit");
				System.out.println("Press 3 to withdraw money");
				System.out.println("Press 4 to change pin");
				System.out.println("press 5 to exit");
				int option=s.nextInt();
				
				switch(option) {
					case 1:
						currentTransaction=createTransaction(1);
						currentTransaction.execute();
						break;
					case 2:
						currentTransaction=createTransaction(2);
						currentTransaction.execute();
						break;
					case 3:
						currentTransaction=createTransaction(3);
						currentTransaction.execute();
						break;
					case 4:
						currentTransaction=createTransaction(4);
						currentTransaction.execute();
						break;
					case 5:
						System.out.println("Exiting");
						userExited=true;
						break;
					default:
						System.out.println("Enter a valid option");
						break;
						
				}
			}
			
		}
		
		
		private Transaction createTranaction(int option) {
			Transaction temp=null;
			switch(option) {
			case 1:
				temp=new BalanceEnquiry(presentAccountNumber,bankDataBase);
				break;
			case 2:
				temp=new Deposit(presentAccountNumber,bankDatabase,depositSlot);
				break;
			case 3:
				temp=new Withdrawl(presentAccountNumber,bankDatabase,cashDispenser);
				break;
			case 4:
				temp=new changePin(presentAccountNumber,bankDatabase);
				break;
			}
			return temp;
		}
		
		
}
