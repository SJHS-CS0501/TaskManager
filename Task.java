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

}
