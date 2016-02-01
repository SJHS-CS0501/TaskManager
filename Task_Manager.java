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
		
		Task_List list;
		Exception t;
		int c = 0;
		Task that = new Task();
		list = new Task_List();
		String fileName = "tasks.csv";
		short prio;
		short cat;
		short a = 7;
		char choice = 'n';
		char comp = 'n';
		char search = 'n';
		boolean searc = false;
		String loc;
		String des;
		String desc;
		String d;
	
		System.out.println("Welcome to Task Manager \n\n");
							
		do{
		
		System.out.println( "Do you want to load a previously written task list (press 1) \n"
							+ "Do You want to start a new task list from scratch (press 2)");
		try{
		c = k.nextInt();
		}catch(Exception e){
			System.out.println("Invalid character");
			k.next();
		}
		
		}while(c!= 1 && c!= 2 );
		
		
		if(c == 1){
			
			try{
			list.readFile(fileName);
			}catch( FileNotFoundException e){
					System.out.println("No file has been created yet.\n Restart and try option 2");
					System.exit(0);
				}
			//System.out.println("This what was contained in that file");
			//list.printTasks();
			
			do{
				System.out.println("Choose the action you want to take based on the indicated number:\n"
						+ "(0)Exit Task Manager\n"
						+ "(1)Add Task\n"
						+ "(2)Remove Task\n"
						+ "(3)Print Stored Tasks\n"
						+ "(4)Search Task\n"
						+ "(5)");
				c = k.nextInt();
				
				switch(c){
				
				default:
					System.out.println("\n\nGoodbye");
					System.exit(0);
					break;
					
				case 0:
					System.out.println("\n\nGoodbye");
					System.exit(0);
					break;
					
				case 1:
				
					//do{	
					list.addTask(that);
					
					System.out.println("\nWhat is the priorety of this task 0-3");
					prio = k.nextShort();
					
					try{
					that.setPriority(prio);
					}catch(IllegalArgumentException e ){
						
						System.out.println("Why have you done this to me, I am now dead..........");
						System.exit(-1);
					}
					
					System.out.println("\nCatagory\nundefined = 0,\nother = 1,\nschool = 2,"
										+ "\nchore = 3,\nwork = 4 ");
					cat = k.nextShort();
					that.setCatagory(cat);
					
					System.out.println("\nWhat is the date it is due?\n"
					+ "Use this format: (month/day/year) \n"
					+ "ex. 01/05/2005");
					k.nextLine();
					d = k.nextLine();
					that.setDate(d);
					
					System.out.println("\nthe location");
					loc = k.nextLine();
					that.setLocation(loc);
					
					System.out.println("\nDescription of the task");
					des = k.nextLine();
					that.setDescription(des);
					
					System.out.println("\nHas this task been completed\n"
							+ "(y)yes"
							+ "(n)no");
					comp = k.nextLine().toLowerCase().charAt(0);
					that.complete(comp);
					
					//that.toString();
					
					//System.out.println("\nWould you like to add another task? \ny (for yes)\nn (for no)");
					//choice = k.nextLine().toLowerCase().charAt(0);
					
					
					
					try{	
						list.writeFile(fileName);
						}catch(FileNotFoundException e) {
							System.out.println("File \"" + fileName + "\" not found!");
							System.out.println("Dying....");
							e.printStackTrace();
							System.exit(-1);
						}
					//}
					//while(choice == 'y');
					
					
					break; 
					
			case 2:
						int i =100000;
					do{	
						System.out.println("\n Which task would you like removed? "
								     		+ "\nType the number of the task"
								     		+ " or type 0 to exit");
						try{
						i = k.nextInt();
						}catch(Exception e){
							System.out.println("Why did you put in the incorrect input"
									+ " Try Again!!!!!");
							k.nextLine();
							
						}
						
						list.reamoveTask(i);
						
					}
					while(i != 0);
					break;
					
			case 3:
				System.out.println("Here are the Tasks contained in your file/n");
				list.printTasks();
				break;
				
			case 4:
				
				int s = 10;
				
				do{
				System.out.println("What do you want to search for:\n"
						+ "(0)Exit\n"
						+ "(1)Priority\n"
						+ "(2)Date\n"
						+ "(3)Location\n"
						+ "(4)Catagory\n"
						+ "(5)Description\n"
						+ "(6)Completion\n ");
				
				s = k.nextInt();
				
				switch(s){
				
				default:
					s = 0;
					break;
				
				case 0:
					break;
					
				case 1:
					
					do{
					System.out.println("What priority level are you looking for: (0-3) "
							+ "or press 4 to exit");
					
					try{
						a = k.nextShort();
						}catch(Exception e){
							System.out.println("Why did you put in the incorrect input"
									+ " Try again!!!!!");
							k.nextLine();
							
						}
					
					list.searchByPriority(a);
					
					if(list.searchByPriority(a)!= null){
						System.out.println("Would you like to edit this object's priority: y or n");
						k.nextLine();
						
						choice = k.nextLine().toLowerCase().charAt(0);
						if(choice == 'y'){
							System.out.println("New Priority = ");
							cat = k.nextShort();
							that.setPriority(cat);
							list.writeFile(fileName);
						}
						
					}
					
					}
					while(a != 4);
					break;
		
				case 2:
					System.out.println("\nWhat is the date for the task you are looking for"
							+ " Use the format: (month day, year)");
					
					k.nextLine();
					desc = k.nextLine();
					
					list.searchByDate(desc);
					//System.out.println(list.searchByDate(desc));
					
					if(list.searchByDate(desc)!= null){
						System.out.println("Would you like to edit this object's due date: y or n");
						k.nextLine();
						
						choice = k.nextLine().toLowerCase().charAt(0);
						if(choice == 'y'){
							System.out.println("New Date = ");
							d = k.nextLine();
							that.setDate(d);
							list.writeFile(fileName);
						}
					}
					break;
					
				case 3:
					
					System.out.println("\nType the location for the task you are looking for");
					
					k.nextLine();
					desc = k.nextLine();
					
					list.searchByLocation(desc);
					//System.out.println(list.searchByLocation(desc));
					
					if(list.searchByLocation(desc)!= null){
						System.out.println("Would you like to edit this object's location: y or n");
						k.nextLine();
						
						choice = k.nextLine().toLowerCase().charAt(0);
						if(choice == 'y'){
							System.out.println("New Location = ");
							d = k.nextLine();
							that.setLocation(d);
							list.writeFile(fileName);
						}
					}
					break;
					
					
				case 4:
					
					do{
					System.out.println("What catagory level are you looking for: (0-5) "
							+ "or press 6 to exit");
					
					try{
						a = k.nextShort();
						}catch(Exception e){
							System.out.println("Why did you put in the incorrect input"
									+ " Try again!!!!!");
							k.nextLine();
							
						}
					
					list.searchByCatagory(a);
					//System.out.println(list.searchByPriority(a));
					
					if(list.searchByCatagory(a)!= null){
						System.out.println("Would you like to edit this object's catagory: y or n");
						k.nextLine();
						
						choice = k.nextLine().toLowerCase().charAt(0);
						if(choice == 'y'){
							System.out.println("New Catagory = ");
							cat = k.nextShort();
							that.setCatagory(cat);
							list.writeFile(fileName);
						}
					  }
					}
					while(a != 6);
					 break;
				
				case 5:
					
					System.out.println("\nType the description for the task you are looking for");
					
					k.nextLine();
					desc = k.nextLine();
					
					list.searchByDescription(desc);
					//System.out.println(list.searchByDescription(desc));
					
					if(list.searchByDescription(desc)!= null){
						System.out.println("Would you like to edit this object's description: y or n");
						k.nextLine();
						
						choice = k.nextLine().toLowerCase().charAt(0);
						if(choice == 'y'){
							System.out.println("New Description = ");
							d = k.nextLine();
							that.setDescription(d);
							list.writeFile(fileName);
						}
					}
					break;
					
				case 6:
					
					do{
					System.out.println("\nWhat copleted condition are you looking for?\n"
							+ "(y)True\n"
							+ "(n)False\n");
					k.nextLine();
					search = k.nextLine().toLowerCase().charAt(0);
					}
					while(search!= 'y' && search != 'n');
					
					if(search == 'y'){
						searc = true;
					}else if(search == 'n')
						searc = false;
					
					list.searchByCompletion(searc);
					break;
					
				}
				
			}
			while(s != 0);
				
		case 6:
			break;
			
		/*case 7:
		
		System.out.println("Which ")
			
		if(list.searchByCompletion(searc) != null){
			System.out.println("Would you like to edit this object's completion: y or n");
			k.nextLine();
			choice = k.nextLine().toLowerCase().charAt(0);
			if(choice == 'y'){
				System.out.println("New Completion(y or n) = ");
				comp = k.nextLine().toLowerCase().charAt(0);
				that.complete(comp);;
				list.writeFile(fileName);
			}
		}
		*/
				}
				
			
			
			//Sort Tasks by priority
				list.sortByPriority();
			
			}while(c != 0);
			
			
				
			
		}else if(c == 2){
		
			File myFile = new File(fileName);
			
			
			//do{	
				list.addTask(that);
				
				System.out.println("\nWhat is the priorety of this task 0-3");
				prio = k.nextShort();
				
				try{
				that.setPriority(prio);
				}catch(IllegalArgumentException e ){
					
					System.out.println("Why have you done this to me, I am now dead..........");
					System.exit(-1);
				}
				
				System.out.println("\nCatagory\nundefined = 0,\nother = 1,\nschool = 2,"
									+ "\nchore = 3,\nwork = 4 ");
				cat = k.nextShort();
				that.setCatagory(cat);
				
				System.out.println("\nWhat is the date it is due?\n"
				+ "Use this format: (month/day/year) \n"
				+ "ex. 01/05/2005");
				k.nextLine();
				d = k.nextLine();
				that.setDate(d);
				
				System.out.println("\nthe location");
				loc = k.nextLine();
				that.setLocation(loc);
				
				System.out.println("\nDescription of the task");
				des = k.nextLine();
				that.setDescription(des);
				
				System.out.println("\nHas this task been completed\n"
						+ "(y)yes"
						+ "(n)no");
				comp = k.nextLine().toLowerCase().charAt(0);
				that.complete(comp);
				
				that.toString();
				
				//System.out.println("\nWould you like to add another task? \ny (for yes)\nn (for no)");
				//choice = k.nextLine().toLowerCase().charAt(0);
				
				
				
				try{	
					list.writeFile(fileName);
					}catch(FileNotFoundException e) {
						System.out.println("File \"" + fileName + "\" not found!");
						System.out.println("Dying....");
						e.printStackTrace();
						System.exit(-1);
					}
				//}
				//while(choice == 'y');
				
				System.out.println("You sucessfully made the fisrst task for your new file.\n"
						+ "Restart and try option 1 for the full range of optons for you new task list");
		
		}
		
	}
}
	
	
	
	
		/*
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
		- Run through the program with the menu to be sure that all of your
		 listed options work the way you intend.
		
		*Extra details: Provide the abilities to delete and edit tasks! Fun!
		
		*Extra extra details: Add features. Make it fancy. Think about ways you might want to use a program like this and incorporate those ideas into your code.
		
		********This assignment is due on SUNDAY, January 31st at midnight!
		*
		*ask Task to print information
	*/
	
	

	
	
	
	
		
	
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

