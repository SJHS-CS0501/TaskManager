import java.util.Date;

/**
 * Task object containing information on a single task
 * 
 * @author David Herr
 *
 */
public class Task {

	/*
	 * Data fields:
	 * Priority 
	 * Due Date
	 * Category
	 * Description
	 * location
	 * completed
	 *
	 */
	private short priority;
	private Date dueDate; 
	private short category;
	private String description;
	private String location;
	private boolean completed;
	

	
	/*
	 * priorities
	 * use if statement to compare
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
	 * Empty Constructor
	 * accessors all fields
	 * mutators all fields
	 * toString
	 * equals method
	 *  
	 */
	
	
	
	
	
	
}
