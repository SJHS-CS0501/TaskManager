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
		boolean goOn = true;
		String d;
		short p;
		boolean b = false;
		Date dDate;
		Task t;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println( "Welcome to Task Manager! " );
		
		do{
			
			TaskList.addTask(t);
			System.out.println( " Please enter a desciption for your task " );
			d = keyboard.nextLine();
			Task.
			System.out.println( "Please enter a priority for your task between 1-3 " );
			p = keyboard.nextShort();
			System.out.println( "Please enter a category for your task between 1-5" );
			p = keyboard.nextShort();
			System.out.println( "Please enter a due date for your task " );
			//not sure how to do this, parse doesn't seem to be working, or at least i can't fingure it out
			System.out.println( "Please enter a location for your task " );
			d = keyboard.nextLine();
			while( goOn == true ){
		System.exit(0);
	}

}
	
}

