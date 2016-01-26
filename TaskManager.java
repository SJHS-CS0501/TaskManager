import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * text menu
 * add new task?
 * save file
 * read from file?
 * create new task list
 * can have user enter file name or use own
 * add searching stuff for program
 * implement sort by priority so user can print out the list of tasks in priority order
 */


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
 * This is the main class for the TastManager program. All the attention, none of the work.
 * @author Isabelle Schroeder
 *
 */
public class TaskManager {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String input;
		String fileName = "Tasks.txt";
		int numTasks = 0;
		TaskList otherStuff = new TaskList();
		
		System.out.println( "Welcome to the Task Manager!" );
		
		do{
			Task stuff = new Task();

			System.out.print( "Description: " );
			input = keyboard.nextLine();
			stuff.setDescription( input);
			
			System.out.print( "Priority(1-3): " );
			input = keyboard.nextLine();
			stuff.setPriority( Short.parseShort( input ) );
			
			System.out.print( "Category(1-5): " );
			input = keyboard.nextLine();
			stuff.setCategory( Short.parseShort( input ) );
			
			System.out.print( "Location: " );
			input = keyboard.nextLine();
			stuff.setLocation( input );
			
			System.out.print( "Completed? : " );
			input = keyboard.nextLine().toLowerCase();
			stuff.setCompleted( Boolean.parseBoolean( input ) );
			
			System.out.print( "Add new task?" );
			input = keyboard.nextLine().toLowerCase();
			
			
			otherStuff.addTask( stuff );
			
			numTasks++;
		
		} while( input.equalsIgnoreCase("y") );


		System.out.println( "Before read: ");
		otherStuff.printTasks();
		
		try{
			otherStuff.writeFile( fileName);
		} catch( FileNotFoundException e ){
			System.out.println("File \"" + fileName + "\" not found!");
			System.out.println( "Dying..." );
			e.printStackTrace();
			System.exit( -1 );
		}
		
		try{
			otherStuff.readFile( fileName );
		} catch( FileNotFoundException e ){
			System.out.println( "File \"" + fileName + "\" not found!" );
			System.out.println( "Dying...." );
			e.printStackTrace();
			System.exit(-1);
		}
		
		keyboard.close();
		System.exit(0);
	}

}
