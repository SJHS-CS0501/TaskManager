import java.util.*;

/**
 * 
 */

/**
 * Task object containing information on a single task.
 * 
 * @author Jack Protivnak
 *
 */
public class Task {
	
	public static void Task() {
	}
	
	public static void setPriority(short userPriority) {
		priority = userPriority;
	}
	
	public static short getPriority() {
		return priority;
	}
	
	public static void setDueDate(Date userDate) {
		dueDate = userDate;
	}
	
	public static Date getDate() {
		return dueDate;
	}
	
	public static void setCategory(short userCategory) {
		category = userCategory;
	}
	
	public static short getCategory() {
		return category;
	}
	
	public static void setDescription(String userDescription) {
		description = userDescription;
	}
	
	public static String getDescription() {
		return description;
	}
	
	public static void setLocation(String userLocation) {
		location = userLocation;
	}
	
	public static String getLocation() {
		return location;
	}
	
	public static void setCompleted(boolean userCompleted) {
		completed = userCompleted;
	}
	
	public static boolean getCompleted() {
		return completed;
	}
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
	private String locaiton;
	private boolean completed;
	
	/*
	 * Priorities
	 */
	 
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
	
	public static final short PRIO_HIGH = 1;
	public static final short PRIO_MED = 2;
	public static final short PRIO_LOW = 3;
	public static final short PRIO_UNDEF = 0;
	
	/*
	 * Categories
	 */
	 
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
}
