import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 
 */

/*
 * Task Manager Program
 * 
 * Do these things
 * - Keep a list of tasks
 * - Allow user to add and remove tasks
 * - Allow user to reprioritze tasks
 * - Print out lists of tasks
 * 
 * List of tasks:
 * - Read and Store on disk
 * - Sort
 * - Search
 * 
 * Reports:
 * - List high priority
 * - List due today/soon
 * - List all (by date OR by priority)
 * 
 */

/**
 * @author Jack Protivnak
 *
 */
public class TaskManager {
	/*
	 * Menu (text)
	 * 
	 * read from file -add task to existing after reading -create new tasks and
	 * add to file -can ask user for task file name -ask if they want to
	 * overwrite -save file?
	 * 
	 * start task list
	 * 
	 * search from tasks
	 * 
	 * implement sort by priority -can sort class by priority
	 */
	public static void main(String[] args) {
		// main stuff goes here, yo
		System.out.println("Welcome to the Task Manager!");

		TaskList taskList = new TaskList();
		String name = null, y = "y", description = null, decide = null, filename = "Task.txt", saveOrNaw = null,
				t = null, input = null;
		short temp, choice = 0, temp2;
		boolean truth, tempB, compairson = false, yesOrNo;
		int i = 0, ten = 10;
		Date d = new Date();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
		DateFormat printFormat = new SimpleDateFormat("EEE MMM dd, yyyy", Locale.ENGLISH);
		Scanner keyboard = new Scanner(System.in);

		do {
			System.out.println("\nPlease select your function: \n\t1 - Load the task list from file\n\t2 -"
					+ " Save task list to file\n\t3 - Add task to Task List\n\t4 - Print task list\n\t5 - "
					+ "Search for tasks\n\t6 - Sort Task List by priority\n\t7 - Mark tasks as completed\n"
					+ "\t8 - Remove a task from the list\n\t9 - Edit a task\n\t10 - Exit");
			choice = keyboard.nextShort();

			switch (choice) {
			case 1:
				taskList = new TaskList();
				try {
					taskList.readFile(filename, printFormat);
				} catch (FileNotFoundException e) {
					System.out.println("file \"" + filename + "\" not found!");
					System.out.println("Dying...");
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					taskList.writeFile(filename);
				} catch (FileNotFoundException e) {
					System.out.println("File \"" + filename + "\" not found!");
					System.out.println("Dying...");
					e.printStackTrace();
					System.exit(-1);
				}
				break;

			case 3:
				do {
					Task task = new Task();
					decide = null;
					input = null;

					System.out.println("Descrption: ");
					input = keyboard.nextLine();
					task.setDescription(input);
					keyboard.nextLine();

					System.out.println("Location: ");
					input = keyboard.nextLine();
					task.setLocation(input);

					System.out.println("Priority (as number) [1-3]");
					input = keyboard.nextLine();
					temp = Short.parseShort(input);
					task.setPriority(temp);

					System.out.println("Category [1-5]: ");
					input = keyboard.nextLine();
					temp = Short.parseShort(input);
					task.setCategory(temp);

					System.out.println("Completed (y or n): ");
					input = keyboard.nextLine();
					if (input == "y") {
						tempB = true;
					} else {
						tempB = false;
					}
					task.setCompleted(tempB);

					System.out.println("Due Date: ");
					input = keyboard.nextLine();
					task.setDateFormat(printFormat);
					try {
						task.setDueDate(format.parse(input));
					} catch (ParseException e) {
						System.out.println("Die");
					}

					taskList.addTask(task);

					System.out.println("Would you like to add another task? y/n: ");
					decide = keyboard.nextLine().toLowerCase();
					System.out.println();

				} while (decide.charAt(0) == 'y');

				System.out.println("You have just added new tasks! Would you like to save them to file? (y/n): ");
				saveOrNaw = keyboard.nextLine();
				if (saveOrNaw.charAt(0) == 'y') {
					try {
						taskList.writeFile(filename);
					} catch (FileNotFoundException e) {
						System.out.println("File \"" + filename + "\" not found!");
						System.out.println("Dying...");
						e.printStackTrace();
						System.exit(-1);
					}
				}
				break;

			case 4:
				taskList.printTasks();
				break;

			case 5:
				System.out.println("How would you like to search for your task?\n\t1 - Priority\n\t"
						+ "2 - Due Date\n\t3 - Category\n\t4 - Description\n\t5 - Location\n\t6 - Completed");
				temp = keyboard.nextShort();

				switch (temp) {
				case 1:
					System.out.println(
							"Please enter which priority you would like to search by:\n\t1 - High\n\t2 - Medium\n\t3 - Low\n\t4 - Undefined");
					temp = keyboard.nextShort();
					taskList.searchByPriority(temp);
					break;
				case 2:
					System.out.println("Please enter the date you would like to search for (MMM DD, YYYY): ");
					input = keyboard.nextLine();
					try {
						d = format.parse(input);
					} catch (ParseException e) {
						System.out.println("Unacceptable date! You loose!");
					}
					taskList.searchByDueDate(d);
					break;
				case 3:
					System.out.println("Please enter the category you'd like to search by:\n\t0 - Undefined"
							+ "\n\t1 - Other\n\t2 - School\n\t3 - Personal\n\t4 - Chore\n\t5 - Work");
					temp = keyboard.nextShort();
					taskList.searchByCategory(temp);
					break;
				case 4:
					System.out.println("Please enter the description you'd like to search for: ");
					input = keyboard.nextLine();
					taskList.searchByDescription(input);
					break;
				case 5:
					System.out.println("Please enter the location you'd like to search for: ");
					input = keyboard.nextLine();
					taskList.searchByLocation(input);
					break;
				case 6:
					System.out.println("Would you like to search for completed or uncompleted tasks? (y/n): ");
					input = keyboard.nextLine();
					if (input.equals('y')) {
						taskList.searchByCompleted(true);
					} else {
						taskList.searchByCompleted(false);
					}
					break;
				}
				break;

			case 6:
				System.out.println("Task List has been sorted by: Undefined/High/Medium/Low");
				taskList.equals(taskList.sortByPriority());
				break;

			case 7:
				System.out.println("Please enter the number of the task you would like to mark as completed: ");
				temp = keyboard.nextShort();
				taskList.setAsCompleted(temp);
				break;

			case 8:
				System.out.println("Please enter the number of the task you would like delete: ");
				i = keyboard.nextInt();
				taskList.removeTask(i);
				break;
				
			case 9:
				System.out.println( "Please enter the number of the task you would like to edit: " );
				temp = keyboard.nextShort();
				System.out.println( "Please enter the number of what you would like to edit: \n\t1 - Priority\n\t"
						+ "2 - Due Date\n\t3 - Category\n\t4 - Description\n\t5 - Location\n\t6 - Completed");
				temp2 = keyboard.nextShort();
				System.out.println( "Please enter what you would like to change this field to: ");
				input = keyboard.nextLine();
				switch(temp2) {
					case 1:
						taskList.get(temp).setPriority(Short.parseShort(input));
				}

			default:
				System.exit(0);
			}
		} while (choice != ten);

		/*
		 * System.out.println(
		 * "Please enter the name of your new file ending with .txt: " );
		 * tempFileName = keyboard.nextLine(); if( tempFileName.equals(filename)
		 * ) { System.out.println(
		 * "The file name you have entered is already taken. Are you sure you'd like to continue? (y/n): "
		 * ); }
		 * 
		 * do{ for( int ctr = 0; ctr < tempFileName.length(); ctr++ ) { while(
		 * tempFileName.charAt(ctr) == filename.charAt(ctr) ) { i++; } } }
		 * while(compairson == true);
		 */
		/*
		 * taskList.printTasks();
		 * 
		 * 
		 * try{ taskList.writeFile(filename); } catch( FileNotFoundException e )
		 * { System.out.println( "File \"" + filename + "\" not found!" );
		 * System.out.println( "Dying..." ); e.printStackTrace();
		 * System.exit(-1); }
		 * 
		 * taskList = new TaskList();
		 * 
		 * System.out.println( "Before read: " ); taskList.printTasks();
		 * 
		 * try { taskList.readFile( filename, printFormat ); } catch(
		 * FileNotFoundException e ) { System.out.println( "file \"" + filename
		 * + "\" not found!" ); System.out.println( "Dying..." );
		 * e.printStackTrace(); }
		 * 
		 */
		keyboard.close();
		System.exit(0);
	}
}

/*
 * ERASE FROM HERE TO THERE WHEN DONE TESTING TASK
 * 
 * Task foo = new Task(); foo.setDescription( "Test Task" ); try { // What we
 * want to try that might throw an exception foo.setPriority( (short)12 ); }
 * catch( Exception e ) { // What to do if we catch the exception
 * System.out.println( "Error setting priority: " + e.getMessage() );
 * //System.exit(-1); }
 * 
 * // time passes...
 * 
 * System.out.println( "Task info: " ); System.out.println( "\tTask: " +
 * foo.getDescription() ); System.out.println( "\t\tPriority: " +
 * foo.getPriorityName() );
 * 
 * 
 * THERE
 */

// Allow user to make 4 tasks
