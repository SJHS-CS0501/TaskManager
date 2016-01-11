/*
 * do these things:
 * - keep list of tasks
 * - allow user to add/remove tasks
 * - allow user to prioritize tasks
 * - print out lists of tasks
 * 
 * list of tasks:
 * - read and store on disk
 * - sort/search
 * 
 * reports:
 * - list high priority
 * - list due today/soon
 * - list all(by date OR by priority)
 */

/**
 * This program will assist the user to manage their tasks. (organize, sort, delete, add).
 * @author Julianna Nichols
 */

public class TaskManager {
	
	/**
	 * This is the main method for the TaskManager program.
	 * @param args
	 */

	public static void main(String[] args) {
		
		System.out.println( "Welcome to the Task Manager!" );
		
		/*
		 * erase from here ....when done testing task
		 */
		
		Task foo = new Task();
		foo.setDescription( "Test Task" );
		
		try {
			//what we want to try that might throw an exception
			foo.setPriority( (short)1 );
		} catch ( Exception e ) {
			//what to do if we catch the exception
			System.out.println( "Error setting priority: " + e.getMessage() );
			//System.exit(-1);
		}
		
		System.out.println( "Task info: " );
		System.out.println( "\tTask: " + foo.getDescription() );
		System.out.println( "\t\tPriority: " + foo.getPriorityName() );
		
		
		/*
		 * ....to here
		 */
		
		System.exit(0);

	}

}
