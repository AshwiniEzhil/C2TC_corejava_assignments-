package userdefinedexception_assignemnt;


	// Custom Exception for invalid deposit/withdrawal amounts
	public class InvalidAmountException extends Exception {
	    public InvalidAmountException(String message) {
	        super(message);
	    }
	}

