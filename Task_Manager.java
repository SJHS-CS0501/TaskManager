import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
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

	
	public static void main(String[] args) throws Exception {
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
			list.writeFile(fileName);
			}catch(FileNotFoundException e) {
				System.out.println("File \"" + fileName + "\" not found!");
				System.out.println("Dying....");
				e.printStackTrace();
				System.exit(-1);
			}
		
	
		k.close();
		System.exit(0);
		
	}

}
