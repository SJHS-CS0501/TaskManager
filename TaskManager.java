import java.io.FileNotFoundException;
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
		String fileName = "Tasks.txt";
		short thing = 0;
		int numTasks = 0;
		int ctr = 0;
		TaskList otherStuff = new TaskList();
		
		System.out.println( "Welcome to the Task Manager!" );
		
		do{
			Task stuff = new Task();
			
			System.out.print( "Enter task: " );
			input = keyboard.nextLine();

			System.out.print( "Description: " );
			input = keyboard.nextLine();
			stuff.setDescription( input);
			
			System.out.print( "Priority(1-3): " );
			input = keyboard.nextLine();
			stuff.setPriority( thing );
			
			System.out.print( "Category(1-5): " );
			input = keyboard.nextLine();
			stuff.setCategory( thing );
			
			System.out.print( "Location: " );
			input = keyboard.nextLine();
			stuff.setLocation( input );
			
			System.out.print( "Completed? : " );
			input = keyboard.nextLine().toLowerCase();
			
			System.out.print( "Add new task?" );
			input = keyboard.nextLine().toLowerCase();
			
			otherStuff.addTask( stuff );
			
			numTasks++;
		
		} while( input.equalsIgnoreCase("y") );

		
		otherStuff.printTasks();
		
		try{
			otherStuff.writeFile( fileName);
		} catch( FileNotFoundException e ){
			System.out.println("File \"" + fileName + "\" not found!");
			System.out.println( "Dying..." );
			e.printStackTrace();
			System.exit( -1 );
		}
		
		keyboard.close();
		System.exit(0);
	}

}
