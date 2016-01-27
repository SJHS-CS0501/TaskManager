import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributesException;

import java.io.*;

/*
 * Task manager program
 * - keep list of task
 * - Allow user to add and remove tasks
 * - Allow user to reprioritize tasks
 * - print out list of tasks
 * 
 * List of tasks:
 * -read and store on disk
 * -sort
 * -search
 * 
 * Reports:
 * -list high priority
 * -List due today/soon
 * -List all (by date OR by priority)
 */

/**
 * 
 * @author Ryley
 *
 */
public class Task_Manager {

	/*Utilizing the code base we have created together in class, build out the rest of the program into a functional application. The following things are needed at a minimum:
		
		*A menu system that displays on execution. 
		 The menu should offer the user:
		-the chance to load the task list from a file,
		-save the task list in memory to a file, 
		-add tasks to the task list, print the task list, 
		-search for tasks using the searching functions already created, 
		-sort a list of tasks by priority, and mark a task as completed. 
		
		*You will need to write the sort by priority method yourself! 
		 The menu should also have an option to exit the program.
		- Write a sort function to sort a list of tasks by priority.
		- Add the necessary logic and code to correctly ask the user for due dates, 
		- and make sure the code to read and write those works correctly.
		- Run through the program with the menu to be sure that all of your listed options work the way you intend.
		
		*Extra details: Provide the abilities to delete and edit tasks! Fun!
		
		*Extra extra details: Add features. Make it fancy. Think about ways you might want to use a program like this and incorporate those ideas into your code.
		
		********This assignment is due on SUNDAY, January 31st at midnight!
		*
		*ask Task to print information
	*/
	
	

	public static void main(String[] args) throws Exception {
		
		Scanner k = new Scanner(System.in);// new scanner object	
		File myFile = new File("Task Thing");
		Task_List list;
		Exception t;
		int c = 0;
	
		System.out.println("Welcome to Task Manager \n\n"
							+ "Do you want to load a previously written task list (press 1) "
				            + "\nDo You want to start a new task list from scratch (press 2)");
		do{
		try{
		c = k.nextInt();
		}catch(Exception e){
			
		}
		}
		
		while(c != 1 || c != 2){
			System.out.println("You input the wrong thing. Try again");
		}
		
		if(c == 1){
			System.out.println("hello");
		}else if(c == 2){
			System.out.println("Hello 2");
		}
	
	
	
	
	
	
		System.exit(0);// exit program 
	
	}
	

	
	
	
	
		
	
	/*public static void main(String[] args) throws Exception {
		//main stuff
		Scanner k = new Scanner(System.in);// new scanner object
		char choice = 'n';
		Task_List list;
		int numTask = 0;
		File myFile = new File("Task Thing");
		short prio;
		short cat;
		String loc;
		String des;
		Date d;
		
		String fileName = "tasks.csv";
		
		Task that = new Task();
		
		
		list = new Task_List();
		
		do{
		
			list.addTask(that);
			
			System.out.println("What is the priorety of this task 0-3");
			prio = k.nextShort();
			try{
			that.setPriority(prio);
			}catch(IllegalArgumentException e ){
				
				System.out.println("Why have you done this to me, I am now dead..........");
				System.exit(-1);
			}
			
			System.out.println("undefined = 0, other = 1, school = 2, chore = 3, work = 4 ");
			cat = k.nextShort();
			that.setCatagory(cat);
			
			System.out.println("What is the date it is due");
			k.nextLine();
			d = null;
			that.setDate(d);
			
			System.out.println("the location");
			loc = k.nextLine();
			that.setLocation(loc);
			
			System.out.println("Description of the task");
			des = k.nextLine();
			that.setDescription(des);
			
			that.toString();
			
			System.out.println("Would you like to add another task? \ny (for yes)\nn (for no)");
			choice = k.nextLine().toLowerCase().charAt(0);
			
		}
		while(choice == 'y');
		
		list.printTasks();
		
		try{	
		list.writeFile(fileName);
		}catch(FileNotFoundException e) {
			System.out.println("File \"" + fileName + "\" not found!");
			System.out.println("Dying....");
			e.printStackTrace();
			System.exit(-1);
		}
		
		list = new Task_List();
		
		System.out.println("before read");
		list.printTasks();
		
		try{	
			list.readFile(fileName);
			list.printTasks();
			}catch(FileNotFoundException e) {
				System.out.println("File \"" + fileName + "\" not found!");
				System.out.println("Dying....");
				e.printStackTrace();
				System.exit(-1);
			}
		
	
		k.close();
		System.exit(0);
		
	}
*/
}
