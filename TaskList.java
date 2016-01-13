import java.util.*;
import java.io.*;
/**
 * 
 * @author Isabelle Schroeder
 * TaskList contains a list of tasks and operations for that list.
 */
public class TaskList {
	/*
	 * Data:
	 * 
	 * - lists of tasks
	 * 
	 */
	
	ArrayList<Task> taskList;
	
	
	/*
	 * Operations:
	 * 
	 * - add tasks
	 * - remove tasks
	 * - get task by index
	 * - get task by some other value
	 * - search tasks by name
	 * - search tasks by priority
	 * - search tasks by due date
	 * - search by completion
	 * - search by category
	 * - sort by category
	 * - sort by priority
	 * - sort by due date
	 * - sort by completion
	 * - write list to disk
	 * - read list from disk
	 * 
	 */


	/**
	 * Create a new TaskList from scratch
	 */
	public TaskList() {
		taskList = new ArrayList<Task>();
	}
	
	/**
	 * Create a new TaskList from disk, reading and provided file name.
	 * 
	 * @param filename String fileName
	 */
	public TaskList( String fileName ){
		taskList = readFile( fileName );
	}

	
	/**
	 * Add the provided task.
	 * @param t
	 * @return true if add succeeded
	 */
	public boolean addTask( Task t ){
		return taskList.add(t);
	}
	
	/**
	 * Return task at index i. Throws exception if index is illegal.
	 * @param i index of class
	 * @return Task object at index.
	 */
	public Task getTask( int i ){
		return taskList.get(i);
	}

	/**
	 * Remove the specified task at index i. Throws and exception if index is illegal.
	 * @param i index of task to remove
	 */
	public void removeTask( int i ){
		taskList.remove(i);
	}

	/**
	 * Read list of tasks from file name provided
	 * @param fileName
	 * @return
	 */
	private TaskList readFile( String fileName ) throws FileNotFoundException{
		TaskList l = new TaskList();
		BufferedReader reader = new BufferedReader( new FileReader( fileName) );
		
		reader.close();
		return null;
	}
	
	
	


}
