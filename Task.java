import java.text.DateFormat;
import java.text.ParseException;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 * Task object containing information on a single task
 * 
 * @author David Herr
 *
 */
public class Task implements Comparable {
// can delete things 
	/*
	 * Data fields:
	 * Priority - check
	 * Due Date - check
	 * Category - check
	 * Description - check
	 * location -check
	 * completed - check
	 *
	 */
	private short priority; // variable for priority of the task
	private static Date dueDate; // variable for due date of the task 
	private short category; // variable for the category of the task
	private String description; // variable for the description of the task
	private String location; // variable for the location of the task
	private boolean completed; // variable for the completion of the task, either true or false
	Scanner keyboard = new Scanner(System.in); // creates new Scanner object
	private static String utilString; // variable for utility purposes like for parsing out date
	private char trFa; // variable for true or false, to be used with boolean completed
	
	/*
	 * priorities - bounds check
	 * use if statement to compare
	 */
	public static final short PRIO_HIGH = 1; // variable for high priority
	public static final short PRIO_MED = 2;// variable for medium priority
	public static final short PRIO_LOW = 3;// variable for low priority
	public static final short PRIO_UNDEF = 0;// default variable if priority does not equal 1,2, or 3
	
	
	/*
	 * categories -  bounds check
	 */
	
	public static final short CAT_UNDEF = 0;// default category
	public static final short CAT_OTHER = 1; // category for other tasks not listed
	public static final short CAT_SCHOOL = 2;// category for school tasks
	public static final short CAT_PERSONAL = 3;// category for personal tasks
	public static final short CAT_CHORE = 4;// category for chores
	public static final short CAT_WORK = 5;// category for work tasks
	
	/*
	 * Methods:
	 * Empty Constructor- check!
	 * accessors all fields
	 * mutators all fields
	 * toString
	 * equals method
	 * Remember to relook over the Date java doc, really good information that you will probably need
	 * 
	 */
	/**
	 * Constructor
	 */
	Task(){
		
	}
	/**
	 *Method to set the value of priority 
	 * @param priority
	 */
	
	public void setPriority( short p ){
	/*	System.out.print( " Please enter a catagory for your task between one and five" 
		+ "1 = high, 2 = medium, and 3 = low priority " );
		priority = keyboard.nextShort();
		if( priority == 1 ){
			priority = PRIO_HIGH;
		}else{
			if( priority == 2){
			priority = PRIO_MED;
			}else{
				if( priority == 3){
					priority = PRIO_LOW;
				}else{
					priority = PRIO_UNDEF;
				}
				
			}
		}
		*/
		if( p < 0|| p > 3){
			throw new IllegalArgumentException( " Invalid priority " ); // prints this message if the user inputs an invalid method
		}
		priority = p; // sets priority equal to p
	}
	/**
	 * returns priority to main
	 * @return
	 */
	public short getPriority(){
		return priority; 
	}
	/**
	 * This method determines the priority name associated with each priority number for a task
	 * @return
	 */
	public String getPriorityName(){
		
		String pName = null; // sets string pName (priority name) equal to null
		
		switch( priority ){ // switches to the priority number ( short ) 
		
			case 0:
			pName = "Undefined"; 
			break;
		case 1:
			pName = "High";
			break;
		case 2:
			pName = "Medium";
			break;
		case 3:
			pName = "Low";
			break;
		default:
			pName = "ILLEGAL VALUE";
			break;
		
	}
		return pName;
	}
/**
 * This method compares the priority to sort it 
 * @param t
 * @return
 */
public int compareTo( Task t ){
		
		if( priority < t.getPriority() ){
			return 1;
	}else if(priority > t.getPriority()){
		return -1;
	} else {
		return 0;
	}
}
	/**
	 * Sets the value of dueDate by using dDateStrng and .parse 
	 * @param dueDate
	 * @param dDateStrng
	 */
	public  void setDate( Date d ){
	/*	System.out.println( " Please a due date for your task " );
		dDateStrng = keyboard.nextLine();
		
		DateFormat.parse( dDateStrng );
		*/
		dueDate = d;
	}
	
	/**
	 * returns the value of dueDate to main
	 * @return
	 */
	public Date getDate( ){
		return dueDate;
	}
	/**
	 * sets the value of category
	 * @param category
	 */
	public void setCatagory( short c ){
		/* System.out.print( " Please enter a priority for your task between one and three" 
		+ "1 = other, 2 = school, 3 = personal, four = chores, and five = work. " );
		category = keyboard.nextShort();
		if( category == 5 ){
			category = CAT_WORK;
		}else{
			if( category == 4){
			category = CAT_CHORE;
			}else{
				if( category == 3){
					category = CAT_PERSONAL;
				}else{
					if( category == 2){
					category = CAT_SCHOOL;
					}else{
						if( category == 1){
						category = CAT_OTHER;
						}else{
						category = CAT_UNDEF;
						}
					}
				}
			}
		}
		*/
		if( c < 0|| c > 5){

			throw new IllegalArgumentException( " Invalid category " ); // prints this message if the user inputs an invalid category
			


		}
		category = c;
	}
	
