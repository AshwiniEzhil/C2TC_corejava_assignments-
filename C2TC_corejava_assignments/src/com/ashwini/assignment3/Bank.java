package com.ashwini.assignment3;

	/**
	 * Demonstrates "static":
	 * - totalAccounts is shared by all Account instances across the JVM.
	 * - getTotalAccounts() is a static accessor.
	 */
	public class Bank {

	    // (1.a) Static variable shared by the whole class/JVM
	    private static int totalAccounts = 0;

	    // Package-private helper to register new account creations
	    static void registerNewAccount() {
	        totalAccounts++;
	    }

	    // (1.b) Static method to return current total
	    public static int getTotalAccounts() {
	        return totalAccounts;
	    }
	}

