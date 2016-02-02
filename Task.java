import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
	 private  short priority;
	 private  Date dueDate;//odject
	 private  short catagory;
	 private  String descrition;
	 private  String location;
	 private  boolean completed;
	 private  SimpleDateFormat format;
	 
	 
	 
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
	 
	// static Scanner k = new Scanner(System.in);
	 
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
	 public  void setPriority(short i) throws Exception{
		 
		
		 
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
	 public  short getPrority(){
		
		 
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
	 * 
	  */
	 public  void setDate(String s) {
		
		// dat = s;
		 
		 DateFormat format = new SimpleDateFormat("MM/d/yyyy");
		 try {
			 dueDate = format.parse(s);
			System.out.println(format.format(dueDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		// System.out.println(format.format(dueDate));
		 
	 }
	 
	 /**
	  * get due date
	 * @return 
	 * @return 
	  */
	 public  Date getDate(){
		 
		 return dueDate;
	 }
	 
	 /**
	  * set catagory
	  */
	 public void setCatagory(short i){
		 
		 if(i < 0 || i > 5){
			 throw new IllegalArgumentException("Invalid priority");
	 }
		 catagory = i;
	 }
	 
	 /**
	  * get catagory
	 * @return 
	  */
	 public  short getCatagory(){
		 
		 return catagory;
	 }
	 
	 /**
	  * set description
	  */
	 public  void setDescription(String d){
		 
		 descrition = d;
	 }
	 
	 /**
	  * get description
	 * @return 
	  */
	 public  String getDescrition(){
		 
		 return descrition;
	 }
	 
	 /**
	  * set location
	  */
	 public  void setLocation(String l){
		 
		 location = l;
	 }
	 
	 /**
	  * get location
	 * @return 
	  */
	 public  String getLocation(){
		 
		 return location;
	 }
	 
	 /**
	  * Checks if a task has been completed
	 * @param b 
	  * @return
	  */
	 public  void complete(char comp){
		 
		 if(comp == 'n'){
			 completed = false;
		 }else if(comp == 'y'){
			 completed = true;
		 }else{
			 completed = false;
		 }
	 }
	 
	 
	 public  boolean getComplete(){
		 
		 return completed;
	 }
	 
	 /**
	  * Write a task to provide printwritter object
	  * @param writer
	  */
	 public void write(PrintWriter writer){
		 // write data separated by tabs
		StringBuilder s = new StringBuilder();
		 DateFormat format = new SimpleDateFormat("MM/d/yyyy");
		 
		 s.append(priority);
		 s.append("\t");
		
		try{
		 s.append(format.format(getDate()));
		}catch (NullPointerException e)
		{
			e.printStackTrace();
		}
		 
		 s.append("\t");
		 s.append(catagory);
		 s.append("\t");
		 s.append(descrition);
		 s.append("\t");
		 s.append(location);
		 s.append("\t");
		 //s.append(completed);
		
		 if(completed == false){
			 s.append("n");
		 } else if(completed == true){
			 s.append("y");
		 }
		 
		 writer.println(s);
		
	 }
	 
	 public String toString() {
		 DateFormat format = new SimpleDateFormat("MM/d/yyyy");
		 StringBuilder s = new StringBuilder();
		  s.append( "Description: " + getDescrition() + "\n" );
		  s.append( "Priority: " + getPrority() + "\n" );
		  s.append( "Category: " + getCatagory() + "\n" );
		  if( dueDate != null ) {
		    s.append( "Due Date: " + format.format(getDate()) + "\n" );
		  }
		  s.append( "Location: " + location + "\n" );
		  s.append( "Completed? " + (completed?"Y":"N") + "\n" );
		  return s.toString();
		}
	 
	 /**
	  * Read task from disk using the provided Buffered reader 
	  * @param reader
	  */
	 public void read(BufferedReader reader){
		 String line = null;
		 String [] results;
		 try{
			 line = reader.readLine();			 
		 }catch(IOException e){
			
			 System.out.println("Why why why!!!!!:" + e.getMessage());
			 
		 }
		 
		 results = line.split("\t");
		
		 for(int i=0; i <results.length; i++){
			 System.out.println("DBG: [" + i + "]: \""+ results[i] + "\"");
		 }
		 
		 /* private static short priority;
		 private static Date dueDate;//odject
		 private static short catagory;
		 private static String descrition;
		 private static String location;
		 private boolean completed;
		 */
		 
		 try {
			setPriority(Short.parseShort(results[0]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not complete the parsing og set priority:" + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Could not complete the parsing og set priority:" + e.getMessage());
		}
		 
		 
		 
		 
		setDate((results[1]));
		setCatagory(Short.parseShort(results[2]));
		setDescription(results[3]); 
		setLocation(results[4]);
		complete((results[5]).charAt(0));
		 
	 }

	

	 
}
