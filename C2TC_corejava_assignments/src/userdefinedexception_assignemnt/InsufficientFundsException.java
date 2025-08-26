
	package userdefinedexception_assignemnt;

	// Custom Exception for insufficient balance
	public class InsufficientFundsException extends Exception {
	    public InsufficientFundsException(String message) {
	        super(message);
	    }
	}
