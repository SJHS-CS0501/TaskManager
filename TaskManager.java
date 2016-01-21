import java.io.PrintWriter;
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
		String input;
		short thing = 0;
		int numTasks = 0;
		
		System.out.println( "Welcome to the Task Manager!" );
		
		do{
			TaskList otherStuff = new TaskList();
			
			Task stuff = new Task();
			
			System.out.println( "Enter task: " );
			input = keyboard.nextLine();

			System.out.println( "Description: " );
			input = keyboard.nextLine();
			stuff.setDescription( input);
			
			System.out.println( "Priority(1-3): " );
			input = keyboard.nextLine();
			stuff.setPriority( thing );
			
			System.out.println( "Category(1-5): " );
			input = keyboard.nextLine();
			stuff.setCategory( thing );
			
			System.out.println( "Location: " );
			input = keyboard.nextLine();
			stuff.setLocation( input );
			
			System.out.println( "Add new task?" );
			input = keyboard.nextLine().toLowerCase();
			
			otherStuff.addTask( stuff );
			
			numTasks++;
		
		} while( input.equalsIgnoreCase("y") );

		
			
		
		System.exit(0);
	}

}
