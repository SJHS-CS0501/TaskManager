import java.util.Scanner;
import java.io.*;
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
		
		TaskList taskList = new TaskList();
		String name = null, description = null, decide = null, filename = "Task name: ";
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
			Task task = new Task();
			decide = null;		
			String input = null;
			
			System.out.println( "Descrption: ");
			input = keyboard.nextLine();
			task.setDescription(input);
			
			System.out.println( "Location: " );
			input = keyboard.nextLine();
			task.setLocation(input);
			
			System.out.println( "Priority (as number) [1-3]");
			input = keyboard.nextLine();
			task.setPriority));
			
			System.out.println( "Category [1-5]: ");
			task.setCategory(keyboard.nextShort());
			
			//System.out.println( "Completed y/n: ");
			//task.setCompleted(keyboard.nextBoolean());
			
			taskList.addTask(task);
			
			System.out.println( "Would you like to add another task? y/n: ");
			decide = keyboard.nextLine();
			System.out.println();
			
		} while (decide.toLowerCase() != "n" );
		
		taskList.printTasks();
		
		
		try{
			taskList.writeFile(filename);
		} catch( FileNotFoundException e ) {
			System.out.println( "File \"" + filename + "\" not found!" );
			System.out.println( "Dying..." );
			e.printStackTrace();
			System.exit(-1);
		}
		
		
		
		keyboard.close();
		System.exit(0);
	}
}
