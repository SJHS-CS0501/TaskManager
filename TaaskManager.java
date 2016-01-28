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
	    char goOn = 0;
		String d;
		short p;
		boolean b = false;
		Date dDate = new Date();
		DateFormat format = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		Task t = new Task();
		Scanner keyboard = new Scanner(System.in);
		String filename = "Task file";
		File userFile = new File( filename );
		TaskList tL = new TaskList();
		int selection = 0;
		Date userDate = new Date();
		
		
		System.out.println( "Welcome to Task Manager! " );
		menuDisplay(selection);
		
		do{
			System.out.println( " Please enter a selection " );
			selection = keyboard.nextInt();
			keyboard.nextLine();
			switch( selection ){
			case 0: 
				tL.printTasks();
				break;
			case 1:
				try {
					tL.readFile(filename);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("File not found, programmin is crashing" );
					e1.printStackTrace();
				}
				break;
			case 2:
				do{
				tL.addTask(t);
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
				System.out.print( "Please enter a location for your task " );
				d = keyboard.nextLine();
				t.setLocation(d);
				tL.addTask(t);
				System.out.print( " Would you like to go on? Press 'y' to go on" );
				goOn = keyboard.nextLine().toLowerCase().charAt(0);
				tL.printTasks();
				if( goOn != 'y'){
					try {
						tL.writeFile(filename);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}while( goOn == 'y');
				break;
			case 3:
				System.out.print("Please enter a filename to load: " );
				filename = keyboard.nextLine();
				if( userFile.exists()){
					System.out.println( "The file you entered DOES exist, are you sure you want to overwrite the file? Enter y to overwrite" );
					goOn = keyboard.nextLine().toLowerCase().charAt(0);
					if(goOn != 'y'){
						 System.out.println( "Thank you, file will NOT be overwritten, goodbye" );
						 break;
					}
					
					break;
				}
			case 4:
				System.out.println( " Please enter the description of the task you would like to find " );
				d = keyboard.nextLine();
				
				tL.serachByDescription(d);
				System.out.println(t.toString());
				
			
			case 5:
				System.exit(0);
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
		public static void menuDisplay( int selection ){
			
			System.out.println( "Would you like to: " );
			System.out.println( "1. Read the tasks from the file" );
			System.out.println( "2. Add task to existing task list" );
			System.out.println( "3. Load new file" );
			System.out.println( "4. Create new task list" );
			System.out.println( "5. Search for specific tasks" );
			System.out.println( "6. Exit " );
		
		}
}


