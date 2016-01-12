/**
 * 
 */
import java.util.*;
import java.io.*;
/**
 * @author Jack Protivnak
 * TaskList contains a list of tasks and operations for that list.
 */
public class TaskList {
	/*
	 * Data:
	 * 
	 * - List of tasks
	 */
	ArrayList<Task> taskList;
	
	
	/*
	 * Operations:
	 * 
	 * - Add tasks
	 * - Remove tasks
	 * - Get task by index
	 * - Get task by some other value?
	 * - Search tasks by name
	 * - Search tasks by priority
	 * - Search tasks by due date
	 * - Search tasks by completion
	 * - Search tasks by category
	 * - Sort by priority
	 * - Sort by due date
	 * - Sort by completion
	 * - Sort by category
	 * - Write list to disk
	 * - Read list from disk
	 */
	
	/**
	 * Create a new TaskList from scratch.
	 */
	public TaskList( ) {
		taskList = new ArrayList<Task>();
	}
	
	/**
	 * Create a new TaskList from disk, reading from provided filename.
	 * 
	 * @param filename String filename
	 */
	public TaskList( String filename ) {
		taskList = readFile( filename );
	}
	
	/**
	 * Add the provided task.
	 * @param t
	 * @return true if add succeeded
	 */
	public boolean addTask( Task t ) {
		return taskList.add(t);
		
	}
	
	/**
	 * Return task at index i. Throws exception if index is illegal.
	 * @param i index of task
	 * @return Task object at index.
	 */
	public Task getTask( int i ) {
		return taskList.get( i );
	}
	 /**
	  * Remove the specified task at index i. Throws an exception if index is illegal.
	  * @param i index of task to remove
	  */
	public void removeTask( int i ) {
		taskList.remove(i);
	}
	 /**
	  * Read list of tasks from filename provided.
	  * @param filename Filename to read
	  * @return Returns created TaskList
	  */
	private TaskList readFile( String filename ) throws FileNotFoundException {
		TaskList l = new TaskList();
		
		BufferedReader reader = new BufferedReader( new FileReader( filename ) );
		
		reader.close();
		return null;
	}
	
	
	
	
	
}
