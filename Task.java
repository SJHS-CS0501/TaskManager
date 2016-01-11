import java.util.Date;

/**
 * 
 * Task object containing information on a single task.
 * @author Isabelle Schroeder
 *
 */
public class Task {
	/*
	 * Data fields:
	 *  -Priority
	 *  -Due date
	 *  -Category
	 *  -Description
	 *  -Location
	 *  -Completed
	 */
	static String input;
	
	private short priority;
	private Date dueDate;
	private short category;
	private String description;
	private String location;
	private boolean completed;
	
	
	 public static void setPriority(  ){
		 prio = input;
	 }
	
	 public static void setDate(  ){
	 }
	 
	 public static void setCategory(  ){
	 
	 }
 
	 public static void setDescription( ){
	 
	 }
 
	 public static void setLocation(  ){
	 
	 }
 
	 public static void setCompleted( ){
	 
	 }
	 
	 
	 
	 public static short getPriority(  ){
		 return prio;
	 }
	 public static Date getDate(  ){
		 return date;			
	 }
	 public static short getCategory(){
		 return cat;
	 }
	 public static String getDescription(  ){
		 return desc;
	 }
	 public static String getLocation( ){
		 return loc;
	 }
	 public static boolean getCompleted( ){
		 return comp;
	 }
	 
	 public static short prio;
	 public static Date date;
	 public static short cat;
	 public static String desc;
	 public static String loc;
	 public static boolean comp;
	 
	 
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
	 * - Empty Constructor
	 * - Accessors/Mutators for all fields
	 * - toString
	 * - string.equals to compare tasks 
	 */
}
