import java.util.Scanner;

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
		Scanner keyboard = new Scanner( System.in );
		String set;
		int input;
		
		System.out.print( "Welcome to the Task Manager!" );
		
		do {
			Task newTask = new Task();
			
			 System.out.print( "Enter description: " );
			 set = keyboard.nextLine();
			 newTask.setDescription( set );
			 
			 System.out.print( "Enter category: " );
			 input = keyboard.nextInt();
			 newTask.setCategory( input );
			 
			 System.out.print( "Enter priority: " );
			 input = keyboard.nextInt();
			 newTask.setPriority( input );
			 
			 System.out.print( "Enter location: " );
			 set = keyboard.nextLine();
			 newTask.setLocation( set );
			 
			 System.out.print( "Enter state of completion: " );
			 set= keyboard.nextLine();
			 
		} while ()
		
		
		//user has to create four tasks
		
		System.exit(0);

	}

}
