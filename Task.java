import java.util.Date;

/**
 * Task object containing information on a single task
 * @author Ryley
 *
 */


public class Task {

	/*
	 * Data fields:
	 * -priority
	 * -Due date
	 * -catagory
	 * -Descrition
	 * -Location
	 * -completion(checkbox{y/n})
	 */
	 private short priority;
	 private Date dueDate;//odject
	 private short catagory;
	 private String descrition;
	 private String location;
	 private boolean completed;
	 
	 /*
	  * Priorities:
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
	 * 
	 * Methods:
	 * -Empty constructor
	 * -Acessors/Mutators for all fields
	 * -override toString
	 * -an equals method
	 * 
	 * 
	 */
}
