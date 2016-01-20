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
		System.out.println( "Welcome to the Task Manager!" );
		
		do{
			Task task = new Task();
			
			System.out.println( "Enter task: " );
			input = keyboard.nextLine();

			System.out.println( "Description: " );
			input = keyboard.nextLine();
			task.setDescription( input);
			
			System.out.println( "Priority(1-3): " );
			input = keyboard.nextLine();
			task.setPriority( input ); //short
			
			System.out.println( "Category(1-5): " );
			input = keyboard.nextLine();
			task.setCategory( input ); //short
			
			System.out.println( "Location: " );
			input = keyboard.nextLine();
			task.setLocation( input );
			
			System.out.println( "Add new task?" );
			input = keyboard.nextLine();
		
		} while( input == ("n") );

		
		
		System.exit(0);
	}

}
