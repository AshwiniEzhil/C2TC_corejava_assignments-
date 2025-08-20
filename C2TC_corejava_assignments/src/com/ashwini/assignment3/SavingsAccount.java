package com.ashwini.assignment3;

	/**
	 * Concrete subclass for savings accounts.
	 * Example rule: maintain a minimum balance.
	 */
	public class SavingsAccount extends Account {

	    private final double minimumBalance; // immutable rule per account
	    private final double interestRate;   // kept for extensibility

	    public SavingsAccount(String accountNumber, String holderName, double openingBalance,
	                          double minimumBalance, double interestRate) {
	        super(accountNumber, holderName, openingBalance);
	        if (minimumBalance < 0) {
	            throw new IllegalArgumentException("Minimum balance cannot be negative");
	        }
	        if (interestRate < 0) {
	            throw new IllegalArgumentException("Interest rate cannot be negative");
	        }
	        this.minimumBalance = minimumBalance;
	        this.interestRate = interestRate;
	    }

	    @Override
	    public void deposit(double amount) {
	        ensurePositiveAmount(amount);
	        balance += amount;
	    }

	    @Override
	    public boolean withdraw(double amount) {
	        ensurePositiveAmount(amount);
	        // Withdrawal allowed only if post-withdrawal balance >= minimumBalance
	        if (balance - amount >= minimumBalance) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }

	    @Override
	    public double getBalance() {
	        return balance;
	    }

	    public double getMinimumBalance() {
	        return minimumBalance;
	    }

	    public double getInterestRate() {
	        return interestRate;
	    }
}
