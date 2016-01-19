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
	public TaskList( String filename ) throws FileNotFoundException {
		readFile( filename );
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
	 
	public Task searchByName( String n ) {
		Task foo = null;
		
		for( int i = 0; i < taskList.size(); i++ ) {
			// ??    if( taskList.get(i).getName().equals(n) ) {
				 foo = taskList.get(i);
				 break;	
		}
	}
	
	public TaskList searchByPriority( short p ) {
		TaskList foo = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ) {
			 if( taskList.get(i).getPriority() == p ) {
				 foo.addTask(taskList.get(i));
			 }
		}
		return foo;
	}
	
	
	 
	 public Task searchByDueDate( Date d ) {
	 	 Task foo = null;
		 
		 for( int i = 0; i < taskList.size(); i++ ) {
			 if( taskList.get(i).getDueDate().equals(d) ) {
				 foo = taskList.get(i);
				 break;
			 }
		 }
		 
		 return foo;
	 }
	public Task searchByDescription( String d ) {
		 Task foo = null;
		 
		 for( int i = 0; i < taskList.size(); i++ ) {
			 if( taskList.get(i).getDescription().equals(d) ) {
				 foo = taskList.get(i);
				 break;
			 }
		 }
		 
		 return foo;
	}
	
	 /**
	  * Read list of tasks from filename provided.
	  * @param filename Filename to read
	  */
	private void readFile( String filename ) throws FileNotFoundException {
		// asssume that taskList is initialized
		taskList.clear(); // remove all old tasks
		
		BufferedReader reader = new BufferedReader( new FileReader( filename ) );
		
		try{
			reader.close();
		} catch( IOException e ) {
			System.out.println( "Cannot close file: " + e.getMessage() );
		}
	}
	
	public void writeFile( String filename ) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter( filename );
		for( int i = 0; i < taskList.size(); i++ ) {
			taskList.get(i).write( writer );
			
			
			
			
			
			/*
			 * EQUIVALENT:
			 * Task foo = taskList.get(i);
			 * foo.write(writer);
			 */
		}
		writer.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
