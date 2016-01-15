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
	
	/**
	 * Search through tasks based on their description
	 * @param d
	 * @return foo
	 */
	public TaskList searchDescription( String d ) {
		TaskList foo = new TaskList();
		
		for( int i = 0; i< taskList.size(); i++ ) {
			if( taskList.get(i).getDescription().equals(d) ) {
				foo.addTask(taskList.get(i) );
			}
		}
		return foo;
	}	
	
	/**
	 * Search through tasks based on their category	
	 * @param d
	 * @return foo
	 */
	public TaskList searchCategory( short c ) {
		TaskList foo = new TaskList();
		
		for( int i = 0; i< taskList.size(); i++ ) {
			if( taskList.get(i).getCategory() == c ) {
				foo.addTask(taskList.get(i) );
			}
		}
		return foo;
	}	
	
	/**
	 * Search through tasks based on their priority
	 * @param d
	 * @return foo
	 */
	public TaskList searchPriority( short p ) {
		TaskList foo = new TaskList();
	
		for( int i = 0; i< taskList.size(); i++ ) {
			if( taskList.get(i).getPriority() == p ) {
				foo.addTask(taskList.get(i) );
			}
		}
		return foo;
	}
	
	/**
	 * Search through tasks based on their location
	 * @param d
	 * @return foo
	 */
	public TaskList searchLocation( String l ) {
		TaskList foo = new TaskList();
		
		for( int i = 0; i< taskList.size(); i++ ) {
			if( taskList.get(i).getDescription().equals(l) ) {
				foo.addTask(taskList.get(i) );
			}
		}
		return foo;
	}	
		
	/**
	 * Search through tasks based on their completed status	
	 * @param d
	 * @return foo
	 */
	public TaskList searchCompleted( String com ) {
		TaskList foo = new TaskList();
		
		for( int i = 0; i< taskList.size(); i++ ) {
			if( taskList.get(i).getDescription().equals(com) ) {
				foo.addTask(taskList.get(i) );
			}
		}
		return foo;
	}	
		
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
