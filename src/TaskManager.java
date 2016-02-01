import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 */

/*
 * Task Manager Program
 * Do this:
 * -Keep a list of tasks
 * -Allow user to add and remove tasks
 * -Print out list of tasks
 * 
 * Menu:
 * -read/add tasks
 * -add task
 * -save file
 * -create new task list and add to file
 * -add search menu items
 * -implement sortByPriority method
 * 
 * List of tasks:
 * -Read and Store on disk
 * -Sort
 * -Search
 * 
 * Reports:
 * -List high priority
 * -List due today/soon
 * -List all(by date OR by priority)
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class TaskManager {
	
	/**
	 * @param args
	 */
	public static void main(String [] args) {
                //declarations and initializations
		Scanner keyboard = new Scanner(System.in);
		String filename = "file.txt";
		String d;
		Date n = new Date();
		Date userDate = new Date();
		DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
		short p;
		TaskList tL = new TaskList();
		Task t = new Task();
		char next;
		int option = 0;
		File myFile = new File(filename);
		
		System.out.println("Welcome to the Task Manager!");
		
		menu(option); //calling method to display menu
		
                //do-while loop
		do{
			System.out.println("Enter your selection: ");
			option = keyboard.nextInt();
			switch (option) { //switch statement for menu selections
			case 0:
				System.exit(0);
				break;
			case 1:
				try {
					tL.writeFile( filename );
				} catch(FileNotFoundException e) {
					System.out.println("File not found, MAJOR FAIL!!!");
					e.printStackTrace();
				}
				break;
			case 2:
				tL.addTask(t);
				System.out.println("Please enter a description for new task: ");
				d = keyboard.nextLine();
				t.setDescription(d);
				System.out.println("Please enter a priority for this task (1-3): ");
				p = keyboard.nextShort();
				t.setPriority(p);
				System.out.println("Please enter a category for this task (1-5): ");
				p = keyboard.nextShort();
				keyboard.nextLine();
				t.setCategory(p);
				System.out.println("When is your task due? (MMM dd, yyyy) ");
				d = keyboard.nextLine();
				try {
					n = format.parse(d);
				} catch (ParseException e) {
					System.out.println("Cannot parse date");
					e.printStackTrace();
				}
				System.out.println("Enter a location for this task: ");
				d = keyboard.nextLine();
				t.setLocation(d);
				tL.printTasks();
				try {
					tL.writeFile(filename);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

                        case 3:
                                File newFile = new File(newFile.txt); //creating new file
                                System.out.println("Enter file name for new file: ");
                                newFile = keyboard.nextLine();
                                tL.addTask(t);
				System.out.println("Please enter a description for new task: ");
				d = keyboard.nextLine();
				t.setDescription(d);
				System.out.println("Please enter a priority for this task (1-3): ");
				p = keyboard.nextShort();
				t.setPriority(p);
				System.out.println("Please enter a category for this task (1-5): ");
				p = keyboard.nextShort();
				keyboard.nextLine();
				t.setCategory(p);
				System.out.println("When is your task due? (MMM dd, yyyy) ");
				d = keyboard.nextLine();
                                tL.printTasks();
				try {
					tL.writeFile(newFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter descrioption of task: ");
				d = keyboard.nextLine();
				tL.searchByDescription(d);
				System.out.println(t.toString());
				break;
			case 5:
				System.out.println("Enter a file name to load: ");
				filename = keyboard.nextLine();
				if(myFile.exists()) {
					System.out.println("File exists.  Overwrite " + filename + "? If so press y: ");
					next = keyboard.nextLine().toLowerCase().charAt(0);
					if(next != 'y') {
						System.out.println("File not overwritten. Have a nice day!");
						break;
                        case 6:
                                //sortByPriority(p);
                                break:
					}
					}
				
			}
			/*tL.addTask(t);
			System.out.println("Please enter a description for new task: ");
			d = keyboard.nextLine();
			t.setDescription(d);
			System.out.println("Please enter a priority for this task (1-3): ");
			p = keyboard.nextShort();
			t.setPriority(p);
			System.out.println("Please enter a category for this task (1-5): ");
			p = keyboard.nextShort();
			keyboard.nextLine();
			t.setCategory(p);
			System.out.println("When is your task due? (MMM dd, yyyy) ");
			d = keyboard.nextLine();
			try {
				n = format.parse(d);
			} catch (ParseException e) {
				System.out.println("Cannot parse date");
				e.printStackTrace();
			}
			System.out.println("Enter a location for this task: ");
			d = keyboard.nextLine();
			t.setLocation(d);*/
			System.out.println("Would you like to go on? If so, press y: ");
			next = keyboard.nextLine().toLowerCase().charAt(0);
			tL.printTasks();
		}  while(next == 'y');
		
		tL.printTasks();
		
		try {
			tL.writeFile( filename );
		} catch(FileNotFoundException e) {
			System.out.println("File \"" + filename + "\"not found");
			System.out.println("Dying...");
			e.printStackTrace();
			System.exit(-1);
		}
		
		tL = new TaskList();
		
		System.out.println("Before read: ");
		tL.printTasks();
		
		try{
			tL.readFile(filename);
		} catch(FileNotFoundException e) {
			System.out.println("file \"" + filename + "\" not found!");
			System.out.println("Dying...");
			
		}
		
		System.exit(0);
	}
	
	public static void menu(int option) {
		
		System.out.println("If you want to: ");
		System.out.println("Read a task from disk, press 1 ");
		System.out.println("Add a new task to file, press 2 ");
		System.out.println("Create a new task list, press 3 ");
		System.out.println("Search for tasks by description, press 4 ");
		System.out.println("Load new file, press 5 ");
		System.out.println("Sort by priority, press 6 "); //still trying to figure out how to do this.
		System.out.println("Quit, press 0 ");
	}

}
