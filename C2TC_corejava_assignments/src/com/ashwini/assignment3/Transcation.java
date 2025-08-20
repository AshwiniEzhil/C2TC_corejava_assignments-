package com.ashwini.assignment3;


	/**
	 * Demonstrates "final":
	 * - transactionFee is a final (immutable) variable per Transaction instance.
	 * - performTransaction(...) is a final method to keep the process consistent and tamper-proof.
	 */
	public class Transcation {

	    // (3.b) Final variable for fixed fee per transaction (immutable after construction)
	    private final double transcationFee;

	    public Transcation(double transcationFee) {
	        if (transcationFee < 0) {
	            throw new IllegalArgumentException("transactionFee cannot be negative");
	        }
	        this.transcationFee = transcationFee;
	    }

	    public final double getTransactionFee() { // final accessor for clarity and integrity
	        return transcationFee;
	    }

	    /**
	     * (3.a) Final method: ensures consistent transaction process system-wide.
	     * Debits (amount + fee) from 'from' and credits 'amount' to 'to'.
	     *
	     * @return true if successful; false if withdrawal failed.
	     */
	    public final boolean performTransaction(Account from, Account to, double amount) {
	        if (from == null || to == null) throw new IllegalArgumentException("Accounts cannot be null");
	        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

	        double totalDebit = amount + transcationFee;

	        // Deduct the amount + fee from the sender (integrity: fee always applied)
	        boolean debited = from.withdraw(totalDebit);
	        if (!debited) {
	            return false; // insufficient funds/limit on sender side
	        }

	        // Credit only the amount to the receiver
	        to.deposit(amount);
	        return true;
	    }
	}

