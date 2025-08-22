
	package com.ashwini.assignment4;

	public class AirIndia implements Airfare {

	    private Integer hours;
	    private Double costPerHour;

	    // Default constructor
	    public AirIndia() {
	    }

	    // Parameterized constructor
	    public AirIndia(Integer hours, Double costPerHour) {
	        this.hours = hours;
	        this.costPerHour = costPerHour;
	    }

	    // Getters and Setters
	    public Integer getHours() {
	        return hours;
	    }

	    public void setHours(Integer hours) {
	        this.hours = hours;
	    }

	    public Double getCostPerHour() {
	        return costPerHour;
	    }

	    public void setCostPerHour(Double costPerHour) {
	        this.costPerHour = costPerHour;
	    }

	    // hours * costPerHour
	    @Override
	    public Double calculateAmount() {
	        return (hours == null || costPerHour == null) ? 0.0 : hours * costPerHour;
	    }
}
