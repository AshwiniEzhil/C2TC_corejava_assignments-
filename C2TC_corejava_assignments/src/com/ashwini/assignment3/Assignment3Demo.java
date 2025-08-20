package com.ashwini.assignment3;


	/**
	 * Simple demo to show:
	 * - Static totalAccounts tracking
	 * - Abstract Account hierarchy in action
	 * - Final transaction behavior with fixed fee
	 */
	public class Assignment3Demo {

	    public static void main(String[] args) {
	        // Create accounts (Bank.registerNewAccount() is called in Account constructor)
	        SavingsAccount sav1 = new SavingsAccount(
	                "SAV001", "Alice", 5000.0,
	                500.0, 0.04
	        );
	        CheckingAccount chk1 = new CheckingAccount(
	                "CHK001", "Bob", 1500.0,
	                1000.0
	        );

	        System.out.println("After opening 2 accounts, total accounts = " + Bank.getTotalAccounts());
	        System.out.println(sav1);
	        System.out.println(chk1);

	        // Create a Transaction processor with a fixed fee (final)
	        Transcation tx = new Transcation(25.0); // fee = 25

	        // Perform a transfer of 600 from sav1 -> chk1 (debited 600 + 25 from sav1, credited 600 to chk1)
	        boolean ok1 = tx.performTransaction(sav1, chk1, 600.0);
	        System.out.println("\nTransaction 1 (600 from SAV001 to CHK001) success? " + ok1);
	        System.out.println("SAV001 balance: " + sav1.getBalance());
	        System.out.println("CHK001 balance: " + chk1.getBalance());

	        // Try a transfer that would violate savings minimum balance (e.g., large debit)
	        boolean ok2 = tx.performTransaction(sav1, chk1, 4500.0);
	        System.out.println("\nTransaction 2 (4500 from SAV001 to CHK001) success? " + ok2);
	        System.out.println("SAV001 balance: " + sav1.getBalance());
	        System.out.println("CHK001 balance: " + chk1.getBalance());

	        // Now test overdraft behavior on checking: transfer from CHK to SAV (allowed up to overdraft limit)
	        boolean ok3 = tx.performTransaction(chk1, sav1, 2300.0);
	        System.out.println("\nTransaction 3 (2300 from CHK001 to SAV001) success? " + ok3);
	        System.out.println("SAV001 balance: " + sav1.getBalance());
	        System.out.println("CHK001 balance: " + chk1.getBalance());

	        // Final totals
	        System.out.println("\nTotal accounts still = " + Bank.getTotalAccounts());
	        System.out.println("Fixed transaction fee (final): " + tx.getTransactionFee());
	    }
	}


