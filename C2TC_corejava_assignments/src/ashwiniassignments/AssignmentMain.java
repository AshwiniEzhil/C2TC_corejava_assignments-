package ashwiniassignments;

	import com.ashwini.assignement.employees.Developer;
	import com.ashwini.assignement.employees.Manager;
	import com.ashwini.assignement.utilities.EmployeeUtilities;

	/**
	 * Demonstrates creating Manager and Developer objects and using EmployeeUtilities.
	 */
	public class AssignmentMain {
	    public static void main(String[] args) {
	        // Creating Manager object
	        Manager mgr = new Manager("Alice", 101, 75000, 5);

	        // Creating Developer object
	        Developer dev = new Developer("Bob", 102, 60000, "Java");

	        // Calling method to display details of Manager object
	        EmployeeUtilities.displayEmployeeDetails(mgr);

	        // Calling method to display details of Developer object
	        EmployeeUtilities.displayEmployeeDetails(dev);

	        // Calling method to give raise to Manager object
	        EmployeeUtilities.giveRaise(mgr, 10);

	        // Calling method to give raise to Developer object
	        EmployeeUtilities.giveRaise(dev, 15);
	    }
	}

