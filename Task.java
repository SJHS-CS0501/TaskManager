import java.util.Date;
import java.util.Scanner;
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
	 private static short priority;
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
	 
	 static Scanner k = new Scanner(System.in);
	 
	 /*
	 * 
	 * Methods:
	 * -Empty constructor
	 * -Acessors/Mutators for all fields
	 * -override toString
	 * -an equals method 
	 * 
	 */
	 
	Task(){
		
		
	 }
	 
	 /**
	  * Set priority level
	  */
	 public static void setPriority(){
		 
		 System.out.println("What is the priority "
					+ "	level of this task (0-3)");
		  priority = k.nextShort();
		 	
		 getPrority();
	 }
	 
	 
	 /**
	  * Get priority
	  */
	 public static short getPrority(){
		 if(priority ==0){
				
			 return PRIO_UNDEF; 
		 } else if(priority == 1){
			 return PRIO_LOW;
		 } else if(priority == 2){
			 return PRIO_MED;
		 }else if(priority == 3){
			 return PRIO_HIGH;
		 }else{
			 return PRIO_UNDEF;
		 }
	 }
	 
	 /**
	  * Set due date 
	  */
	 public static void setDate(){
		 
	 }
	 
	 /**
	  * get due date
	  */
	 public static void getDate(){
		 
	 }
	 
	 /**
	  * set catagory
	  */
	 public static void setCatagory(){
		 
	 }
	 
	 /**
	  * get catagory
	  */
	 public static void getCatagory(){
		 
	 }
	 
	 /**
	  * set descrition
	  */
	 public static void setDescription(){
		 
	 }
	 
	 /**
	  * get description
	  */
	 public static void getDescrition(){
		 
	 }
	 
	 /**
	  * set location
	  */
	 public static void setLocation(){
		 
	 }
	 
	 /**
	  * get location
	  */
	 public static void getLocation(){
		 
	 }
	 
	 /**
	  * Checks if a task has been completed
	  * @return
	  */
	 public static boolean complete(){
		 
		 return false;
	 }
	 
}
