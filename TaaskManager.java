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
		boolean goOn = true;
		String d;
		short p;
		boolean b = false;
		Date dDate;
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
			
			//System.out.println( "Please enter a due date for your task " );
			//not sure how to do this, parse doesn't seem to be working, or at least i can't figure it out
			System.out.print( "Please enter a location for your task " );
			d = keyboard.nextLine();
			t.setLocation(d);
			tL.addTask(t);
			System.out.print( " Would you like to go on? Press 'y' to go on" );
			d = keyboard.nextLine().toLowerCase();
			
			if( d != "y"){
				goOn = false;
			}
			}while( goOn == true );
		
			tL.printTasks();
			
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


