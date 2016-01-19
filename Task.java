import java.util.Date;
import java.io.PrintWriter;

/**
 * Task object containing information on a single task.
 * @author Ryan Luchs
 *
 */
public class Task {
	/*
	 * Data fields:
	 * - Priority
	 * - Due Date
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
	
	// Priorities
	public static final short PRIO_HIGH = 1;
	public static final short PRIO_MED = 2;
	public static final short PRIO_LOW = 3;
	public static final short PRIO_UNDEF = 0;
	
	// Categories
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
	 * 
	 */
	
	public Task() {
	}
	
	/**
	 * Sets task priority
	 * @param p short priority value
	 */
	public void setPriority(short p) {
		if( p < 0 || p > 3){
			throw new IllegalArgumentException("Invalid priority");
		}
		priority = p; 
		
//		if(priority <= 3 && priority >= 0) {
//			priority = p;
//		} else {
//			priority = PRIO_UNDEF;
//			System.out.println("Given value is undefined for priority.");
//		}
	}
	
	/**
	 * Gets task priority
	 * @return Task priority value
	 */
	public short getPriority() {
		return priority;
	}
	
	/**
	 * Returns a String of the name of the task priority
	 * @return The name of the priority (String)
	 */
	public String getPriorityName() {
		String pName;
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
	
	/**
	 * Sets due date in year/month/day format
	 * @param y Year
	 * @param m Month
	 * @param d Date
	 */
	public void setDueDate(int y, int m, int d) {
		dueDate = new Date(y, m, d);
	}
	
	/**
	 * Gets the task's due date
	 * @return Date task's due date
	 */
	public Date getDueDate() {
		return dueDate;
	}
	
	/**
	 * Sets task category
	 * @param c short category value
	 */
	public void setCategory(short c) {
		if( c < 0 || c > 5) {
			throw new IllegalArgumentException("Invalid category");
		}
		category = c;
		
//		if(category <= 5 && category >= 0) {
//			category = c;
//		} else {
//			category = CAT_UNDEF;
//			System.out.println("Give value is undefined for category.");
//		}

	}
	
	/**
	 * Gets the task's category
	 * @return The task's category value		
	 */
	public short getCategory() {
		return category;
	}
	
	/**
	 * Returns a String of the name of the task category
	 * @return The name of the category (String)
	 */
	public String getCategoryName() {
		String cName;
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
	
	/**
	 * Sets task description
	 * @param d String description
	 */
	public void setDescription(String d) {
		description = new String(d);
	}
	
	/**
	 * Gets task description
	 * @return The task description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets task location
	 * @param l The location
	 */
	public void setLocation(String l) {
		location = new String(l);
	}
	
	/**
	 * Gets task location string
	 * @param The String task location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets whether task is completed or not
	 * @param c Completion, true/false
	 */
	public void setCompleted(boolean c) {
		completed = c;
	}
	
	/**
	 * Gets the completion state of the task
	 * @return Whether the task is completed true/false
	 */
	public Boolean getCompleted() {
		return completed;
	}
	
	/**
	 * Write a task to the provided PrintWriter object 
	 * @param writer
	 */
	public void write( PrintWriter writer) {
		// write data separated by tabs
		StringBuilder s = new StringBuilder();
		
		/*
 			private short priority;
			private Date dueDate;
			private short category;
			private String description;
			private String location;
			private boolean completed;
		 */
		
		s.append(priority);
		s.append('\t');
		s.append(dueDate.toString());
		s.append('\t');
		s.append(category);
		s.append('\t');
		s.append(description);
		s.append('\t');
		s.append(location);
		s.append('\t');
		s.append(completed);
		
		// Ok, write that bad boy
		writer.println(s);
		
	}
	
	/**
	 * Prints the Task to the screen
	 */
	public void print() {
		System.out.print("\tTask: " + description);
		System.out.print("\t\tPriority: " + getPriorityName());
		System.out.print("\t\tDue Date: " + dueDate.toString());
		System.out.print("\t\tCategory: " + getCategoryName());
		System.out.print("\t\tLocation: " + location);
		System.out.print("Completed: " + completed);
	}
	
	/**
	 * Determines whether two tasks are equal
	 * @param task The task to compare to
	 * @return Whether the tasks are equal true/false
	 */
	public Boolean equals(Task task) {
		return priority == task.getPriority() && dueDate.equals(task.getDueDate()) && category == task.getCategory() && description.equals(task.getDescription()) && location.equals(task.getLocation()) && completed == task.getCompleted();
	}
}
