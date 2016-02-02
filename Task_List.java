import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 */

/**
 * @author Ryley
 *Contains a list of tasks and operations for that list
 */


public class Task_List {

	PrintWriter writer;
	/*
	 * Data:
	 * -list of tasks
	 * -Buffered reader
	 * 
	 * Data Structure: Array list
	 * 
	 * 
	 */ 
	
	private ArrayList<Task> tasklist;
	
	 /* 
	 * Operations:
	 * add tasks
	 * remove task
	 * search task by priority, due date, completion, category, description
	 * Sort by priority, due date, completion, category, description
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
	 * @throws IOException 
	 */

	public Task_List(String fileName) throws FileNotFoundException{
	try {
		readFile(fileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
	 * @throws IOException 
	 */
	public void readFile(String filename) throws IOException{
	
		Task t;
		tasklist.clear();// clears task list
		
		
		// assumes that the task list is initialized
		BufferedReader reader = new BufferedReader( new FileReader(filename));
		//}catch( FileNotFoundException e){
		//	System.out.println("No file has been created yet.\n Restart and try option 2");
		//}
				try{
		while(reader.ready()){
			
			
			t= new Task();
			t.read(reader);
			if(t!= null){
				tasklist.add(t);
			}
		}
				} catch(IOException e){
					System.out.println("Cannot close file" + e.getMessage());
				
				}
				
				
				reader.close();
	}
	
	/**
	 * Writes to file
	 * @param filename
	 * @throws IOException 
	 */
	public void writeFile( String filename)throws IOException{
		writer = new PrintWriter( new BufferedWriter(new FileWriter(filename)));
		
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
			if(tasklist.get(i).getDescrition().equals(d) ){
				foo = tasklist.get(i);
			}break;
		}
		
		if(foo == null){
			System.out.println("\nSORRY, NO TASK WAS FOUND WITH THAT DEASCRIPTION");
		}
		System.out.println(foo);
		return foo;
		//Replace or fail
	}
	
	/**
	 * Search by location
	 * @param d
	 * @return
	 */
	public Task searchByLocation(String d){
		Task foo= null;
		
		for(int i = 0; i<tasklist.size(); i++){
			if(tasklist.get(i).getLocation().equals(d) ){
				foo = tasklist.get(i);
			}break;
		}
		
		if(foo == null){
			System.out.println("\nSORRY, NO TASK WAS FOUND WITH THAT Location");
		}
		System.out.println(foo);
		return foo;
		//Replace or fail
	}
	
	/**
	 * Search by Priority
	 * @param a
	 * @return
	 */
	public Task searchByPriority(short a){
		
		//Task_List 
		Task foo = null; 
		//= new Task_List();
		for(int i = 0; i< tasklist.size(); i++){
			
			if(tasklist.get(i).getPrority() == a ){
				foo = tasklist.get(i);
				//.addTask
			}break;
		}
		System.out.println(foo);
		return foo;
	}
	
	/**
	 * Search by Date
	 * @param d
	 * @return
	 * @throws ParseException 
	 */
	public Task searchByDate( String d) throws ParseException{
		
		Task foo = null;
		
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		
		for(int i = 0; i<tasklist.size(); i++){
			foo = tasklist.get(i);
			if(foo.getDate().equals(d) ){
				return foo; 
			}break;
		}
		
		if(foo == null){
			System.out.println("\nNO RESULTS FOUND ");
		}
		
		System.out.println(foo);
		return foo;
	}
	
	/**
	 * Search by Category
	 * @param a
	 * @return
	 */
	public Task searchByCatagory(short a ){
		
		Task foo = null;
		
		for(int i = 0; i<tasklist.size(); i++){
			if(tasklist.get(i).getCatagory() == a ){
				foo = tasklist.get(i);
			}break;
		}
		
		
		System.out.println(foo);
		return foo;
	}
	
	/**
	 * Search by Completion
	 * @param d
	 * @return
	 */
	public Task searchByCompletion(boolean d){
		
		Task foo = null;
		
		for(int i = 0; i<tasklist.size(); i++){
			if(tasklist.get(i).getComplete() == d ){
				foo = tasklist.get(i);
			}break;
		}
		
		System.out.println(foo);
		return foo;
	}
	
	/**
	 * Print all tasks in the task list.
	 */

	public void printTasks() {
		System.out.println( "\nTasks:" );
		for( int i = 0; i < tasklist.size(); i++ ) {
			System.out.print( tasklist.get(i).toString() );
			System.out.println( "-----" );
		}
		System.out.println( "EOL" );

	}
	
	public void sortByPriority(){
		
		
		
		
		
		
		
		
		
		//for(int l = 0; l < tasklist.size(); l++){
			
		//}
		Comparator<Task> compare = new Comparator<Task>(){
		public int compare(Task p1, Task p2){
			return(p1.getPrority() - p2.getPrority());
		}
		
		};
		
		Collections.sort(tasklist, compare);
		
		System.out.println("Sort by priority");
		for(Task priority :tasklist){
			System.out.println("Priority:"
					+ priority.getDescrition() +
					" " + priority.getPrority()+
					" " + priority.getComplete());
			
			//rename comparePriority
		}
	
	
	} 
	
}



