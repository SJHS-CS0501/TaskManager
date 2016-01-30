import java.io.FileNotFoundException;
import java.util.Date;
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
		short menu = 0;
		Date date = new Date();
		int modTask = 0;
		//boolean thing;
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
				
				System.out.print( "Due Date: ");
				input = keyboard.nextLine();
				stuff.setDate( date ); // THIS SHOULD NOT WORK REMEMEBER TO LOOK HERE AGAIN!!!!!
				
				System.out.print( "Completed? : " );
				input = keyboard.nextLine().toLowerCase();
				stuff.setCompleted( Boolean.parseBoolean( input ) );

				otherStuff.addTask( stuff );
				
				numTasks++;
	
				break;
			case 4:
				// remove
				otherStuff.printTasks();
				
				System.out.println( "Which task would you like to remove? (Enter an interger starting with 0)" );
				modTask = keyboard.nextInt();
				otherStuff.removeTask( modTask );
				
				break;
			
			
				
				
				
				
				
				
				
				
				
				
				
				
			
			case 5:
				// edit
				otherStuff.printTasks();
				
				System.out.println( "Which task would you like to edit?" );
				modTask = keyboard.nextInt();
				
				Task task = otherStuff.getTask( modTask );
				
				System.out.println( "What would you like to edit?" );
				System.out.println( "1. Description" );
				System.out.println( "2. Priority" );
				System.out.println( "3. Category" );
				System.out.println( "4. Location" );
				System.out.println( "5. Due Date" );
				System.out.println( "6. Completed?" );
				modTask = keyboard.nextInt();
				
				switch( modTask ){
					case 1:
						System.out.print( "New Description: " );
						task.setDescription( input );
					case 2: 
						System.out.print( "New Priority: " );
						task.setPriority( menu );
					case 3:
						System.out.print( "New Category: " );
						task.setCategory( menu );
					case 4:
						System.out.print( "New Location: " );
						task.setLocation( input );
					case 5:
						System.out.print( "New Due Date: " );
						task.setDate( date );
					case 6:
						System.out.print( "Completed? " );
						task.setCompleted( Boolean.parseBoolean( input ) );
				
				
						
						
						
						
						
						
						
						
						
				
				}
				break;
			case 6:
				// search
				System.out.println( "Would you like to search by: " );
				System.out.println( "1. Category" );
				System.out.println( "2. Priority" );
				System.out.println( "3. Due date" );
				System.out.println( "4. Location" );
				System.out.println( "5. Completion" );
				menu = keyboard.nextShort();
				
				switch( menu ){
					case 1:
						otherStuff.searchByCategory( menu );
						break;
					case 2:
						otherStuff.searchByPriority( menu );
						break;
					case 3:
						otherStuff.searchByDueDate( date );
						break;
					case 4:
						otherStuff.searchByLocation( input );
						break;
					case 5:
						otherStuff.searchByCompleted( input );
						break;
				}
				
				break;
			case 7:
				// sort by priority
				
				
				break;
			case 8:
				// print
				otherStuff.printTasks();
				break;
			case 9:
				// exit
				System.out.println( "GOODBYE!" );
				System.exit(0);
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
			
			System.out.println( "Due Date: " );
			input = keyboard.nextLine();
			stuff.setDate( date ); // THIS TOOOOOOOOOOOOOOOOOOOOOOOOOO
			
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
