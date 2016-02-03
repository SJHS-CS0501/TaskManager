import java.util.Date;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
/**
 * 
 * Task object containing information on a single task.
 * @author Isabelle Schroeder
 *
 */
public class Task implements Comparable<Task> {
	static String input;
	
	
	/**
	 * Set the description of the task.
	 * @param p
	 */
	 public void setPriority( short p ){
		 if( p < 0 || p > 3){
			 throw new IllegalArgumentException( "Invalid priority" ); // priority can only be 0-3
		 }
		 priority = p; // setting priority
	 }
	
	 /**
	  * 
	  * @return returns a string for the priority
	  */
	public String getPriorityName() {
		 String pName = "NAME";
		 switch( priority ){
		 case 0:
			 pName = "Undefined"; // so important you broke it
			 break;
		 case 1:
			 pName = "High"; // super important
			 break;
		 case 2:
			 pName = "Medium"; // meh importance
			 break;
		 case 3:
			 pName = "Low"; // practically nothing to worry about
			 break;
			default:
				pName = "ILLEGAL VALUE"; // WHAT HAVE YOU DONE?
				break;
		 }
		 return pName; // returning importance string
	 }
	 
	 /**
	  * write a task to the provided PrintWriter object
	  * @param writer 
	  */
	 public void write( PrintWriter writer ){
		 // write data separated by tabs
		 StringBuilder s = new StringBuilder(); // building a string to hold everything for a task
		
		 s.append( priority ); // writing the parts of our new little string
		 s.append( "\t" ); // tab
		 if( dueDate != null ){
			 s.append( dueDate.toString() ); // date is the black sheep of this family
		 }
		 s.append( "\t" );
		 s.append( category);
		 s.append( "\t" );
		 s.append( description );
		 s.append( "\t" );
		 s.append( location );
		 s.append( "\t" );
		 s.append( completed );
		 
		 writer.println( s ); // printing the string of the task that we just filled out
	 }

	 /**
	  * Read a task from disk using the provided BufferedReader
	  * @param reader BufferedReadrer to read from disk
	  * @return read task or null if not read
	  */
	 public void read( BufferedReader reader ){
		 String line = null;
		 String [] results;
		 try{
			 line = reader.readLine(); // reading the line to disk
		 } catch( IOException e ){
			 System.out.println( " Cannot read file: " + e.getMessage() ); // sadness
		 }
		 
		 results = line.split( "\t" ); // splitting the String line everywhere there is a tab
		 
		 // prints out the results until the length of results ends
		 for( int ctr = 0; ctr < results.length; ctr++ ){
		 	System.out.println( "DBG: results[ " + ctr + "]: \"" + results[ctr] + "\"" );
	 	}
		 
		// priority set from data stored in position 0 of results
		 setPriority( Short.parseShort( results[0] ) ); 
		 try{ // sets date with data stored in position 1 of results
			 setDate( DateFormat.getDateInstance().parse( results[1] ) );
		 } catch( ParseException e ) { // nothing to do here, move along...
			 System.out.println( "Could not parse the date. Setting to null." );
		 }
		 // sets category with results position 2 data
		 setCategory( Short.parseShort( results[2] ) );
		 // setting description with..data from position 3 from the result String array list
		 setDescription( results[3] );
		 // sets location with data from result position 4
		 setLocation( results[4] );
		 // finally sets completed status with results data from position 5
		 setCompleted( Boolean.parseBoolean( results[5] ) );
	 }
	 
	 /**
	  * Saving user's information in one String and then returning that String
	  * @return returns a string
	  */
	 public String toString() {
		 
		 StringBuilder s = new StringBuilder();
		 // appending everything into the String s
		 s.append( "Description: " + description + "\n" );
		 s.append( "Priority: " + getPriorityName() + "\n" );
		 s.append( "Category: " + getCategoryName() + "\n" );
		 
		 // appending date when it is not null
		 if( dueDate != null ) {
			 s.append( "Due Date: " + dueDate.toString() + "\n" );
		 }
		
		 s.append( "Location: " + location + "\n" );
		 s.append( "Completed? " + (completed?"Y":"N") + "\n" );
		 return s.toString();
}	 
	 /**
	  * Finds the desired category name and returns it.
	  * @return returns the string name for the category chosen by the user
	  */
	 public String getCategoryName() {
		 String cName = "NAME";
		 switch( category ){
		 case 0:
			 cName = "Undefined";
			 break;
		 case 1:
			 cName = "Other";
			 break;
		 case 2:
			 cName = "School";
			 break;
		 case 3:
			 cName = "Personal";
			 break;
		 case 4:
			 cName = "Chore";
			 break;
		 case 5:
			 cName = "Work";
			 break;
			 default:
				 cName = "ILLEGAL VALUE";
		 }
		 return cName;
	 }
	 
