import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * TaskList contains a list of tasks and operations for that list.
 * @author Ryan Luchs
 * 
 */
public class TaskList {
	/*
	 * Data:
	 * 
	 * - list of tasks
	 */
	
	ArrayList<Task> taskList;
	
	/*
	 * Operations
	 * 
	 * - add tasks
	 * - remove tasks
	 * - search by name
	 * - get tasks by index
	 * - search by priority
	 * - search by due date
	 * - search by completion
	 * - search by category
	 * - sort by priority
	 * - sort by due date
	 * - sort by completion
	 * - sort by category
	 * - write list to disk
	 * - read list from disk
	 */
	
	/**
	 * Create a new TaskList from scratch
	 */
	public TaskList(){
		taskList = new ArrayList<Task>();
	}
	
	/**
	 * Create a new TaskLst from disk, reading from provided filename.
	 * @param filename String filename
	 */
	public TaskList(String filename) throws FileNotFoundException {
		readFile(filename);
	}
	
	/**
	 * Add the provided task.
	 * @param t
	 * @return true if add succeeded
	 */
	public boolean addTask( Task t) {
		return taskList.add(t);
	}

	/**
	 * Return task at index i. Throws exception if index is illegal.
	 * @param i index of task
	 * @return Task object at index.
	 */
	public Task getTask(int i) {
		return taskList.get(i);
	}
	
	/**
	 * Remove the specified task at index i. Throws exception if index is illegal.
	 * @param i index of task to remove
	 */
	public void removeTask(int i) {
		taskList.remove(i);
	}
	
	public Task searchByDescription(String d) {
		Task foo = null;
		
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(d)) {
				foo = taskList.get(i);
				break;
			}
		}
		
		return foo;
	}
	
	/**
	 * Read list of tasks from filename provided. Throws exception
	 * @param filename Filename to read
	 */
	private void readFile(String filename) throws FileNotFoundException {
		//assume that taskList is initialized
		taskList.clear(); // remove all old tasks

		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		try {
			reader.close();
		} catch(IOException e) {
			System.out.print("Cannot close file: " + e.getMessage());
		}
	}
	
	/**
	 * @param filename Filename to write
	 */
	public void writeFile(String filename) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(filename);
		for(int i = 0; i < taskList.size(); i++) {
			taskList.get(i).write(writer);
		}
		writer.close();
	}
}
