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
		String input;
		short set;
		boolean yesNo;
		
		System.out.print( "Welcome to the Task Manager!" );
		
		do {
			Task newTask = new Task();
			TaskList newTaskList = new TaskList();
			
			 System.out.print( "Enter description: " );
			 input = keyboard.nextLine();
			 newTask.setDescription( input );
			 
			 System.out.print( "Enter category: " );
			 set = keyboard.nextShort();
			 newTask.setCategory( set );
			 
			 System.out.print( "Enter priority: " );
			 set = keyboard.nextShort();
			 newTask.setPriority( set );
			 
			 System.out.print( "Enter location: " );
			 input = keyboard.nextLine();
			 newTask.setLocation( input );
			 
			 System.out.print( "Enter state of completion: " );
			 yesNo = keyboard.nextBoolean();
			 newTask.setCompleted( yesNo );
			 
			 newTaskList.addTask( t );
			 
			 System.out.print( "Do you want to enter another task? (y for yes; n for no): " );
			 input = keyboard.nextLine();
			 
		} while (input.equalsIgnoreCase("y") );
		
		System.exit(0);

	}

}