	/**
	 * This method 
	 * @return
	 */
	public String getCategoryName(){
		String cName = null;
		switch( category ){ // switches to the category number (short) associated with each category
		case 0:
			cName = "Other";
			break;
		case 1:
			cName = "School";
			break;
		case 2:
			cName = "Personal";
			break;
		case 3:
			cName = "Chores";
			break;
		case 4:
			cName = "Work";
			break;
		default:
			cName = "ILLEGAL VALUE";
			break;
			
		}
		return cName;
	}

	/**
	 * returns the value of category to main
	 * @return
	 */
	public short getCatagory(){
		return category;
	}
	/**
	 * Sets the value of description, no character checking is needed
	 * @param description
	 */
	public void setDescription( String d ){
		/*System.out.println( " Please enter a basic description of your task. " );
		description = keyboard.nextLine();
		*/
		description = d;
	}
	/**
	 * Returns the value description to main
	 * @return
	 */
	public String getDescription(){
		return description;
	}
	/**
	 * Sets the value of location, no character checking was used, although it can be added
	 * @param location
	 */
	public void setLocation( String l ){
		/*System.out.println( " Please enter the location for your task " );
		location =  keyboard.nextLine();
		*/
		location = l;
	}
	/**
	 * returns location to main
	 * @return
	 */
	public String getLocation(){
		return location;
		
	}
	/**
	 * Sets the value of completed 
	 * @param completed
	 */
	public void setCompleted( boolean b ){
		
		completed = b;
	}
	
	/**
	 * returns completed as either true or false to main
	 * @return
	 */
	public boolean getCompleted(){
		return completed;
	}
	
	
	
	/**
	 * write a task to the provided PrintWriter object
	 * @param writer
	 */
	public void write( PrintWriter writer ){
		// write data separated by tabs
		StringBuilder s = new StringBuilder();
		
		
		/*
		private short priority; // variable for priority of the task
		private static Date dueDate; // variable for due date of the task 
		private short category; // variable for the category of the task
		private String description; // variable for the description of the task
		private String location; // variable for the location of the task
		private boolean completed; // variable for the completion of the task, either true or false
		s.append( variable ) converts variables to a string 
		 */
		s.append( priority );
		s.append("\t" );
		if( dueDate != null ){
		s.append( dueDate.toString() );
		}
		s.append( "\t" );
		s.append( category );
		s.append( "\t" );
		s.append( description );
		s.append( "\t" );
		s.append( location );
		s.append( "\t" );
		s.append( completed );
		
		// Ok, write that bad boy
		writer.println( s );
		
	}
	/**
	 * Read a task from disk using the provided BufferedReader
	 * @param reader
	 * @return read task or return null if not read
	 */
	public Task read( BufferedReader reader ){
		
		Task t = new Task();// creates a new task
		String line = null; // creates line and sets it to null
		String [] results; // creates an array for the results of the reading
		try{
			line = reader.readLine();// sets line to whatever is read 
		}catch(IOException e){
			System.out.println( "Cannot read file: " + e.getMessage()); // if the program cannot read the file, this method is printed
			t = null;
		}
		
		results = line.split("\t"); // splits the results so that it matches the regex
		
		for( int ctr = 0; ctr< results.length; ctr++ ){
			System.out.println(  results[ctr] ); // prints the results
			
		}
		
		/*
		private short priority; // variable for priority of the task
		private static Date dueDate; // variable for due date of the task 
		private short category; // variable for the category of the task
		private String description; // variable for the description of the task
		private String location; // variable for the location of the task
		private boolean completed; // variable for the completion of the task, either true or false
		 */
		
		t.setPriority( Short.parseShort(results[0])); // sets priority using the parsed short
		try {
		t.setDate( DateFormat.getDateInstance().parse(results[1]) ); // sets date using the date formatted into the date
		} catch(ParseException e) {
			System.out.println( "Could not parse date. Setting to null." );
		}
		t.setCatagory(Short.parseShort(results[2]));// sets priority using the parsed short 
		t.setDescription(results[4]);// sets priority using the parsed description
		t.setLocation(results[4]);// sets priority using the location
		t.setCompleted(Boolean.parseBoolean(results[5]));// sets priority using the completed
		return t;
	}
	/**
	 * This method converts everything to a string 
	 * @return s
	 */
	public String toString() {
		  StringBuilder s = new StringBuilder();
		  s.append( "Description: " + description + "\n" );
		  s.append( "Priority: " + getPriorityName() + "\n" );
		  s.append( "Category: " + getCategoryName() + "\n" );
		  if( dueDate != null ) {
		    s.append( "Due Date: " + dueDate.toString() + "\n" );
		  }
		  s.append( "Location: " + location + "\n" );
		  s.append( "Completed? " + (completed?"Y":"N") + "\n" );
		  return s.toString();
		}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
	
	


