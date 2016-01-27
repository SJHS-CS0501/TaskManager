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
		int menu = 0;
		int numTasks = 0;
		TaskList otherStuff = new TaskList();
		
		System.out.println( "Welcome to the Task Manager!" );
		
		System.out.println( "Would you like to: " );
		System.out.println( "1. Load a task list from file" );
		System.out.println( "2. Save task list" );
		System.out.println( "3. Add a task" );
		System.out.println( "4. Remove a task" );
		System.out.println( "5. Edit a task" );
		System.out.println( "6. Search tasks" );
		System.out.println( "7. Sort tasks by priority" );
		System.out.println( "8. Print task list" );
		System.out.println( "9. Exit program" );
		input = keyboard.nextLine();
		
		switch( menu ){
			case 1:
				// load
				break;
			case 2:
				// save
				break;
			case 3:
				// add
				break;
			case 4:
				// remove
				break;
			case 5:
				// edit
				break;
			case 6:
				// search
				System.out.println( "Would you like to search by: " );
				System.out.println( "1. Category" );
				System.out.println( "2. Priority" );
				System.out.println( "3. Due date" );
				System.out.println( "4. Location" );
				System.out.println( "5. Completion" );
				menu = keyboard.nextInt();
				
				switch( menu ){
					case 1:
						otherStuff.searchByCategory();
						break;
					case 2:
						otherStuff.searchByPriority();
						break;
					case 3:
						otherStuff.searchByDate();
						break;
					case 4:
						otherStuff.searchByLocation();
						break;
					case 5:
						otherStuff.searchByCompletion();
						break;
				}
				
				break;
			case 7:
				// sort by priority
				break;
			case 8:
				// print
				break;
			case 9:
				// exit
				break;	
		}
		
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
