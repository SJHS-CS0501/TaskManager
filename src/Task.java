import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.Date;



/**
 * 
 */

/**
 * Task object containing info on a single task.
 * 
 * @author Ryan Smith
 *
 */
public class Task {
	/*
	 * Data fields: -Priority -Due date -Category -Description -Location
	 * -Completed(Boolean)
	 */
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
	 * Methods: -Empty Constructor -Accessors/Mutators for all fields -toString
	 * -.equals method
	 */
	public Task() {
	}

	/**
	 * Set the description of the task
	 * 
	 * @param d
	 */
	public void setDescription(String d) {
		description = d;
	}

	public String getDescription() {
		return description;
	}

	public void setPriority(short p) {
		if (p < 0 || p > 3) {
			throw new IllegalArgumentException("Invalid priority");
		}
		priority = p;
	}

	public short getPriority() {
		return priority;
	}

	public String getPriorityName() {
		String pName = null;
		switch (priority) {
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
	
	public void setDueDate(Date n) {
		dueDate = n;
	}
	
	public Date getDueDate() {
		return dueDate;
	}

	public void setCategory(short p) {
		if (p < 0 || p > 5) {
			throw new IllegalArgumentException("Invalid category");
		}
		category = p;
	}

	public short getCategory() {
		return category;
	}

	public String getCategoryName() {
		String cName = null;
		switch (category) {
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
			break;
		}
		return cName;
	}
	
	public void setCompleted(boolean c) {
		completed = c;
	}
	
	public boolean getCompleted() {
		return completed;
	}
	
	public void setLocation(String l) {
		location = l;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void write(PrintWriter writer) {
		//write data separated by tabs.
		StringBuilder s = new StringBuilder();
		
		/*
		 * 	private short priority;
		 *	private Date dueDate;
		 *	private short category;
		 *	private String description;
		 *	private String location;
		 *	private boolean completed;
		 */
		
		s.append(priority);
		s.append("\t");
		if(dueDate != null) {
			s.append(dueDate.toString());
		}
		s.append("\t");
		s.append(category);
		s.append("\t");
		s.append(description);
		s.append("\t");
		s.append(completed);
		
		//Ok, write this now
		writer.println(s);
		//BOOM BABY!!!!!!!!!!!
	}
	
	/**
	 * Read a task from disk using the provided BufferedReader.
	 * @param reader
	 * @return read task or null if not read.
	 */
	
	public void read(BufferedReader reader) {
		Task t = new Task();
		String line = null;
		String [] results;
		try {
			line = reader.readLine();
		} catch( IOException  e ) {
			System.out.println("Cannot read file: " + e.getMessage());
			t = null;
		}
		
		results = line.split("\t");
		
		for(int ctr = 0; ctr < results.length; ctr++) {
			System.out.println("DBG.results[" + ctr + "]: \"" + results[ctr] + "\"");
		}
		setPriority(Short.parseShort(results[0]));
		try{
			t.setDueDate(DateFormat.getDateInstance().parse(results[1]));
		}catch(ParseException e) {
			System.out.println("Could not parse date. Setting to null.");
			//nothing to do here. Move along
		}
		setCategory(Short.parseShort(results[2]));
		setDescription(results[4]);
		setCompleted(Boolean.parseBoolean(results[5]));
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



		

}
