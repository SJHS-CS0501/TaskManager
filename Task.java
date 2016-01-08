/**
 * 
 */

import java.util.Date;

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
	
	Task() {
	}
	
	/**
	 * Sets task priority
	 * @param p The priority
	 */
	public void setPriority(short p) {
		switch (p) {
			case PRIO_UNDEF:
				priority = PRIO_UNDEF;
				break;
			case PRIO_HIGH:
				priority = PRIO_HIGH;
				break;
			case PRIO_MED:
				priority = PRIO_MED;
				break;
			case PRIO_LOW:
				priority = PRIO_LOW;
				break;
			default:
				priority = PRIO_UNDEF;
				System.out.println("Given value is undefinded for priority.");
				break;
		}
	}
	
	/**
	 * Gets task priority
	 * @return Task priority
	 */
	public short getPriority() {
		return priority;
	}
	
	/**
	 * Sets due date in year/month/day format
	 * @param y Year
	 * @param m Month
	 * @param d Date
	 */
	public void setDueDate(int year, int month, int date) {
		dueDate = new Date(year, month, date);
	}
	
	/**
	 * Gets the task's due date
	 * @return The task's due date
	 */
	public Date getDueDate() {
		return dueDate;
	}
	
	/**
	 * Sets task category
	 * @param c The category
	 */
	public void setCategory(short c) {
		switch (c) {
			case CAT_UNDEF:
				category = CAT_UNDEF;
				break;
			case CAT_OTHER:
				 category = CAT_OTHER;
				 break;
			case CAT_SCHOOL:
				 category = CAT_SCHOOL;
				 break;
			case CAT_PERSONAL:
				 category = CAT_PERSONAL;
				 break;
			case CAT_CHORE:
				 category = CAT_CHORE;
				 break;
			case CAT_WORK:
				category = CAT_WORK;
				break;
			default:
				category = CAT_UNDEF;
				System.out.println("Give value is undefined for category.");
				break;
		}
	}
	
	/**
	 * Gets the task's category
	 * @return The task's category		
	 */
	public short getCategory() {
		return category;
	}
	
	/**
	 * Sets task description
	 * @param d The description
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
	 * Gets task location
	 * @param The task location
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
	
	public Boolean equals(Task task) {
		return priority == task.getPriority() && dueDate.equals(task.getDueDate()) && category == task.getCategory() && description.equals(task.getDescription()) && location.equals(task.getLocation()) && completed == task.getCompleted();
	}
}
