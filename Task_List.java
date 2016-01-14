import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
	public Task_List(String fileName) throws FileNotFoundException{
	readFile(fileName);
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
	 * @param filename (Filename to read)
	 */
	private void readFile(String filename) throws FileNotFoundException{
	
		tasklist.clear();// clears task list
		
		// assumes that the task list is initialized
				BufferedReader reader = new BufferedReader( new FileReader(filename));
		
				try{
		reader.close();
				} catch(IOException e){
					System.out.println("Cannot close file" + e.getMessage());
				
				}
					
	}
	
	/**
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void writeFile( String filename)throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(filename);
		
		for(int i = 0; i< tasklist.size(); i++) {
			tasklist.get(i).write(writer);
			
			/*
			 * Equivalent:
			 * Task foo = tasklist.get(i);
			 * foo.write(writer);
			 */
		}
		
			writer.close();
			}
	
	public Task searchByDescription(String d){
		Task foo= null;
		
		for(int i = 0; i<tasklist.size(); i++){
			if(tasklist.get(i).getDescription().equals(d) ){
				foo = tasklist.get(i);
			}break;
		}
		
		return foo;
		//Replace or fail
	}
}

