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
	 * categories
	 */
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