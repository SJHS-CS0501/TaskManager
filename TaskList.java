import java.util.*;
import java.io.*;
/**
 * 
 * @author Isabelle Schroeder
 * TaskList contains a list of tasks and operations for that list.
 */
public class TaskList {
	
	ArrayList<Task> taskList; // make a brand new taskList
	 
	
	/**
	 * @param c takes a short c
	 * @return returns a TaskList
	 */
	public TaskList searchByCategory( short c ){
		TaskList search = new TaskList(); // new TaskList
		
		/*
		 * for loop says: Search through the taskList and find all tasks with
		 * the category the user asked for.
		 * Use these tasks to make a new TaskList.
		 */
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getCategory() == c ) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search; // returning the new TaskList we just created
	}
	
	/**
	 * 
	 * @param p takes a short p
	 * @return returns type TaskList
	 */
	public TaskList searchByPriority( short p ){
		TaskList search = new TaskList(); // new TaskList
		
		/* 
		 * basically same thing as above, makes a new task list of just the 
		 * tasks with the priority the user asked for
		 */
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getPriority() == p) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search;
	}
	
	/**
	 * 
	 * @param dD takes Date dD
	 * @return returns type TaskList
	 */
	public TaskList searchByDueDate( Date dD ){
		TaskList search = new TaskList();
		
		// all these searches are basically the same just differ in what they're splitting the tasks by
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getDate().equals(dD)) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search;
	}
	
	/**
	 * 
	 * @param l taking String l
	 * @return also returns type TaskList
	 */
	public TaskList searchByLocation( String l ){
		TaskList search = new TaskList();
		
		for( int i = 0; i < taskList.size(); i++ ){
			if( taskList.get(i).getDescription().equals(l)) {
				search.addTask( taskList.get(i) );
			}
		}
		
		return search;
	}
	
	/**
	 * 
	 * @param cP taking a String
	 * @return love to return a TaskList
	 */
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
	 * Sorting the tasks in the taskList array
	 */
	public void orderByPrio(){
		Collections.sort( taskList );
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
	 * @param t takes a Task t
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
	 * Read list of tasks from file name provided.
	 * @param fileName File name to read
	 */
	public void readFile( String fileName ) throws FileNotFoundException{
		Task t;
		
		// assume that taskList is initialized
		taskList.clear(); // remove all old tasks
		
		BufferedReader reader = new BufferedReader( new FileReader( fileName) );
		
		// if the reader is ready then read the new task and add it to the TaskList
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
	
	/**
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
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
		writer.close(); // closing like a responsible programmer
	}
	
	/**
	 * Print all tasks in the task list.
	 * Printy, printy, printy...
	 */
	public void printTasks() {
		System.out.println( "Tasks: " );
		for( int i = 0; i < taskList.size(); i++ ) {
			System.out.print( taskList.get(i).toString() ); // printing each task individually
			System.out.println( "-----" );
		}
		System.out.println( "EOL" );
	}
	
	
}