	 /**
	  * Setting the date!
	  * @param date takes a date parameter
	  */
	 public void setDate( Date date ){
		 dueDate = date;
	 }
	 
	 /**
	  * Setting the category!
	  * @param cat takes a short parameter
	  */
	 public void setCategory( short cat ){
		 if( cat < 0 || cat > 5){
			 throw new IllegalArgumentException( "Invalid category" );
		 }
		 category = cat;
	 }
 
	 /**
	  * Setting the description!
	  * @param d takes a string
	  */
	 public void setDescription( String d ){
		 description = d;
	 }
 
	 /**
	  * Setting location!
	  * @param l takes a string
	  */
	 public void setLocation( String l ){
		 location = l;
	 }
 
	 /**
	  * Setting completed status!
	  * @param c takes a boolean
	  */
	 public void setCompleted( boolean c){
		 completed = c;
	 }
	 
	 
	 // now for the getters
	 /**
	  * Getting the priority!
	  * @return returns a short for priority
	  */
	 public short getPriority(){
		 return priority;
	 }
	 
	 /**
	  * Getting the date!
	  * @return returns a date
	  */
	 public Date getDate(){
		 return dueDate;			
	 }
	
	 /**
	  * Getting the category!
	  * @return returns a short
	  */
	 public short getCategory(){
		 return category;
	 }
	
	 /**
	  * Getting description!
	  * @return returns a string
	  */
	 public String getDescription(  ){
		 return description;
	 }
	
	 /**
	  * Getting location!
	  * @return returns a string
	  */
	 public String getLocation( ){
		 return location;
	 }
	
	 /**
	  * Getting the completed status!
	  * @return returns a boolean
	  */
	 public boolean getCompleted( ){
		 return completed;
	 }
	 
	 
	 // these are for the getting and setting of all those parts of a task
	 private short priority;
	 private Date dueDate;
	 private short category;
	 private String description;
	 private String location;
	 private boolean completed;
	 
	 
	 
	// priorities
	public static final short PRIO_HIGH = 1;
	public static final short PRIO_MED = 2;
	public static final short PRIO_LOW = 3;
	public static final short PRIO_UNDEF = 0;
	
	/**
	 * @return returns a short
	 */
	public static short PrioH(  ){
		return PRIO_HIGH;
	}
	
	/**
	 * 
	 * @return returns a short also
	 */
	public static short PrioM(  ){	
		return PRIO_MED;
	}
	
	/**
	 * 
	 * @return all these return a short (since they are all returning priority)
	 */
	public static short PrioL(  ){
		return PRIO_LOW;
	}
	
	/**
	 * 
	 * @return returns a short
	 */
	public static short PrioU(  ){
		return PRIO_UNDEF;
	}
	
	// categories
	public static final short CAT_UNDEF = 0;
	public static final short CAT_OTHER = 1;
	public static final short CAT_SCHOOL = 2;
	public static final short CAT_PERSONAL = 3;
	public static final short CAT_CHORE = 4;
	public static final short CAT_WORK = 5;
	
	// Categories now!!
	
	/**
	 * 
	 * @return returns a short 
	 */
	public static short CatU(  ){
		return CAT_UNDEF;
	}
	
	/**
	 * I'm seeing a pattern here...
	 * @return returns a short
	 */ 
	public static short CatO(  ){
		return CAT_OTHER;
	}
	
	/**
	 * 
	 * @return returns a short
	 */
	public static short CatS(  ){
		return CAT_SCHOOL;
	}
	
	/**
	 * 
	 * @return returns a short
	 */
	public static short CatP(  ){
		return CAT_PERSONAL;
	}
	
	/**
	 * @return returns a short
	 */
	public static short CatC(  ){
		return CAT_CHORE;
	}
	
	/**
	 * 
	 * @return returns a string..just kidding, of course it's a short
	 */
	public static short CatW(  ){
		return CAT_WORK;
	}

	/**
	 * compareTo returns a positive, negative, or zero value.
	 * zero -- priorities of the tasks are the same
	 * positive int -- priority of my task is greater than priority of your task
	 * negative int -- priority of my task is less than priority of your task
	 */
	@Override // implementing custom version for this class as opposed to the method from the parent
	public int compareTo(Task arg0) {
		short myPriority = this.getPriority(); // using this because calling task from task
		short yourPriority = arg0.getPriority(); // other task for comparing my task's priority
		
		int result = myPriority - yourPriority; // coolness B)
		
		return result; // returning the positive, negative, or zero int result
	}

}
