

	package com.ashwini.assignment4;

	import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int choice = Integer.parseInt(sc.nextLine().trim());   // 1-AirIndia, 2-KingFisher, 3-Indigo
	        int hours = Integer.parseInt(sc.nextLine().trim());    // hours of travel
	        double costPerHour = Double.parseDouble(sc.nextLine().trim()); // cost per hour

	        Airfare airfare;
	        switch (choice) {
	            case 1:
	                airfare = new AirIndia(hours, costPerHour);
	                break;
	            case 2:
	                airfare = new KingFisher(hours, costPerHour);
	                break;
	            case 3:
	                airfare = new Indigo(hours, costPerHour);
	                break;
	            default:
	                // Assuming inputs will be valid as per problem statement.
	                sc.close();
	                return;
	        }

	        Double amount = airfare.calculateAmount();

	        // Print rounded to 2 decimal places, no extra text
	        System.out.printf("%.2f", amount);

	        sc.close();
	    }
}
