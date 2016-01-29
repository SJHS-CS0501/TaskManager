import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

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
	 * - search by description
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
		taskList = new ArrayList<Task>();
		readFile(filename);
	}
	
	/**
	 * Returns length of the TaskList
	 * @return Length of the TaskList
	 */
	public int size() {
		return taskList.size();
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
	
	/**
	 * Remove the specified task. Reference to task should be obtained via searchByDescription() first.
	 * @param t task to remove
	 */
	public void removeTask(Task t) {
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i) == t) {
				taskList.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Searches for s specific task by description.
	 * @param d The task description to search for
	 * @return The reference to the task
	 */
	public Task searchByDescription(String d) {
		Task search = null;
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(d)) {
				search = taskList.get(i);
				break;
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified priority.
	 * @param p The task priority to search for
	 * @return A TaskList containing all of the tasks of the specified priority.
	 */
	public TaskList searchByPriority(short p) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getPriority() == p) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified due date.
	 * @param d The task due date to search for
	 * @return A TaskList containing all of the tasks of the specified due date
	 */
	public TaskList searchByDueDate(Date d) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDueDate().equals(d)) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified completion value of true or false
	 * @param t The task to search for by completion
	 * @return A TaskList containing all of the tasks of the specified completion
	 */
	public TaskList searchByCompleted(boolean t) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getCompleted() == t) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified category
	 * @param t The task category to search for
	 * @return A TaskList containing all of the tasks of the specified category
	 */
	public TaskList searchByCategory(short c) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getCategory() == c) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Sorts the list from highest to lowest priority via insertion sort 
	 */
	public void sortByPriority() {
		//This is an adaptation of the insertion sort pseudo-code found on wikipedia
		
		int j = 0;
		Task t;
		for(int i = 1; i < taskList.size(); i++) {
			j = i;
			while(j > 0 && taskList.get(j-1).getPriority() > taskList.get(j).getPriority()) {
				t = taskList.get(j);
				taskList.set(j, taskList.get(j-1));
				taskList.set(j-1, t);
				j--;
			}
		}
	}
	
	/**
	 * Read list of tasks from filename provided.
	 * @param filename Filename to read
	 */
	public void readFile(String filename) throws FileNotFoundException {
		//assume that taskList is initialized
		taskList.clear(); // remove all old tasks

		BufferedReader reader = new BufferedReader(new FileReader(filename));
		try {
			while(reader.ready()) {
				Task t = new Task();
				t.read(reader);
				if(t != null) {
					taskList.add(t);
				}
			}
			reader.close();
		} catch(IOException e) {
			System.out.print("IOException Encountered: " + e.getMessage());
		}
	}
	
	/**
	 * @param filename Filename to write
	 */
	public void writeFile(String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filename);
		for(int i = 0; i < taskList.size(); i++) {
			taskList.get(i).write(writer);
		}
		writer.close();
	}
	
	/**
	 * Prints TaskList to screen
	 * @param printNumbers True to print list with numbering, false to print list without
	 */
	public void printTasks(boolean printNumbers) {
		for( int i = 0; i < taskList.size(); i++) {
			if(printNumbers) {
			System.out.println("#" + (i + 1));
			}
			System.out.print(taskList.get(i).toString());
		} 
	}
	
}
