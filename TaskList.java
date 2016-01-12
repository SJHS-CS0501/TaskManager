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
	ArrayList<Task> taskList;
	
	
	
	/*
	 * Operations:
	 * 
	 * Add tasks
	 * remove tasks
	 * get task by index
	 * get task by some other value?
	 * search task by name
	 * search tasks by priority
	 * search tasks by due date
	 * search tasks by category
	 * search tasks by completion
	 * sort by priority
	 * sort by completion
	 * sort by category
	 * write list to disk
	 * read list from disk
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
	public TaskList( String filename ){
		taskList = readFile( filename );
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
	 * @return
	 */
	private TaskList readFile( String filename ){
		TaskList l = new TaskList();
		BufferedReader reader = new BufferedReader( new FileReader(filename) ); 
		return null;
	}
}
