import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	/*
	 * Menu (text)
	 * 
	 * read from file
	 * -add task to existing after reading
	 * -create new tasks and add to file
	 * -can ask user for task file name
	 * -ask if they want to overwrite
	 * -save file?
	 * 
	 * start task list
	 * 
	 * search from tasks
	 * 
	 * implement sort by priority
	 * -can sort class by priority
	 */
	public static void main( String [] args ) throws ParseException {
		// main stuff goes here, yo
		System.out.println( "Welcome to the Task Manager!" );
		
		TaskList taskList = new TaskList();
		String name = null, description = null, decide = null, filename = "Task.txt";
		short temp;
		boolean truth, tempB;
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
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
			temp = Short.parseShort(input);
			task.setPriority(temp);
			
			System.out.println( "Category [1-5]: ");
			input = keyboard.nextLine();
			temp = Short.parseShort(input);
			task.setCategory(temp);
			
			System.out.println( "Completed (y or n): ");
			input = keyboard.nextLine();
			if( input == "y" ) {
				tempB = true;
			} else {
				tempB = false;
			}
			task.setCompleted( tempB );
			
			System.out.println( "Due Date: ");
			input = keyboard.nextLine();
			date = format.parse(input);

			taskList.addTask(task);
			
			System.out.println( "Would you like to add another task? y/n: ");
			decide = keyboard.nextLine().toLowerCase();
			System.out.println();
		
		} while (decide.charAt(0) == 'y' );
		
		taskList.printTasks();
		
		
		try{
			taskList.writeFile(filename);
		} catch( FileNotFoundException e ) {
			System.out.println( "File \"" + filename + "\" not found!" );
			System.out.println( "Dying..." );
			e.printStackTrace();
			System.exit(-1);
		}
		
		taskList = new TaskList();
		
		System.out.println( "Before read: " );
		taskList.printTasks();
		
		try {
			taskList.readFile( filename );
		} catch( FileNotFoundException e ) {
			System.out.println( "file \"" + filename + "\" not found!" );
			System.out.println( "Dying..." );
			e.printStackTrace();
		}
		
		
		keyboard.close();
		System.exit(0);
	}
}
