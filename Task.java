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
			case 0:
				priority = PRIO_UNDEF;
				break;
			case 1:
				priority = PRIO_HIGH;
				break;
			case 2:
				priority = PRIO_MED;
				break;
			case 3:
				priority = PRIO_LOW;
				break;
			default:
				priority = PRIO_UNDEF;
				System.out.println("Priority of (" + p + ") is undefinded.");
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
	public void setDueDate(int y, int m, int d) {
		dueDate = new Date(y, m, d);
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
			case 0:
				category = CAT_UNDEF;
				break;
			case 1:
				 category = CAT_OTHER;
				 break;
			case 2:
				 category = CAT_SCHOOL;
				 break;
			case 3:
				 category = CAT_PERSONAL;
				 break;
			case 4:
				 category = CAT_CHORE;
				 break;
			case 5:
				category = CAT_WORK;
				break;
			default:
				category = CAT_UNDEF;
				System.out.println("Category (" + c + ") is undefined.");
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
}
