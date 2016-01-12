import java.util.Date;

/**
 * Task object containing information on a single task.
 * @author SJHSStudent
 */
public class Task {
	
	/*
	 * data fields:
	 * - priority yes
	 * - due date no
	 * - category yes
	 * - description no
	 * - location no
	 * - completion no
	 */
	
	public Task() {
		
	}
	
	/**
	 * set priority of task
	 * @param userPriority
	 */
	 
	public void setPriority( short userPriority ) {
		if( userPriority < 0 || userPriority > 3 ) {
			throw new IllegalArgumentException( "Invalid priority" );
		}
		userPriority = priority;
	}
	
	/**
	 * set due date of task
	 * @param userDueDate
	 */
	
	public void setDueDate( Date userDueDate ) {
		userDueDate = dueDate;
	}
	
	/**
	 * set category of task
	 * @param userCategory
	 */
	
	public void setCategory( short userCategory ) {
		if( userCategory < 0 || userCategory > 5) {
			throw new IllegalArgumentException( "Invalid category" );
		}
		userCategory = category;
	}
	
	/**
	 * set description of task
	 * @param userDescription
	 */
	
	public void setDescription( String userDescription ) {
		userDescription = description;
	}
	
	/**
	 * set location of task
	 * @param userLocation
	 */
	
	public void setLocation( String userLocation ) {
		userLocation = location;
	}
	
	/**
	 * set if task is completed
	 * @param userCompleted
	 */
	
	public void setCompleted( boolean userCompleted ) {
		userCompleted = completed;
	}
	
	/**
	 * get priority of task
	 * @return
	 */
	
	public short getPriority() {
		return priority;
	}
	
	/**
	 * get due date of task
	 * @return
	 */
	
	public Date getDueDate() {
		return dueDate;
	}
	
	/**
	 * get category of task
	 * @return
	 */
	
	public short getCategory() {
		return category;
	}
	
	/**
	 * get description of task
	 * @return
	 */
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * get location of task
	 * @return
	 */
	
	public String getLocation() {
		return location;
	}
	
	/**
	 * get if task is completed
	 * @return
	 */
	
	public boolean getCompleted() {
		return completed;
	}
	
	/**
	 * tell user what priority a task is set at
	 * @return pName
	 */
	
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
			break;
		default:
			pName = "Illegal Value";
		}
		return pName;
	}
	
	/**
	 * tell user what category a task is assigned to
	 * @return cName
	 */
	
	public String getCategoryName() {
		String cName;
		switch( category ) {
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
		default:
			cName = "Illegal Value";
		}
		return cName;
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
	
	public static short getPrioH() {
		return PRIO_HIGH;
	}
	
	public static short getPrioM() {
		return PRIO_MED;
	}
	
	public static short getPrioL() {
		return PRIO_LOW;
	}
	
	public static short getPrioU() {
		return PRIO_UNDEF;
	}
	
	public static final short PRIO_HIGH = 1;
	public static final short PRIO_MED = 2;
	public static final short PRIO_LOW = 3;
	public static final short PRIO_UNDEF = 0;
	
	/*
	 * categories
	 */
	
	public static short getCatU() {
		return CAT_UNDEF;
	}
	
	public static short getCatO() {
		return CAT_OTHER;
	}
	
	public static short getCatS() {
		return CAT_SCHOOL;
	}
	
	public static short getCatP() {
		return CAT_PERSONAL;
	}
	
	public static short getCatC() {
		return CAT_CHORE;
	}
	
	public static short getCatW() {
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
	 * - empty constructor
	 * - accessors/mutators for all fields
	 * - toString
	 * - string.equals to compare tasks
	 */
	
	/*
	 * make getters/setters
	 */

}