package com.ashwini.assignment3;



	/**
	 * Concrete subclass for checking accounts.
	 * Example rule: allow overdraft up to a limit.
	 */
	public class CheckingAccount extends Account {

	    private final double overdraftLimit; // immutable overdraft policy for the account

	    public CheckingAccount(String accountNumber, String holderName, double openingBalance,
	                           double overdraftLimit) {
	        super(accountNumber, holderName, openingBalance);
	        if (overdraftLimit < 0) {
	            throw new IllegalArgumentException("Overdraft limit cannot be negative");
	        }
	        this.overdraftLimit = overdraftLimit;
	    }

	    @Override
	    public void deposit(double amount) {
	        ensurePositiveAmount(amount);
	        balance += amount;
	    }

	    @Override
	    public boolean withdraw(double amount) {
	        ensurePositiveAmount(amount);
	        // Allow going negative up to -overdraftLimit
	        if (balance - amount >= -overdraftLimit) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }

	    @Override
	    public double getBalance() {
	        return balance;
	    }

	    public double getOverdraftLimit() {
	        return overdraftLimit;
	    }
	}


