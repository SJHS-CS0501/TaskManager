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
		String newTask;
		
		System.out.print( "Welcome to the Task Manager! Do you want to add a new task? (Y for yes; N for no): "  );
		newTask = keyboard.nextLine();
		
		if( newTask.toLowerCase().equals('y') ) {
			short userPriority;
			Task.setPriority( userPrioirity);
		} else {
			
		}
		
		
		
		
		//user has to create four tasks
		
		System.exit(0);

	}

}
