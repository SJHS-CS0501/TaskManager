import java.io.*;
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
		TaskList newTaskList = new TaskList();
		String fileName = "Tasks.txt";
		String input;
		short set;
		boolean TrueFalse;
		
		System.out.print( "Welcome to the Task Manager! Would you like to...\n1. read your tasks\n2. create a new task\n"
				+ "3. search for a specific task\n(enter number) " );
		set = keyboard.nextShort();
		
		switch( set ) {
		case 1:
			System.out.print( "Enter the name of the file you want to read from: " );
			input = keyboard.nextLine();
			//method
			break;
		case 2:
			//jumping out
			break;
		case 3:
			System.out.print( "Do you want to search by...\n1. priority\n2. category\n3. description\n4. location\n5. "
					+ "state of completion\n(enter number) " );
			set = keyboard.nextShort();
			switch( set ) {
			case 1:
				System.out.print( "Of priority...\n0. Undefined\n1. High\n2. Medium\n3. Low\n(enter number) " );
				set = keyboard.nextShort();
				set.searchPriority();
				break;
			case 2:
				System.out.print( "In category...\n0. Undefined\n1. Other\n2. School\n3. Personal\n4. Chore\n5. Work\n(enter number) " );
				set = keyboard.nextShort();
				set.searchCategory();
				break;
			case 3:
				System.out.print( "With description...\n(enter description) " );
				input = keyboard.nextLine();
				input.searchDescription();
				break;
			case 4:
				System.out.print( "With location...\n(enter location) " );
				input = keyboard.nextLine();
				input.searchLocation();
				break;
			case 5:
				System.out.print( "That are...\n1. Completed\n2. Incomplete\n(enter number) " );
				set = keyboard.nextShort();
				set.searchCompletion();
				break;
			}
			break;
		}
		
		/*
		 * menu:
		 * 
		 * read..
		 * write..confused here
		 * add..
		 * save..confused
		 * add tasks..after they read from file
		 * can ask for file name...not much validation..if file already exists ask if they want to overwrite..confused  
		 * allow to search
		 * 
		 * hard part:
		 * sort by priority so they can print tasks in priority order
		 * 
		 * add date..
		 */
		
		do {
			Task newTask = new Task();
			
			 System.out.print( "Enter priority (1-3): " );
			 set = keyboard.nextShort();
			 newTask.setPriority( set );
			 
			 keyboard.nextLine();
			 
			 System.out.print( "Enter category (1-5): " );
			 set = keyboard.nextShort();
			 newTask.setCategory( set );
			 
			 keyboard.nextLine();
			 
			 System.out.print( "Enter description: " );
			 input = keyboard.nextLine();
			 newTask.setDescription( input );
			 
			 System.out.print( "Enter location (return for none): " );
			 input = keyboard.nextLine();
			 newTask.setLocation( input );
			 
			 System.out.print( "Enter state of completion (type true or false): " );
			 TrueFalse = keyboard.nextBoolean();
			 newTask.setCompleted( TrueFalse );
			 
			keyboard.nextLine();
			 
			 newTaskList.addTask( newTask );
			 
			 System.out.print( "Do you want to enter another task? (yes/no): " );
			 input = keyboard.nextLine().toLowerCase();
			 			 
		} while (input.charAt(0) == 'y' );
		
		
		newTaskList.printTasks();
		
		try {
			newTaskList.writeFile( fileName );
		} catch( FileNotFoundException e ) {
			System.out.println( "File \"" + fileName + "\" not found");
			System.out.println( "Dying..." );
			e.printStackTrace();
			System.exit(-1);
		}
		
		newTaskList = new TaskList();
		
		System.out.println( "Before read: " );
		newTaskList.printTasks();
		
		try {
			newTaskList.readFile( fileName );
		} catch( FileNotFoundException e ) {
			System.out.println( "File \"" + fileName + "\" not found");
			System.out.println( "Dying..." );
			e.printStackTrace();
			System.exit(-1);
		}
		
		keyboard.close();
		
		System.exit(0);

	}

}
