

	package taskscheduler_assignment;

	/**
	 * A functional interface representing a unit of work.
	 * Because it has exactly one abstract method, we can
	 * pass a lambda expression wherever a Task is expected.
	 */
	@FunctionalInterface
	public interface Task {
	    /**
	     * Do the work for this task.
	     */
	    void execute();
	}
