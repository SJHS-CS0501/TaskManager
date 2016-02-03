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
		taskList = new ArrayList<Task>(); // creates new array list of task object, a task list
	}
	/**
	 * Create a new TaskList from disk, reading from provided filename
	 */
	public TaskList( String filename ) throws FileNotFoundException {
		readFile( filename );// reads the file 
		
	}
	/**
	 * Add the provided task
	 * @param t
	 * @return
	 */
	public boolean addTask( Task t ){
		return taskList.add(t); // adds the task to the task list
		
	}
	/**
	 * Return task at index i. Throws exception if index is Illegal
	 * @param i
	 * @return Task object at index
	 */
	public Task getTask( int i ){
		return taskList.get(i); // returns a task for a given index
		
	}
	/**
	 * Remove the specified task at index i. Throws an exception if index is illegal.
	 * @param i
	 */
	public void removeTask( int i ){
		taskList.remove(i); // removes a task
	}
	/**
	 * Read list of tasks from filename provided
	 * @param filename
	 * @throws FileNotFoundException 
	 */
	public void readFile( String filename ) throws FileNotFoundException{
		// assume task list is initialized
		Task t; // variable for tasks 
		taskList.clear(); // remove old tasks
		BufferedReader reader = new BufferedReader( new FileReader(filename) ); // creates a new buffered reader
		
		try{
			while( reader.ready() ){ // checks to see if the file is ready to be read 
				t = new Task(); // creates a new task
				t.read(reader); // reads a file 
				if( t!= null ){
					taskList.add(t); // adds a task to the task list
				}
			}
			reader.close(); // closes the readere
		} catch( IOException e ){
			System.out.println( " IO Exception Encountered: " + e.getMessage() ); // if the program crashes, prints this message of the error
		}	
		
	}
	/**
	 * Writes the data to the disk
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void writeFile( String filename ) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter( filename ); // creates a new print writer
		// Basically this is totally useless, all it does is save the last task and destroys the rest... why...
		for( int i = 0; i < taskList.size(); i++ ){
			taskList.get(i).write( writer ); // writes the task list to the file
		
		}
		
		writer.close();// closes to writer
	
	}
	/**
	 * Searches by the description of a task
	 * @param d
	 * @return
	 */
	public Task serachByDescription( String d ){
		Task t = null; // sets task to null
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getDescription().equals(d) ){
				t = taskList.get(i);// sets t to a task for a given index
				break;
			}
		}
		return t;
	}
	
	/**
	 * Searches by the Priority of a task
	 * @param p
	 * @return tL
	 */
	public TaskList searchByPriority( short p ){
		TaskList tL = new TaskList() ; //creates a new task list
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getPriority() == p){
				tL.addTask(taskList.get(i));// adds a task to the task list of a given index
			}
		}
		return tL;
	}
	/**
	 * Searches by the Due Date of a task
	 * @param d
	 * @return tL
	 */
	public TaskList searchByDueDate( String d ){
		TaskList tL = new TaskList(); // creates a new task list
		
		for( int i = 0; i < taskList.size(); i++){
			if( taskList.get(i).getDate().equals(d) ){
				tL.addTask(taskList.get(i)); // adds a task to the task list of a given index
			}
		}
		return tL;
	}
	/**
	 * Searches by the category of a task
	 * @param p
	 * @returntL
	 */
	public TaskList seachByCategory( short p ){
		TaskList tL = new TaskList(); // creates a new task list
		
		for( int i = 0; i < taskList.size(); i++){
			if( taskList.get(i).getCatagory() == p){
				tL.addTask(taskList.get(i)); // adds a task to the task list of a given index
			}
		}
		return tL;
	}
	/**
	 * Searches by whether a task is completed or not
	 * @param b
	 * @return tL
	 */
	public TaskList searchByCompletion( boolean b ){
		TaskList tL = new TaskList(); // creates a new task list 
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getCompleted() == b ){
				tL.addTask(taskList.get(i)); // adds a task to the task list of a given index
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
		int ctr = 0;
		/*
		int startScan, minIndex, minValue, index;
		
		for( startScan = 0; startScan < (taskList.size() -1); startScan ++){
			
			minIndex = startScan;
			minValue = taskList[index];
			*/
		//taskList.sort(t.compareTo(t) < t.getPriority() super E > t.compareTo(t))); // this is the problem, the code up top is incase this isn't what i'm supposed to do
		//;sort(Comparator<? super E> c)
		//taskList.sort(t.compareTo < t.getPriority());
		
		//for( (taskList.size -1); ctr++; ){
		taskList.sort(Task::compareTo); // calls the compareTo method 
		taskList.forEach(System.out::println ); // prints the tasks in the task list
		}
	
	
}
