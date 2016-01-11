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
	
	/*
	 * Data fields:
	 * - Priority
	 * - Due date
	 * - Category
	 * - Description
	 * - Location
	 * - Completed
	 */
	private short priority;//
	private Date dueDate;
	private short category;//
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
	
	public void Task() {
	}
	
	/**
	 * Set the priority of the task.
	 * @param userPriority short priority value (found in Task)
	 */
	
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
		String pName;
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
		}
		return pName;
	}
	
	public void setDueDate(Date userDate) {
		dueDate = userDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setCategory(short userCategory) {
		category = userCategory;
	}
	
	public short getCategory() {
		return category;
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
