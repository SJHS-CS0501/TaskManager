import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * 
 */

/**
 * @author Ryley
 *Contains a list of tasks and operations for that list
 */


public class Task_List {

	/*
	 * Data:
	 * -list of tasks
	 * -Buffered reader
	 * 
	 * Data Structure: Array list
	 * 
	 * 
	 */ 
	
	ArrayList<Task> tasklist;
	
	 /* 
	 * Operations:
	 * add tasks
	 * remove task
	 * search task by priority, due date, completion
	 * Sort by priority, due date, completion, category
	 * write list to disk 
	 * read disk from list
	 * get task by index/value
	 */
	
	/**
	 * Creat a new task list from scratch
	 */
	public Task_List(){
		tasklist = new ArrayList<Task>();
	}
	
	/**
	 * New file from disk
	 * @param fileName
	 */
	public Task_List(String fileName){
		tasklist  = readFile(fileName);
	}
	
	/**
	 * Add task
	 * @param t
	 * @return
	 */
	public boolean addTask(Task t){
		
		return tasklist.add(t);
	}
	
	/**
	 * get task. Throws an exception if it fails
	 * @param i
	 * @return
	 */
	public Task getTask(int i){
		return tasklist.get(i);
	}
	
	
	/**
	 * Remove Task. Throws an exception if it fails
	 * @param i
	 */
	public void reamoveTask(int i){
		
		tasklist.remove(i);
	}
	
	/**
	 * reads file based on the file name
	 * @param filename
	 * @return
	 */
	private Task_List readFile(String filename){
	
		Task_List l = new TaskList()
		
				BufferedReader reader = new BufferedReader( new FileReader(filename));
				
		return null;
		
	}
}

	