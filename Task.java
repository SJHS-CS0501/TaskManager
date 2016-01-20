import java.util.Date;
import java.io.*;
/**
 * 
 * Task object containing information on a single task.
 * @author Isabelle Schroeder
 *
 */
public class Task {
	/*
	 * Data fields:
	 *  -Priority
	 *  -Due date
	 *  -Category
	 *  -Description
	 *  -Location
	 *  -Completed
	 */
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
	
	 public String getPriorityName() {
		 String pName = "NAME";
		 switch( priority ){
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
	  * write a task to the provided PrintWriter object
	  * @param writer
	  */
	 public void write( PrintWriter writer ){
		 // write data separated by tabs
		 StringBuilder s = new StringBuilder();
		
		 s.append( priority );
		 s.append( "\t" );
		 s.append( dueDate.toString() );
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
	 
	 
	 
	 /*
	 * priorities
	 */
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
	/*
	 * categories
	 */
	
	
	
	
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
	
	
	/* 
	 * Methods:
	 * - Empty Constructor
	 * - Accessors/Mutators for all fields
	 * - toString
	 * - string.equals to compare tasks 
	 */
}
