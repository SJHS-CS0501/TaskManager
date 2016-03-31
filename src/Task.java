import java.util.*;

import java.text.ParseException;
import java.io.*;
/**
 * 
 */
import java.text.DateFormat;

/**
 * Task object containing information on a single task.
 * 
 * @author Jack Protivnak
 *
 */
public class Task {
	DateFormat format;
	/*
	 * Data fields:
	 * - Priority
	 * - Due date
	 * - Category
	 * - Description
	 * - Location
	 * - Completed
	 */
	private short priority;
	private Date dueDate;
	private short category;
	private String description;
	private String location;
	private boolean completed;

	/*
	 * Priorities
	 */
	 
	public static final short PRIO_HIGH = 1;
	public static final short PRIO_MED = 2;
	public static final short PRIO_LOW = 3;
	public static final short PRIO_UNDEF = 0;
	
	/*
	 * Categories
	 */
	
	public static final short CAT_UNDEF = 0;
	public static final short CAT_OTHER = 1;
	public static final short CAT_SCHOOL = 2;
	public static final short CAT_PERSONAL = 3;
	public static final short CAT_CHORE = 4;
	public static final short CAT_WORK = 5;
	
	
	/*
	 * Methods:
	 * - Empty constructor
	 * - Accessors/Mutators for all fields
	 * - toString
	 * - equals
	 */
	
	/**
	 * Constructor
	 */
	 public Task() {
	 }
	
	/**
	 * Set the priority of the task.
	 * @param userPriority short priority value (found in Task)
	 */
	
	public String toString() {
		StringBuilder s = new StringBuilder();
  		s.append( "Description: " + getDescription() + "\n" );
		s.append( "Priority: " + getPriorityName() + "\n" );
		s.append( "Category: " + getCategoryName() + "\n" );
  		if( dueDate != null ) {
    			s.append( "Due Date: " + format.format(dueDate) + "\n" );
  		}
  		s.append( "Location: " + getLocation() + "\n" );
  		s.append( "Completed? " + (completed?"Y":"N") + "\n" );
  		return s.toString();
	}
	
	
	public void setPriority(short userPriority) throws IllegalArgumentException{
		if (userPriority < 0 || userPriority > 3) {
			throw new IllegalArgumentException( "Invalid priority" );
		}
		priority = userPriority;
	}
	
	public short getPriority() {
		return priority;
	}
	
	public String getPriorityName() {
		String pName = "FAIL";
		switch( priority ) {
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
	
	public void setDateFormat( DateFormat userFormat ) {
		format = userFormat;
	}
	
	public DateFormat getDateFormat() {
		return format;
	}
	
	
	public void setDueDate(Date userDate) {
		dueDate = userDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setCategory(short userCategory) throws IllegalArgumentException {
		if (userCategory < 0 || userCategory > 5) {
			throw new IllegalArgumentException( "Invalid Category" );
		}
		category = userCategory;
	}
	
	public short getCategory() {
		return category;
	}
	
	public String getCategoryName() {
		String catName = "FAIL";
		switch( category ) {
			case 0:
				catName = "Undefined";
				break;
			case 1:
				catName = "Other";
				break;
			case 2:
				catName = "School";
				break;
			case 3:
				catName = "Personal";
				break;
			case 4:
				catName = "Chore";
				break;
			case 5:
				catName = "Work";
				break;
			default:
				catName = "ILLEGAL VALUE";
				break;
		}
		return catName;
	}
	
	/**
	 * Write a task to the provided PrintWriter object
	 * @param writer
	 */
	public void write( PrintWriter writer ) {
		// write data separated by tabs
		StringBuilder s = new StringBuilder();
		
		/*
		 * private short priority;
		 * private Date dueDate;
		 * private short category;
		 * private String description;
		 * private String location;
		 * private boolean completed;
		 */
		s.append( priority );
		s.append("\t");
		if( dueDate != null ) {
			s.append(dueDate.toString() );
		}
		s.append("\t");
		s.append( category );
		s.append("\t");
		s.append( description );
		s.append("\t");
		s.append( location );
		s.append("\t");
		s.append( completed );
		
		// OK, write that bad boy
		writer.println( s );
		
	}
		/**
		 * Read a task from disk using the provided BufferedReader.
		 * @param reader BufferedReader to read from disk
		 * @return read task or null if not read
		 */
	public void read( BufferedReader reader ) {
		String line = null;
		String [] results;
		try {
			line = reader.readLine();
		} catch( IOException e ) {
			System.out.println("Cannot read file: " + e.getMessage() );
			return;
		}
		
		results = line.split("\t");
		
		setPriority( Short.parseShort( results[0] ) );
		try {
			setDueDate( DateFormat.getDateInstance().parse( results [1] ) );
		} catch( ParseException e ) {
		}
		setCategory( Short.parseShort( results[2] ) );
		setDescription( results[3] );
		setLocation( results[4] );
		setCompleted( Boolean.parseBoolean( results[5] ) );	
	}
	
	public void setDescription(String userDescription) {
		description = userDescription;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLocation(String userLocation) {
		location = userLocation;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setCompleted(boolean userCompleted) {
		completed = userCompleted;
	}
	
	public boolean getCompleted() {
		return completed;
	}
	
	
	
	public static short getHigh() {
		return PRIO_HIGH;
	}
	
	public static short getMedium() {
		return PRIO_MED;
	}
	
	public static short getLow() {
		return PRIO_LOW;
	}
	
	public static short getUndefinedPriority() {
		return PRIO_UNDEF;
	}
	
	
	
	
	public static short getUndefinedCategory() {
		return CAT_UNDEF;
	}
	
	public static short getOther() {
		return CAT_OTHER;
	}
	
	public static short getSchool() {
		return CAT_SCHOOL;
	}
	
	public static short getPersonal() {
		return CAT_PERSONAL;
	}
	
	public static short getChore() {
		return CAT_CHORE;
	}
	
	public static short getWork() {
		return CAT_WORK;
	}
	
	
	
	
	
	
	
	
	
	
}
