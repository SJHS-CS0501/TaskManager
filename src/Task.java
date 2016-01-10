import java.util.Date;

/**
 * Task object containing information on a single task.
 * @author SJHSStudent
 */
public class Task {
	/*
	 * data fields:
	 * - priority
	 * - due date
	 * - category
	 * - description
	 * - location
	 * - completion
	 */
	
	public void setPriority( short userPriority ) {
		userPriority = priority;
	}
	
	public short getPriority() {
		return priority;
	}
	
	public void setDueDate( Date userDueDate ) {
		userDueDate = dueDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setCategory( short userCategory ) {
		userCategory = category;
	}
	
	public short getCategory() {
		return category;
	}
	
	public void setDescription( String userDescription ) {
		userDescription = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLocation( String userLocation ) {
		userLocation = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setCompleted( boolean userCompleted ) {
		userCompleted = completed;
	}
	
	public boolean getCompleted() {
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
	
	private final short getPrio_High() {
		return ;
	}
	
	private final short getPrio_Med() {
		return ;
	}
	
	private final short getPrio_Low() {
		return ;
	}
	
	private final short getPrio_Undef() {
		return ;
	}
	
	public static final short PRIO_HIGH = 1;
	public static final short PRIO_MED = 2;
	public static final short PRIO_LOW = 3;
	public static final short PRIO_UNDEF = 0;
	
	/*
	 * categories
	 */
	
	private final short getCat_Undef() {
		return ;
	}
	
	private final short getCat_Other() {
		return ;
	}
	
	private final short getCat_School() {
		return ;
	}
	
	private final short getCat_Personal() {
		return ;
	}
	
	private final short getCat_Chore() {
		return ;
	}
	
	private final short getCat_Work() {
		return ;
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