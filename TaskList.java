import java.util.ArrayList;
import java.io.*;

/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class TaskList {
	/*
	 * Data:
	 * 
	 * list of tasks 
	 */
	static ArrayList<Task> taskList;
	
	
	
	/*
	 * Operations:
	 * 
	 * Add tasks
	 * remove tasks
	 * get task by index
	 * get task by some other value?
	 * search task by name - return object of type task check
	 * search tasks by priority - check
	 * search tasks by due date - check
	 * search tasks by category - check
	 * search tasks by completion - check
	 * sort by priority - do this, you kinda need to do this for homework, probably a good idea
	 * sort by completion
	 * sort by category
	 * write list to disk - check
	 * read list from disk - check
	 * 
	 */
	/**
	 * Create a new Task List from scratch
	 */
	public TaskList(){
		taskList = new ArrayList<Task>();
	}
	/**
	 * Create a new TaskList from disk, reading from provided filename
	 */
	public TaskList( String filename ) throws FileNotFoundException {
		readFile( filename );
		
	}
	/**
	 * Add the provided task
	 * @param t
	 * @return
	 */
	public boolean addTask( Task t ){
		return taskList.add(t);
		
	}
	/**
	 * Return task at index i. Throws exception if index is Illegal
	 * @param i
	 * @return Task object at index
	 */
	public Task getTask( int i ){
		return taskList.get(i);
		
	}
	/**
	 * Remove the specified task at index i. Throws an exception if index is illegal.
	 * @param i
	 */
	public void removeTask( int i ){
		taskList.remove(i);
	}
	/**
	 * Read list of tasks from filename provided
	 * @param filename
	 * @throws FileNotFoundException 
	 */
	public void readFile( String filename ) throws FileNotFoundException{
		// assume task list is initialized
		Task t;
		taskList.clear(); // remove old tasks
		BufferedReader reader = new BufferedReader( new FileReader(filename) ); 
		
		try{
			while( reader.ready() ){
				t = new Task();
				t.read(reader);
				if( t!= null ){
					taskList.add(t);
				}
			}
			reader.close();
		} catch( IOException e ){
			System.out.println( " IO Exception Encountered: " + e.getMessage() );
		}	
		
	}
	/**
	 * Writes the data to the disk
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void writeFile( String filename ) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter( filename );
		
		for( int i = 0; i < taskList.size(); i++ ){
			taskList.get(i).write( writer );
			/*
			 * EQUIVALENT:
			 * Task foo = taskList.get(i);
			 * foo.write(writer);
			 * 
			 */
		}
		writer.close();
	}
	/**
	 * Searches by the description of a task
	 * @param d
	 * @return
	 */
	public Task serachByDescription( String d ){
		Task t = null;
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getDescription().equals(d) ){
				t = taskList.get(i);
				break;
			}
		}
		return t;
	}
	
	/**
	 * Searches by the Priority of a task
	 * @param p
	 * @return
	 */
	public TaskList searchByPriority( short p ){
		TaskList tL = new TaskList() ;
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getPriority() == p){
				tL.addTask(taskList.get(i));
			}
		}
		return tL;
	}
	/**
	 * Searches by the Due Date of a task
	 * @param d
	 * @return
	 */
	public TaskList searchByDueDate( String d ){
		TaskList tL = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++){
			if( taskList.get(i).getDate().equals(d) ){
				tL.addTask(taskList.get(i));
			}
		}
		return tL;
	}
	/**
	 * Searches by the category of a task
	 * @param p
	 * @return
	 */
	public TaskList seachByCategory( short p ){
		TaskList tL = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++){
			if( taskList.get(i).getCatagory() == p){
				tL.addTask(taskList.get(i));
			}
		}
		return tL;
	}
	/**
	 * Searches by whether a task is completed or not
	 * @param b
	 * @return
	 */
	public TaskList searchByCompletion( boolean b ){
		TaskList tL = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getCompleted() == b ){
				tL.addTask(taskList.get(i));
			}
		}
		return tL;
	}
	
	/**
	 * Print all tasks in the task list.
	 */
	public void printTasks() {
		System.out.println( "Tasks: " );
		for( int i = 0; i < taskList.size(); i++ ) {
			System.out.print( taskList.get(i).toString() );
			System.out.println( "-----" );
		}
		System.out.println( "EOL" );
	}
	/**
	 * This method sorts the task list by the short associated with it's priority
	 * @param t
	 * @param s
	 */
	public void sortByPriority(Task t){
		/*
		int startScan, minIndex, minValue, index;
		
		for( startScan = 0; startScan < (taskList.size() -1); startScan ++){
			
			minIndex = startScan;
			minValue = taskList[index];
			*/
		taskList.sort(t.compareTo(t) < t.getPriority() super E > t.compareTo(t))); // this is the problem, the code up top is incase this isn't what i'm supposed to do
		//;sort(Comparator<? super E> c)
		
	}
	
	
}
