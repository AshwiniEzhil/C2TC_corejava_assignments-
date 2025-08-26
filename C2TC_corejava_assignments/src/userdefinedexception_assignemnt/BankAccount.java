package userdefinedexception_assignemnt;

	public class BankAccount {
	    private int accountNumber;
	    private double balance;

	    // Parameterized Constructor
	    public BankAccount(int accountNumber, double balance) {
	        this.accountNumber = accountNumber;
	        this.balance = balance;
	    }

	    // Deposit Method
	    public void deposit(double amount) throws InvalidAmountException {
	        if (amount <= 0) {
	            throw new InvalidAmountException("Deposit amount must be greater than zero.");
	        }
	        balance += amount;
	        System.out.println("Successfully deposited: " + amount);
	    }

	    // Withdraw Method
	    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
	        if (amount <= 0) {
	            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
	        }
	        if (amount > balance) {
	            throw new InsufficientFundsException("Insufficient balance! Available: " + balance);
	        }
	        balance -= amount;
	        System.out.println("Successfully withdrawn: " + amount);
	    }

	    // Display Balance Method
	    public void displayBalance() {
	        System.out.println("Account Number: " + accountNumber + " | Current Balance: " + balance);
	    }
	}

