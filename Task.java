import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Task object containing information on a single task
 * 
 * @author David Herr
 *
 */
public class Task {

	/*
	 * Data fields:
	 * Priority - check
	 * Due Date - check
	 * Category - check
	 * Description - check
	 * location -check
	 * completed - check
	 *
	 */
	private short priority; // variable for priority of the task
	private static Date dueDate; // variable for due date of the task 
	private short category; // variable for the category of the task
	private String description; // variable for the description of the task
	private String location; // variable for the location of the task
	private boolean completed; // variable for the completion of the task, either true or false
	Scanner keyboard = new Scanner(System.in); // creates new Scanner object
	private static String utilString; // variable for utility purposes like for parsing out date
	private char trFa; // variable for true or false, to be used with boolean completed
	
	/*
	 * priorities - bounds check
	 * use if statement to compare
	 */
	public static final short PRIO_HIGH = 1; // variable for high priority
	public static final short PRIO_MED = 2;// variable for medium priority
	public static final short PRIO_LOW = 3;// variable for low priority
	public static final short PRIO_UNDEF = 0;// default variable if priority does not equal 1,2, or 3
	
	
	/*
	 * categories -  bounds check
	 */
	
	public static final short CAT_UNDEF = 0;// default category
	public static final short CAT_OTHER = 1; // category for other tasks not listed
	public static final short CAT_SCHOOL = 2;// category for school tasks
	public static final short CAT_PERSONAL = 3;// category for personal tasks
	public static final short CAT_CHORE = 4;// category for chores
	public static final short CAT_WORK = 5;// category for work tasks
	
	/*
	 * Methods:
	 * Empty Constructor- check!
	 * accessors all fields
	 * mutators all fields
	 * toString
	 * equals method
	 * Remember to relook over the Date java doc, really good information that you will probably need
	 * 
	 */
	/**
	 * Constructor
	 */
	Task(){
		
	}
	/**
	 *Method to set the value of priority 
	 * @param priority
	 */
	
	public void setPriority( short p ){
	/*	System.out.print( " Please enter a catagory for your task between one and five" 
		+ "1 = high, 2 = medium, and 3 = low priority " );
		priority = keyboard.nextShort();
		if( priority == 1 ){
			priority = PRIO_HIGH;
		}else{
			if( priority == 2){
			priority = PRIO_MED;
			}else{
				if( priority == 3){
					priority = PRIO_LOW;
				}else{
					priority = PRIO_UNDEF;
				}
				
			}
		}
		*/
		if( p < 0|| p > 3){
			throw new IllegalArgumentException( " Invalid priority " );
		}
		priority = p;
	}
	/**
	 * returns priority to main
	 * @return
	 */
	public short getPriority(){
		return priority;
	}
	
	public String getPriorityName(){
		String pName;
		switch( priority ){
			case 0:
				pName = "Undefined";
				break;
			case 1:
				pName = "High"
			
		}
	}
	/**
	 * Sets the value of dueDate by using dDateStrng and .parse 
	 * @param dueDate
	 * @param dDateStrng
	 */
	public  void getDate( Date dueDate, String dDateStrng ){
	/*	System.out.println( " Please a due date for your task " );
		dDateStrng = keyboard.nextLine();
		
		DateFormat.parse( dDateStrng );
		*/
	}
	
	/**
	 * returns the value of dueDate to main
	 * @return
	 */
	public Date getDate( ){
		return dueDate;
	}
	/**
	 * sets the value of category
	 * @param category
	 */
	public void setCatagory( short c ){
		/* System.out.print( " Please enter a priority for your task between one and three" 
		+ "1 = other, 2 = school, 3 = personal, four = chores, and five = work. " );
		category = keyboard.nextShort();
		if( category == 5 ){
			category = CAT_WORK;
		}else{
			if( category == 4){
			category = CAT_CHORE;
			}else{
				if( category == 3){
					category = CAT_PERSONAL;
				}else{
					if( category == 2){
					category = CAT_SCHOOL;
					}else{
						if( category == 1){
						category = CAT_OTHER;
						}else{
						category = CAT_UNDEF;
						}
					}
				}
			}
		}
		*/
		category = c;
	}

	/**
	 * returns the value of category to main
	 * @return
	 */
	public short setCatagory(){
		return category;
	}
	/**
	 * Sets the value of description, no character checking is needed
	 * @param description
	 */
	public void setDescription( String description ){
		System.out.println( " Please enter a basic description of your task. " );
		description = keyboard.nextLine();
	}
	/**
	 * Returns the value description to main
	 * @return
	 */
	public String getDescription(){
		return description;
	}
	/**
	 * Sets the value of location, no character checking was used, although it can be added
	 * @param location
	 */
	public void setLocation( String location ){
		System.out.println( " Please enter the location for your task " );
		location =  keyboard.nextLine();
	}
	/**
	 * returns location to main
	 * @return
	 */
	public String getLocation(){
		return location;
		
	}
	/**
	 * Sets the value of completed by using variable trFa to test if equaled to 'y'
	 * @param completed
	 */
	public void setCompleted( boolean completed, char trFa ){
		System.out.println( "If you have completed your task, type y , "
		+ "otherwise type anything else " );
		trFa  = keyboard.nextLine().toLowerCase().charAt(1);
		
		if(trFa == 'y'){
			completed = true;
		}else{
			completed = false;
		}
	}
	/**
	 * returns completed as either true or false to main
	 * @return
	 */
	public boolean getCompleted(){
		return completed;
	}
}
	
	


