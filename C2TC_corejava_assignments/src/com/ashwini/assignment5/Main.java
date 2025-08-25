package com.ashwini.assignment5;

	import java.util.Scanner;

	/**
	 * Main driver class for the Billing System.
	 * Reads user input in CSV format and calls appropriate
	 * overloaded payment methods from TicketBooking.
	 */
	public class Main {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // -------- Step 1: Read booking details in CSV format --------
	        // Example: Magic show,Lunu,43
	        String bookingDetails = sc.nextLine();
	        String[] parts = bookingDetails.split(",");

	        // Extract details
	        String stageEvent = parts[0];
	        String customer = parts[1];
	        int noOfSeats = Integer.parseInt(parts[2]);

	        // Create TicketBooking object
	        TicketBooking booking = new TicketBooking(stageEvent, customer, noOfSeats);

	        // -------- Step 2: Read payment mode --------
	        int choice = sc.nextInt();
	        sc.nextLine(); // consume newline

	        // -------- Step 3: Handle payment based on choice --------
	        switch (choice) {
	            case 1: // Cash Payment
	                double cashAmount = sc.nextDouble();
	                booking.makePayment(cashAmount);
	                break;

	            case 2: // Wallet Payment
	                double walletAmount = sc.nextDouble();
	                sc.nextLine(); // consume newline
	                String walletNumber = sc.nextLine();
	                booking.makePayment(walletAmount, walletNumber);
	                break;

	            case 3: // Credit Card Payment
	                String holderName = sc.nextLine();   // Card holder name
	                double cardAmount = sc.nextDouble(); // Amount
	                sc.nextLine(); // consume newline
	                String cardType = sc.nextLine();     // Credit card type
	                String ccv = sc.nextLine();          // CCV
	                booking.makePayment(holderName, cardAmount, cardType, ccv);
	                break;

	            default:
	                // If choice is not 1, 2, or 3
	                System.out.println("Invalid choice");
	        }

	        sc.close();
	    }
}
