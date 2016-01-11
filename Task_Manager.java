/*
 * Task manager program
 * - keep list of task
 * - Allow user to add and remove tasks
 * - Allow user to reprioritize tasks
 * - print out list of tasks
 * 
 * List of tasks:
 * -read and store on disk
 * -sort
 * -search
 * 
 * Reports:
 * -list high priority
 * -List due today/soon
 * -List all (by date OR by priority)
 */

/**
 * 
 * @author Ryley
 *
 */
public class Task_Manager {

	
	public static void main(String[] args){
		//main stuff
		
		System.out.println("Welcom to task manager");
		
		/*
		 * Earase from here to there when done testing task
		 */
		
		Task foo = new Task(); 
		
		
		foo.setDescription("Priority Task");
		
		try{
			// what we do might throw an exception
		foo.setPriority((short) 5);
		
		//System.out.print(Task.getPrority());
		}catch(Exception e){
			//what to do if we catch the aception
			System.out.println("Error setting priority: " + e.getMessage());
			
			//System.exit(-1);
			
		}
		
		//time passes.....
		
		System.out.println("Task info: ");
		System.out.println("\tTask " + foo.getDescrition());
		System.out.println("\t\tPriority: " + foo.getPrority() );
		System.exit(0);
	}
}
