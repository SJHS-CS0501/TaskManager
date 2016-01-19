import java.util.Scanner;

/**
 * 
 */

/*
 * Task Manager Program
 * 
 * Do these things
 * - Keep a list of tasks
 * - Allow user to add and remove tasks
 * - Allow user to reprioritze tasks
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
 * @author Jack Protivnak
 *
 */
public class TaskManager {
	
	public static void main( String [] args ) {
		// main stuff goes here, yo
		System.out.println( "Welcome to the Task Manager!" );
		
		Task task = new Task();
		String name = null
		Scanner keyboard = new Scanner(System.in);
		
		/*
		 * ERASE FROM HERE TO THERE WHEN DONE TESTING TASK
		 
		Task foo = new Task();
		foo.setDescription( "Test Task" );
		try {
			// What we want to try that might throw an exception
			foo.setPriority( (short)12 );
		} catch( Exception e ) {
			// What to do if we catch the exception
			System.out.println( "Error setting priority: " + e.getMessage() );
			//System.exit(-1);
		}
		
		// time passes...
		
		System.out.println( "Task info: " );
		System.out.println( "\tTask: " + foo.getDescription() );
		System.out.println( "\t\tPriority: " + foo.getPriorityName() );
		
		
		 * THERE
		 */
		
		// Allow user to make 4 tasks
		
		do{
			System.out.println( "Please enter the name of your new task: " );
			name = keyboard.nextLine();
			
			System.out.println( "Descrption:");
		} while (choice != "q");
		
		
		
		
		
		System.exit(0);
	}
}
