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
	 * @param prio
	 */
	 public void setPriority( short p ){
		 if( p < 0 || p > 3){
			 throw new IllegalArgumentException( "Invalid priority" );
		 }
		 priority = p;
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
		 return pName;
	 }
	 
	 /**
	  * write a task to the provided PrintWriter object
	  * @param writer 
	  */
	 public void write( PrintWriter writer ){
		 // write data separated by tabs
		 StringBuilder s = new StringBuilder();
		
		 s.append( priority );
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
		 
		 writer.println( s );
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
			 line = reader.readLine();
		 } catch( IOException e ){
			 System.out.println( " Cannot read file: " + e.getMessage() ); // sadness
		 }
		 
		 results = line.split( "\t" );
		 
		 for( int ctr = 0; ctr < results.length; ctr++ ){
		 	System.out.println( "DBG: results[ " + ctr + "]: \"" + results[ctr] + "\"" );
	 	}
		 
		 setPriority( Short.parseShort( results[0] ) );
		 try{
			 setDate( DateFormat.getDateInstance().parse( results[1] ) );
		 } catch( ParseException e ) {
			 System.out.println( "Could not parse the date. Setting to null." );
			 // nothing to do here, move along...
		 }
		 setCategory( Short.parseShort( results[2] ) );
		 setDescription( results[3] );
		 setLocation( results[4] );
		 setCompleted( Boolean.parseBoolean( results[5] ) );
	 }
	 
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
	 
	 
	 public void setDate( Date date ){
		 dueDate = date;
	 }
	 
	 public void setCategory( short cat ){
		 if( cat < 0 || cat > 5){
			 throw new IllegalArgumentException( "Invalid category" );
		 }
		 category = cat;
	 }
 
	 public void setDescription( String d ){
		 description = d;
	 }
 
	 public void setLocation( String l ){
		 location = l;
	 }
 
	 public void setCompleted( boolean c){
		 completed = c;
	 }
	 
	 
	 
	 public short getPriority(){
		 return priority;
	 }
	 public Date getDate(){
		 return dueDate;			
	 }
	 public short getCategory(){
		 return category;
	 }
	 public String getDescription(  ){
		 return description;
	 }
	 public String getLocation( ){
		 return location;
	 }
	 public boolean getCompleted( ){
		 return completed;
	 }
	 
	 
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
	
	public static short PrioH(  ){
		return PRIO_HIGH;
	}
	public static short PrioM(  ){	
		return PRIO_MED;
	}
	public static short PrioL(  ){
		return PRIO_LOW;
	}
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
	
	public static short CatU(  ){
		return CAT_UNDEF;
	}
	
	public static short CatO(  ){
		return CAT_OTHER;
	}
	
	public static short CatS(  ){
		return CAT_SCHOOL;
	}
	
	public static short CatP(  ){
		return CAT_PERSONAL;
	}
	
	public static short CatC(  ){
		return CAT_CHORE;
	}
	
	public static short CatW(  ){
		return CAT_WORK;
	}

	/**
	 * compareTo returns a positive, negative, or zero value.
	 * zero -- priorities of the tasks are the same
	 * positive int -- priority of my task is greater than priority of your task
	 * negative int -- priority of my task is less than priority of your task
	 */
	@Override // implementing custom version
	public int compareTo(Task arg0) {
		short myPriority = this.getPriority(); // using this because calling task from task
		short yourPriority = arg0.getPriority(); // other task for comparing my task's priority
		
		int result = myPriority - yourPriority; // coolness B)
		
		return result; // returning the positive, negative, or zero int result
	}

}
