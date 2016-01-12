import java.io.PrintWriter;
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
	 private static Date dueDate;//odject
	 private static short catagory;
	 private static String descrition;
	 private static String location;
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
	 
	public Task(){
		
		
	 }
	 
	 /**
	  * Set priority level
	  */
	 public static void setPriority(short i) throws Exception{
		 
		
		 
		/* System.out.println("What is the priority "
					+ "	level of this task (0-3)");
		  priority = k.nextShort();
		 */	
		 
		 if(i< 0 || i>3){
			 throw new IllegalArgumentException("Invalid priority");
		 }
			
			 priority = (short) i;
			  
		 
	 }
	 
	 
	 /**
	  * Get priority
	  */
	 public static short getPrority(){
		
		 
		 return priority;
	 }
	 
	 public String getPriorityName(){
		 
		 String pName = "Fail";
			 switch(priority){
			 
			 case 0:
				 pName = "undefined";
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
				pName = "Illigal priority";
				break;
			 }
			return pName;
	 }
	 
	 /**
	  * Set due date 
	  */
	 public static void setDate(Date d){
		 
		dueDate = d;
	 }
	 
	 /**
	  * get due date
	 * @return 
	  */
	 public static Date getDate(){
		 
		 return dueDate;
	 }
	 
	 /**
	  * set catagory
	  */
	 public static void setCatagory(short i){
		 
		 if(i < 0 || i > 5){
			 throw new IllegalArgumentException("Invalid priority");
	 }
		 catagory = i;
	 }
	 
	 /**
	  * get catagory
	 * @return 
	  */
	 public static short getCatagory(){
		 
		 return catagory;
	 }
	 
	 /**
	  * set description
	  */
	 public static void setDescription(String d){
		 
		 descrition = d;
	 }
	 
	 /**
	  * get description
	 * @return 
	  */
	 public static String getDescrition(){
		 
		 return descrition;
	 }
	 
	 /**
	  * set location
	  */
	 public static void setLocation(String l){
		 
		 location = l;
	 }
	 
	 /**
	  * get location
	 * @return 
	  */
	 public static String getLocation(){
		 
		 return location;
	 }
	 
	 /**
	  * Checks if a task has been completed
	  * @return
	  */
	 public static void complete(){
		 
		 //return false;
	 }
	 
	 /**
	  * Write a task to provide printwritter object
	  * @param writer
	  */
	 public void write(PrintWriter writer){
		 // write data separated by tabs
		 StringBuilder s = new StringBuilder();
		 
		/* private static short priority;
		 private static Date dueDate;//odject
		 private static short catagory;
		 private static String descrition;
		 private static String location;
		 private boolean completed;
		 */
		 
		 s.append(priority);
		 s.append(\t);
		 s.append(dueDate.toString());
		 s.append(\t);
		 s.append(catagory);
		 s.append(\t);
		 s.append(descrition);
		 s.append(\t);
		 s.append(location);
		 s.append(\t);
		 s.append.(completed);
	 }
	 
	 
}
