import java.io.*;
//import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * This is the main class for the TastManager program. All the attention, none of the work.
 * @author Isabelle Schroeder
 *
 */
public class TaskManager {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String input = null; // for most of the input
		String fileName = "Tasks.txt"; // file were stuff is written to
		short menu = 0; // for the short input
		Date date = new Date(); // for the stupid date
		int modTask = 0; // for getting a task's position in the array
		int numTasks = 0; // keeps count of number of tasks added to task list
		TaskList otherStuff = new TaskList(); // TASK LIST!!
		
		System.out.println( "Welcome to the Task Manager!" );
		// A spiff little menu
		System.out.println( "Would you like to: " );
		System.out.println( "1. Load a task list from file" );
		System.out.println( "2. Save a new task list" );
		System.out.println( "3. Add a task" );
		System.out.println( "4. Remove a task" );
		System.out.println( "5. Edit a task" );
		System.out.println( "6. Search tasks" );
		System.out.println( "7. Sort tasks by priority" );
		System.out.println( "8. Print task list" );
		System.out.println( "9. Exit program" );
		menu = keyboard.nextShort();
	
		switch( menu ){ // Switch, switch, switch!
			case 1: // to load the file
				try{
					otherStuff.readFile( fileName );
				} catch( FileNotFoundException e ){
					System.out.println( "File \"" + fileName + "\" not found!" );
					System.out.println( "Dying...." );
					e.printStackTrace();
					System.exit(-1);
				}
				break;
			case 2: // for making a new Task list and then saving it to disk
				
				do{
					Task stuff = new Task(); // creating a new task

					System.out.print( "Description: " );
					input = keyboard.nextLine();
					stuff.setDescription( input); // setting description
					
					
					System.out.print( "Priority(1-3): " );
					input = keyboard.nextLine();
					// setting priority by converting string to short
					stuff.setPriority( Short.parseShort( input ) ); 
					
					System.out.print( "Category(1-5): " );
					System.out.println( "1. Other\n2. School\n3. Personal\n4. Chore\n5. Work" );
					input = keyboard.nextLine();
					// setting priority by converting string to short
					stuff.setCategory( Short.parseShort( input ) ); 
					
					
					System.out.print( "Location: " );
					input = keyboard.nextLine();
					stuff.setLocation( input ); // setting location
					
					System.out.print( "Due Date (ex. 01/12/2015): " );
					input = keyboard.nextLine();
					// now things get a little weird...
					// splitting the string where character "/" appears
					// This needs a string array to hold the three strings
					String [] dateParts = input.split( "/" ); 
					// setting first part of split string (which is month in America)
					int month = Integer.parseInt( dateParts[0] );
					// setting second part of string to day (America and stuff)
					int day = Integer.parseInt( dateParts[1] );
					// setting the third part of the string to year
					int year = Integer.parseInt( dateParts[2] );
					
					
					GregorianCalendar gCal = new GregorianCalendar( year, month, day );
					// plugging 
					date = gCal.getTime();
					stuff.setDate( date );
					// finally, finally sets the date
					
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
					otherStuff.writeFile( fileName );
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
				
				System.out.print( "Due Date (ex. 01/12/2015): " );
				input = keyboard.nextLine();
				String [] dateParts = input.split( "/" );
				int month = Integer.parseInt( dateParts[0] );
				int day = Integer.parseInt( dateParts[1] );
				int year = Integer.parseInt( dateParts[2] );
				GregorianCalendar gCal = new GregorianCalendar( year, month, day );
				date = gCal.getTime();
				stuff.setDate( date );
				
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
						break;
					case 2: 
						System.out.print( "New Priority: " );
						task.setPriority( menu );
						break;
					case 3:
						System.out.print( "New Category: " );
						task.setCategory( menu );
						break;
					case 4:
						System.out.print( "New Location: " );
						task.setLocation( input );
						break;
					case 5:
						System.out.print( "New Due Date: " );
						task.setDate( date );
						break;
					case 6:
						System.out.print( "Completed? " );
						task.setCompleted( Boolean.parseBoolean( input ) );
						break;
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

				otherStuff.orderByPrio();
				// sort by priority
				break;
			
			case 8:
				// print
				otherStuff.printTasks();
				break;
			case 9:
				// exit
				System.out.println( "GOODBYE!" );
				keyboard.close();
				System.exit(0);
		}
	}
}
