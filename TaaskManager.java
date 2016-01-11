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
		
		System.out.println( "Welcome to Task Manager! " );
		
		/*
		 * ERASE FROM  HERE TO EXIT WHEN DONE
		 */
		Task foo = new Task();
		foo.setDescription("Test Task ");
		try {
			//what we want to try that might throw an exception 
		foo.setPriority((short)12);
		} catch( Exception e){
			//What to do if we catch an exception
			System.out.println( "Error setting priority: " + e.getMessage());
			//System.exit(-1);// exits program
		}
		// time passes.........
		
		//System.out.println( " Task info "  );
		//System.out.print( "\tTask " + description.getDescription );
		//System.out.println( "\tTask: " + p.getPriority);
		/*
		 * STOP HERE
		 */
		System.exit(0);
	}

}

