package userdefinedexception_assignemnt;


	public class BankingSystem {
	    public static void main(String[] args) {
	        BankAccount account = new BankAccount(12345, 5000);

	        try {
	            account.displayBalance();

	            // Valid deposit
	            account.deposit(2000);

	            // Invalid deposit
	            account.deposit(-500);

	            // Valid withdrawal
	            account.withdraw(3000);

	            // Invalid withdrawal
	            account.withdraw(0);

	            // Withdrawal exceeding balance
	            account.withdraw(5000);

	        } catch (InvalidAmountException | InsufficientFundsException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            System.out.println("Transaction Completed. Final Balance:");
	            account.displayBalance();
	        }
	    }
}
