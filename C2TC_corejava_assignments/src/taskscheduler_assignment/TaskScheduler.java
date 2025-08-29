
	package taskscheduler_assignment;

	import java.util.concurrent.Executors;
	import java.util.concurrent.ScheduledExecutorService;
	import java.util.concurrent.ScheduledFuture;
	import java.util.concurrent.TimeUnit;

	/**
	 * Manages scheduling of tasks at fixed time intervals (in seconds).
	 * Internally uses a ScheduledExecutorService for reliable timing.
	 */
	public class TaskScheduler {

	    // A small thread pool to run scheduled tasks concurrently if needed.
	    private final ScheduledExecutorService executor =
	            Executors.newScheduledThreadPool(4);

	    /**
	     * Schedule a task to run repeatedly at the given interval (in seconds).
	     * The task starts immediately (initial delay = 0 seconds).
	     *
	     * @param task            the work to execute (lambda-friendly)
	     * @param intervalSeconds interval between runs, in seconds (must be > 0)
	     * @return a handle (ScheduledFuture) that can be used to cancel this task
	     * @throws IllegalArgumentException if intervalSeconds <= 0
	     */
	    public ScheduledFuture<?> scheduleTask(Task task, int intervalSeconds) {
	        if (intervalSeconds <= 0) {
	            throw new IllegalArgumentException("Interval must be > 0 seconds.");
	        }

	        // Wrap Task::execute in a Runnable for the scheduler.
	        Runnable runnable = task::execute;

	        // scheduleAtFixedRate keeps the fixed period regardless of task duration
	        // (unless the task takes longer than the period).
	        return executor.scheduleAtFixedRate(
	                runnable,
	                0,                        // start immediately
	                intervalSeconds,          // run every 'intervalSeconds'
	                TimeUnit.SECONDS
	        );
	    }

	    /**
	     * Cancel a scheduled task without interrupting if it's currently running.
	     *
	     * @param handle the ScheduledFuture returned by scheduleTask
	     */
	    public void stop(ScheduledFuture<?> handle) {
	        if (handle != null) {
	            handle.cancel(false); // false = don't interrupt if already running
	        }
	    }

	    /**
	     * Gracefully shut down the scheduler and stop accepting new tasks.
	     * Already scheduled tasks will be stopped; call after you're done.
	     */
	    public void shutdown() {
	        executor.shutdown();
	    }


}
