
	package taskscheduler_assignment;

	import java.time.LocalTime;
	import java.util.concurrent.ScheduledFuture;

	/**
	 * Demonstrates scheduling three different tasks using lambda expressions.
	 * Runs for ~8 seconds and then stops everything gracefully.
	 */
	public class TaskSchedulerDemo {

	    public static void main(String[] args) throws InterruptedException {
	        TaskScheduler scheduler = new TaskScheduler();

	        // Task 1: prints a heartbeat every 1 second
	        ScheduledFuture<?> heartbeatHandle = scheduler.scheduleTask(
	                () -> System.out.println("[Heartbeat 1s] " + LocalTime.now()),
	                1
	        );

	        // Task 2: simulates a backup every 2 seconds
	        ScheduledFuture<?> backupHandle = scheduler.scheduleTask(
	                () -> System.out.println("-> Running incremental backup (every 2s)"),
	                2
	        );

	        // Task 3: simulates a cleanup every 3 seconds
	        ScheduledFuture<?> cleanupHandle = scheduler.scheduleTask(
	                () -> System.out.println("** Temp cleanup (every 3s) **"),
	                3
	        );

	        // Let the demo run for a short time so we can observe output
	        Thread.sleep(8000);

	        // Stop individual tasks
	        scheduler.stop(heartbeatHandle);
	        scheduler.stop(backupHandle);
	        scheduler.stop(cleanupHandle);

	        // Shut down the scheduler service
	        scheduler.shutdown();

	        System.out.println("All tasks stopped. Exiting demo.");
	    }


}
