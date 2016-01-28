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


	
	//* write methods to search tasks, should all return a type task
	
	//public TaskList searchByDescription( String d ){
	//	TaskList search = new TaskList();
		
	//	for( int i = 0; i < taskList.size(); i++ ){
	//		if( taskList.get(i).getDescription().equals(d)) {
	//			search.addTask( taskList.get(i) );
	//		}
	//	}
	//	
	//	return search;
	//}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public TaskList searchByCategory( short c ){
		TaskList search = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getCategory() == c ) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search;
	}
	
	public TaskList searchByPriority( short p ){
		TaskList search = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getPriority() == p) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search;
	}
	
	public TaskList searchByDueDate( Date dD ){
		TaskList search = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getDate().equals(dD)) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search;
	}
	
	public TaskList searchByLocation( String l ){
		TaskList search = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getDescription().equals(l)) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search;
	}
	
	public TaskList searchByCompleted( String cP ){
		TaskList search = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getDescription().equals(cP)) {
				search.addTask( taskList.get(i) );
				break;
			}
		}
		
		return search;
	}
	
	
	
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
	public TaskList( String fileName ) throws FileNotFoundException {
		readFile( fileName );
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

	
	
	
	
	
	public Task editTask( int i ){
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Read list of tasks from file name provided.
	 * @param fileName File name to read
	 */
	public void readFile( String fileName ) throws FileNotFoundException{
		Task t;
		
		// assume that taskList is initialized
		taskList.clear(); // remove all old tasks
		
		BufferedReader reader = new BufferedReader( new FileReader( fileName) );
		
		try{
			while( reader.ready() ){
				t = new Task();
				t.read( reader );
				if( t != null ){
					taskList.add( t ) ;
				}
			}
			
			reader.close();
		} catch( IOException e ){
			System.out.println( "Cannot close file: " + e.getMessage() );
		}
		
		
	}
	
	public void writeFile( String fileName ) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter( fileName );
		for( int i = 0; i < taskList.size(); i++ ){
			taskList.get(i).write( writer );
			/*
			 * EQUIVALENT
			 * Task foo - taskList.get(i);
			 * foo.write(writer);	
			 */
			
		}	
		writer.close();
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
	
	
}
