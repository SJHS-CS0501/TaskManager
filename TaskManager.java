import java.util.Scanner;

/*
 * Task Manager Program 
 * 
 * DO These Things:
 * -Keep a list of tasks
 * -Allow user to add and remove tasks
 * -Allow user to reprioratize tasks
 * -Print out lists of tasks
 * 
 * List of tasks
 * -Read and store on disk
 * -Sort
 * -Search
 * 
 * Reports:
 * -List high priority
 * -List due today/soon
 * - List all (by date OR by priority)
 */

/**
 * 
 * @author Isabelle Schroeder
 *
 */
public class TaskManager {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println( "Welcome to the Task Manager!" );
		
		// four tasks
		
		do{
			System.out.println( "Enter task: " );
			System.out.println( "Description: " );
			System.out.println( "Priority(1-3): " );
			System.out.println( "Category(1-5): " );
			System.out.println( "Location: " );
		}
		
		
		
		
		
		/*
		 * ERASE FROM HERE TO THERE WHEN DONE TESTING TASK
		 */
		
		Task foo = new Task();
		foo.setDescription( "Test Task" );
		try{
			// what we want to try that might throw an exception
			foo.setPriority( (short)(1) );
		} catch( Exception e ){
			// What we do if we catch the exception
			System.out.println( "Error setting priority: " + e.getMessage() );
			//System.exit(-1);
		}
		
		// time passes...
		
		System.out.println( "Task info: " );
		System.out.println( "\tTask: " + foo.getDescription() );
		System.out.println( "\t\tPriority: " + foo.getPriority() );
		
		/*
		 * THERE
		 */
		
		System.exit(0);
	}

}
