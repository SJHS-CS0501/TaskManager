import java.io.*;
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
					
					
					/*
					 *  Date gets an extra separating space because it is actually a little evil 
					 *  and might corrupt the rest of the program.
					 */
					System.out.print( "Due Date (ex. 01/12/2015): " );
					input = keyboard.nextLine();
					// now things get a little weird...
					
					// splitting the string where character "/" appears
					//This needs a string array to hold the three strings
					String [] dateParts = input.split( "/" ); 
					// setting first part of split string (which is month in America)
					int month = Integer.parseInt( dateParts[0] );
					// setting second part of string to day (America and stuff)
					int day = Integer.parseInt( dateParts[1] );
					// setting the third part of the string to year
					int year = Integer.parseInt( dateParts[2] );
					
					// plugging in the newly parsed integers into Gregorian Calendar spiffiness
					GregorianCalendar gCal = new GregorianCalendar( year, month, day );
					// converting Gregorian Calendar into date!!
					date = gCal.getTime();
					// SETTING THAT DATE WITH SOME WICKED STYLE
					stuff.setDate( date );
					// finally, finally sets the date
					
					
					System.out.print( "Completed? : " ); // setting completed
					input = keyboard.nextLine().toLowerCase(); // doesn't matter how you enter the letter
					stuff.setCompleted( Boolean.parseBoolean( input ) ); // Parse that string!
					
					System.out.print( "Add new task?" );
					input = keyboard.nextLine().toLowerCase();
					
					
					otherStuff.addTask( stuff ); // adds the task to the task list 
					
					numTasks++; // keeping track of tasks in task list
				
				} while( input.equalsIgnoreCase("y") ); // ignoring case

				otherStuff.printTasks();
				
				// writing task list to disk
				try{
					otherStuff.writeFile( fileName );
				} catch( FileNotFoundException e ){ // no file = sadness
					System.out.println("File \"" + fileName + "\" not found!");
					System.out.println( "Dying..." );
					e.printStackTrace();
					System.exit( -1 );
				}
				break;
			case 3: // adding a new task to the pre-existing task list
				// Same as before...
				Task stuff = new Task();

				System.out.print( "Description: " ); // setting description
				input = keyboard.nextLine();
				stuff.setDescription( input);
				
				System.out.print( "Priority(1-3): " ); // setting priority
				input = keyboard.nextLine();
				stuff.setPriority( Short.parseShort( input ) ); // parsing to short
				
				System.out.print( "Category(1-5): " ); // setting category
				input = keyboard.nextLine();
				stuff.setCategory( Short.parseShort( input ) ); // parse, parse
				
				System.out.print( "Location: " ); // setting location
				input = keyboard.nextLine();
				stuff.setLocation( input );
				
				System.out.print( "Due Date (ex. 01/12/2015): " ); // date..-_-
				input = keyboard.nextLine();
				String [] dateParts = input.split( "/" );
				int month = Integer.parseInt( dateParts[0] );
				int day = Integer.parseInt( dateParts[1] );
				int year = Integer.parseInt( dateParts[2] );
				GregorianCalendar gCal = new GregorianCalendar( year, month, day );
				date = gCal.getTime();
				stuff.setDate( date ); // actually really happy with this date stuff in the end :)
				
				System.out.print( "Completed? : " ); // setting completed
				input = keyboard.nextLine().toLowerCase();
				stuff.setCompleted( Boolean.parseBoolean( input ) );

				otherStuff.addTask( stuff ); // adding the task to the task list
				
				numTasks++; // adding one to number of tasks in task list cause we added a task
	
				break;
			case 4: // remove a task
				otherStuff.printTasks(); // print tasks so user knows what's where
				
				System.out.println( "Which task would you like to remove? "
						+ "(Enter an interger starting with 0)" ); // because arrays start with 0
				modTask = keyboard.nextInt();
				otherStuff.removeTask( modTask ); // removing specified task
				
				break;
			case 5: // edit a task
				otherStuff.printTasks(); // print tasks so user knows what to edit
				
				System.out.println( "Which task would you like to edit?" );
				modTask = keyboard.nextInt();
				
				Task task = otherStuff.getTask( modTask ); // modify specified task
				
				System.out.println( "What would you like to edit?" ); // getting all specific here
				System.out.println( "1. Description" );
				System.out.println( "2. Priority" );
				System.out.println( "3. Category" );
				System.out.println( "4. Location" );
				System.out.println( "5. Due Date" );
				System.out.println( "6. Completed?" );
				modTask = keyboard.nextInt();
				
				switch( modTask ){ // Modify what you want!!
					case 1: // change description
						System.out.print( "New Description: " );
						task.setDescription( input );
						break;
					case 2: // change priority
						System.out.print( "New Priority: " );
						task.setPriority( Short.parseShort( input ) );
						break;
					case 3: // change category
						System.out.print( "New Category: " );
						task.setCategory( Short.parseShort( input ));
						break;
					case 4: // change location
						System.out.print( "New Location: " );
						task.setLocation( input );
						break;
					case 5: // change due date
						System.out.print( "New Due Date: " );
						task.setDate( date );
						break;
					case 6: // change completed status
						System.out.print( "Completed? " );
						task.setCompleted( Boolean.parseBoolean( input ) );
						break;
				}
				break;
			case 6: // search tasks
				System.out.println( "Would you like to search by: " );
				System.out.println( "1. Category" );
				System.out.println( "2. Priority" );
				System.out.println( "3. Due date" );
				System.out.println( "4. Location" );
				System.out.println( "5. Completion" );
				menu = keyboard.nextShort();
				
				// switch in a switch cause that's how I roll...
				switch( menu ){
					case 1: // searching by category
						otherStuff.searchByCategory( menu );
						break;
					case 2: // searching by priority
						otherStuff.searchByPriority( menu );
						break;
					case 3: // searching by due date
						otherStuff.searchByDueDate( date );
						break;
					case 4: // searching by location
						otherStuff.searchByLocation( input );
						break;
					case 5: // searching by completed status
						otherStuff.searchByCompleted( input );
						break;
				}
				
				break;
			case 7: // sort tasks
				// definitely the spiffiest sorting you have ever seen
				otherStuff.orderByPrio();
				// print those amazingly sorted tasks now
				otherStuff.printTasks();
				break;
			case 8: // print tasks
				otherStuff.printTasks();
				break;
			case 9: // for those crazy people not absolutely in love with this program
				System.out.println( "GOODBYE!" );
				keyboard.close(); // closing the keyboard
				System.exit(0); // actually exiting program
		}
	}
}
