/**
 * A program that manages tasks
 * @author Ryan Luchs
 * 
 */

/*
 * Task Manager Program
 * 
 * Do these things:
 * - Keep a list of tasks
 * - Allow user to add and remove tasks
 * - Allow user to reprioritize tasks
 * - Print out lists of tasks
 * 
 * List of tasks:
 * - Read and Store on disk
 * - Sort
 * - Search
 * 
 * Reports:
 * - List high priority
 * - List due today/soon
 * - List all (by date OR by priority)
 * 
 */

/**
 * TaskManager main class
 * @author Ryan Luchs
 *
 */
public class TaskManager {

	/**
	 * TaskManager main method
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println("welcome to the Task Manager!");
		
		/*
		 * ERASE FROM HERE TO THERE WHEN DONE TESTING TASK
		 */
		Task foo = new Task();
		foo.setDescription("Test Task");
		try {
			foo.setPriority((short)12);
		} catch(Exception e) {
			System.out.println("Error setting priority: " + e.getMessage());
			System.exit(-1);
		}
		
		// time passes...
		
		System.out.println("Task info: ");
		System.out.print("\tTask: " + foo.getDescription());
		System.out.print("\t\tPrioity: " + foo.getPriority());
		
		/*
		 * THERE
		 */
		
		System.exit(0);
	}

}
