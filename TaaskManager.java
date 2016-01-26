import java.io.FileNotFoundException;
import java.util.Date;
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
		 * menu
		 * read tasks or add tasks
		 * add task
		 * save file
		 * create a new task list and add to the file
		 * you could ask for file name, ask for over ride 
		 * add search menu items
		 * FINALLY WARNING VERY HARD
		 * implement the sort by priority so that the user can print out the lists of tasks in priority order
		 */
	    char goOn;
		String d;
		short p;
		boolean b = false;
		Date dDate = new Date();
		Task t = new Task();
		Scanner keyboard = new Scanner(System.in);
		String filename = "Task file";
		TaskList tL = new TaskList();
		System.out.println( "Welcome to Task Manager! " );
		
		do{
			
			
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
			System.out.println( "Please enter a due date for your task " );
			d = keyboard.
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
		
			
			
			try{
				tL.writeFile( filename );
			}catch (FileNotFoundException e ){
				System.out.println( " File \"" + filename + "\" not found!" );
				System.out.println( "Dying..." );
				e.printStackTrace();
				System.exit(-1);
			}
			
			tL = new TaskList();
			
			System.out.println( "Before read: " );
			tL.printTasks();
			
			try{
			tL.readFile( filename );
			} catch( FileNotFoundException e ){
				System.out.println( "file \"" + filename + "\" not found!" );
				System.out.println("Dying... " );
				
			}
			System.exit(0);
}
		
}


