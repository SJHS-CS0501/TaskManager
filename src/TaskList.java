import java.util.*;
import java.io.*;

/**
 * TaskList contains a list of tasks and operations for that list.
 * @author Julianna Nichols
 */
public class TaskList {
	
	/*
	 * data:
	 * 
	 * - list of tasks	
	 */
	
	ArrayList<Task> taskList;
	
	/*
	 * Homework!
	 * methods that perform searches
	 * each method should return 
	 */
	
	/*
	 * operations:
	 * 
	 * - add/remove tasks
	 * - get task by index
	 * - get task by some other value?
	 * - search by name
	 * - search by priority
	 * - search by due date
	 * - search by completion
	 * - sort by priority
	 * - sort by category
	 * - sort by due date
	 * - sort by completion
	 * - write/read list to/from disk
	 */
	/**
	 * Create new TaskList from scratch
	 */
	public TaskList() {
		taskList = new ArrayList<Task>();
	}
	
	/**
	 * Create a new TaskList from disk, reading from provided filename
	 * @param filename String filename
	 */
	public TaskList( String filename ) throws FileNotFoundException {
		readFile( filename );
	}
	
	/**
	 * Add task to list
	 * @param t
	 * @return true if add succeeded
	 */
	public boolean addTask( Task t ) {
		return taskList.add(t);
	}
	
	/**
	 * Return task at index i. Throws exception if index is illegal.
	 * @param i, index of task
	 * @return Task object at index, NULL if not found
	 */
	public Task getTask( int i ) {
		return taskList.get(i);
	}
	
	/**
	 * Remove specified task at index i. Throws exception if index is illegal.
	 * @param i, index of task to remove
	 */
	public void removeTask( int i ) {
		taskList.remove(i);
	}
	
	/**
	 * Read list of tasks from filename provided
	 * @param filename Filename to read
	 */
	private void readFile( String filename ) throws FileNotFoundException {
		//assume taskList is initialized
		taskList.clear(); //remove all old tasks
		
		BufferedReader reader = new BufferedReader( new FileReader( filename ) );
		
		try {
			reader.close();
		} catch( IOException e ) {
			System.out.println( "Cannot read file: " + e.getMessage() );
		}
	}
	
	/*
	public Task searchByDescription( String d ) {
		Task foo;
		foo = taskList.get(0);
		return foo;
		
		prob need loop to go through each task and see which matches:
		for( int i = 0; i< taskList.size(); i++ ) {
			if( taskList.get(i).getDescription().equals(d) ) {
				foo = taskList.get(i);
				break;
			}
		}
	*/
	
	/**
	 * Write list of tasks from filename provided
	 * @param filename Filename to read
	 */
	public void writeFile( String filename ) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter( filename );
		
		for( int i = 0; i < taskList.size(); i++ ) {
			taskList.get(i).write( writer );
			/*
			 * Equivalent to:
			 * Task foo = taskList.get(i):
			 * foo.write(writer);
			 */
		}
		
		writer.close();
	}
	
}
