import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author David Herr
 *
 */
public class TaaskManager {
	/*
	Task manager
	keep list of tasks
	Add and remove task
	Allow user to repriortize 
	Print out list of tasks
	
	List of tasks:
	Read and store on disk - Contact Reader Writer 
	Sort and Search - remember to sync 
	
	Reports:
	List high priority
	List due today/soon
	List all (by date OR by priority 
	
	
	Enter information and gives priority to tasks, and manages them
	

	*/
	/**
	 * This program adds the user interface, and uses the methods used in both the Task and TaskList classes.
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * menu - check
		 * read tasks or add tasks - check
		 * display task- check
		 * save file - check, does it automatically, can be changed
		 * create a new task list and add to the file 
		 * you could ask for file name, ask for over ride - think i did that right
		 * add search menu items - think i did it right?
		 * FINALLY WARNING VERY HARD
		 * implement the sort by priority so that the user can print out the lists of tasks in priority order
		 */
	    char goOn = 0; // variable for determining whether the user wants to through with numerous options in the class, i.e adding tasks
		String d; // variable to store strings
		short p; // variable to store shorts
		boolean b = false; // variable to store booleans
		Date dDate = new Date(); // variable for storing dates
		DateFormat format = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH); // variable for the date format
		Task t = new Task(); // variable for storing tasks
		Scanner keyboard = new Scanner(System.in); // creates new scanner object 
		String filename = "Task file"; // variable for the name of the default file
		File userFile = new File( filename ); // variable for the default file used
		TaskList tL = new TaskList(); // creates new task list
		int selection = 0; // variable for the user's selection in the menu
		Date userDate = new Date(); // creates a new date object
		
		
		System.out.println( "Welcome to Task Manager! " );
		menuDisplay(selection); // displays the menu
		
		do{
			System.out.println( " Please enter a selection " );
			selection = keyboard.nextInt();
			keyboard.nextLine();
			switch( selection ){ // switches to the user's selection in the menu
			case 0: 
				tL.printTasks(); // prints tasks
				break;
			case 1:
				try { // tests the file to make sure the exists and can be found
					tL.readFile(filename); // reads the file 
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("File not found, program is crashing" );
					e1.printStackTrace(); // prints the trace of the program if it does crash
				}
				break;
			case 2:
				do{
				t = new Task(); // creates a new task
				System.out.print( " Please enter a desciption for your task " );
				d = keyboard.nextLine();
				t.setDescription(d); // sets the description for the task
				System.out.print( "Please enter a priority for your task between 1-3 (1 being high, 2 medium, and 3 low) " );
				p = keyboard.nextShort(); 
				t.setPriority(p);// sets the priority for the task
				System.out.print( "Please enter a category for your task between 1-5 (1 being other, 2 school,"
						+ " 3 personal, 4 chores, and 5 work )");
				p = keyboard.nextShort();
				t.setCatagory(p); // sets the category for the task
				keyboard.nextLine();
				System.out.println( "Please enter a due date for your task should in month date, year " );
				d = keyboard.nextLine();
				try { // tests to make sure the date can be parsed
					dDate = format.parse(d); //  formats the date
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot parse date" );
					e.printStackTrace();
				}
				t.setDate( dDate );
				System.out.print( "Please enter a location for your task " );
				d = keyboard.nextLine();
				t.setLocation(d); // sets the location for the task
				tL.addTask(t);
				System.out.print( " Would you like to go on? Press 'y' to go on" );
				goOn = keyboard.nextLine().toLowerCase().charAt(0); // takes the first character of the user's input and puts it in lower case
				tL.printTasks(); // prints tasks
				if( goOn != 'y'){ // if the user did not press y to continue... 
					try { // tries to see if the tasks can be written to file
						tL.writeFile(filename); // writes the tasks to file
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();// if the program crashes, the trace of the program is printed
					}
				}
				}while( goOn == 'y');
				break;
			case 3:
				System.out.print("Please enter a filename to load: " );
				filename = keyboard.nextLine();
				if( userFile.exists()){
					System.out.println( "The file you entered DOES exist, are you sure you want to overwrite the file? Enter y to overwrite" );
					// asks if the user DOES want to overwrite the file
					goOn = keyboard.nextLine().toLowerCase().charAt(0);
					if(goOn != 'y'){
						 System.out.println( "Thank you, file will NOT be overwritten, goodbye" );
						 break;
					}
					
					break;
				}
			case 4:
				System.out.println( " Would you like to save all previous tasks to new task list? (press y for yes " );
				goOn = keyboard.nextLine().toLowerCase().charAt(0);
				if( goOn == 'y' ){
					TaskList tL2 = new TaskList(); // creates new task list
					tL2 = tL; // sets task list one to task list two 
					System.out.println( "New Task List has been created and all previous saves have been added");
				}else{
					TaskList tL2 = new TaskList(); // creates new task list
					System.out.println( "New Task List has been created ");
					
				}
				break;
			
			case 5:
				System.out.println( " Please enter the description of the task you would like to find " );
				d = keyboard.nextLine();
				
				tL.serachByDescription(d); // searches the program for a task with a specific description
				System.out.println(t.toString()); // prints the results of the search
				break;
			case 6:
				System.out.println( "Sorting tasks by priority");
				tL.sortByPriority(t); // sorts tasks by the short number associated with it's priority
				System.out.println("Tasks have been sorted, thank you!");
				try {
					tL.readFile(filename); // reads the file 
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("File not found, program is crashing" );
					e1.printStackTrace(); // if the file is not found, the trace of the program is printed
				}
				break;
			case 7:
				System.exit(0); // exits the program
			}
			/*
			System.out.print( " Please enter a desciption for your task " );
			d = keyboard.nextLine();
			t.setDescription(d);
			System.out.print( "Please enter a priority for your task between 1-3 " );
			p = keyboard.nextShort();
			t.setPriority(p);
			System.out.print( "Please enter a category for your task between 1-5" );
			p = keyboard.nextShort();
			t.setCatagory(p);
			keyboard.nextLine();
			System.out.println( "Please enter a due date for your task should in month date, year " );
			d = keyboard.nextLine();
			try {
				dDate = format.parse(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Cannot parse date" );
				e.printStackTrace();
			}
			t.setDate( dDate );
			//not sure how to do this, parse doesn't seem to be working, or at least i can't figure it out
			
			System.out.print( "Please enter a location for your task " );
			d = keyboard.nextLine();
			t.setLocation(d);
			tL.addTask(t);
			System.out.print( " Would you like to go on? Press 'y' to go on" );
			goOn = keyboard.nextLine().toLowerCase().charAt(0);
			tL.printTasks();
			/*if( d != "y"){
				goOn = false;
			}
			*/
			}while( goOn == 'y' );
		
			
			/*(
			try{
				tL.writeFile( filename );
			}catch (FileNotFoundException e ){
				System.out.println( " File \"" + filename + "\" not found!" );
				System.out.println( "Dying..." );
				e.printStackTrace();
				System.exit(-1);
			}
			*/
			//tL = new TaskList();
			/*
			System.out.println( "Before read: " );
			tL.printTasks();
			
			try{
			tL.readFile( filename );
			} catch( FileNotFoundException e ){
				System.out.println( "file \"" + filename + "\" not found!" );
				System.out.println("Dying... " );
				
			}
			*/
			System.exit(0);
}
	/**
	 * This method displays the options for the program
	 * @param selection
	 */
		public static void menuDisplay( int selection ){
			
			System.out.println( "Would you like to: " );
			System.out.println( "1. Read the tasks from the file" );
			System.out.println( "2. Add task to existing task list" );
			System.out.println( "3. Load new file" );
			System.out.println( "4. Create new task list" );
			System.out.println( "5. Search for specific tasks" );
			System.out.println( "6. Sort tasks by priority " );
			System.out.println( "7. Exit " );
		
		}
}


