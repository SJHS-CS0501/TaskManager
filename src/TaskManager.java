import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This program will assist the user to manage their tasks. (organize, sort,
 * delete, add).
 * 
 * @author Julianna Nichols
 */

public class TaskManager {

	/**
	 * This is the main method for the TaskManager program.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("mm dd, yyyy", Locale.ENGLISH);
		Scanner keyboard = new Scanner(System.in);
		TaskList newTaskList = new TaskList();
		String input = null, fileName = "tasks.txt";
		boolean TrueFalse, success = false;
		TaskList results = null;
		Date date = new Date();
		int number;
		File file;
		short set;

	do {
		// first menu
		System.out.println(
				"Welcome to the Task Manager! Would you like to...\n1. load your tasks\n2. add task to task list\n"
						+ "3. search for a specific task\n4. sort your tasks\n5. save tasks to disk\n6. mark a task "
						+ "as completed\n7. exit program\n(enter number) ");
		set = keyboard.nextShort();

		switch (set) {
		case 1: // if user wants to read tasks
			newTaskList = new TaskList();
				try {
					newTaskList.readFile(fileName);
					success = true;
				} catch (FileNotFoundException e) {
					System.out.println("The file " + fileName + " does not exist.");
				}
				newTaskList.printTasks();
				break;

		case 2: // if user wants to add Task to their tasks
			do {
				Task newTask = new Task();

				System.out.println("Enter priority (1-3) [undefined (0), high (1), medium (2), low (3)]: ");
				set = keyboard.nextShort();
				newTask.setPriority(set);

				keyboard.nextLine(); // eat line

				do {
					success = false;
					System.out.println("Enter due date (mm dd, yyyy): ");
					input = keyboard.nextLine();
					try {
						date = format.parse(input);
						success = true;
						newTask.setDueDate(date);
					} catch (ParseException e) {
						System.out.println("Could not parse date.");
						success = false;
					}
				} while (!success);

				System.out.println("Enter category (1-5) [underfined (0), other (1), school (2), personal (3), chore (4), work (5)]: ");
				set = keyboard.nextShort();
				newTask.setCategory(set);

				keyboard.nextLine(); // eat line

				System.out.println("Enter description: ");
				input = keyboard.nextLine();
				newTask.setDescription(input);

				System.out.println("Enter location (return for none): ");
				input = keyboard.nextLine();
				newTask.setLocation(input);

				System.out.println("Enter state of completion (type true or false): ");
				TrueFalse = keyboard.nextBoolean();
				newTask.setCompleted(TrueFalse);

				keyboard.nextLine();

				newTaskList.addTask(newTask); //adding task to taskList

				System.out.println("Do you want to enter another task? (yes/no): ");
				input = keyboard.nextLine().toLowerCase();

			} while (input.charAt(0) == 'y');

			newTaskList.printTasks();
			break;

		case 3: // if user wants to search for a specific task
			System.out.println("Do you want to search by...\n1. priority\n2. category\n3. description\n4. location\n5. "
					+ "state of completion\n(enter number) ");
			set = keyboard.nextShort();

			// This switch is for when the user wants to search through their tasks
			switch (set) {
			case 1: // if user wants to search by priority
				System.out.println("Of priority...\n0. Undefined\n1. High\n2. Medium\n3. Low\n(enter number) ");
				set = keyboard.nextShort();
				results = newTaskList.searchPriority(set);
				break;

			case 2: // if user wants to search by category
				System.out.println(
						"In category...\n0. Undefined\n1. Other\n2. School\n3. Personal\n4. Chore\n5. Work\n(enter number) ");
				set = keyboard.nextShort();
				results = newTaskList.searchCategory(set);
				break;

			case 3: // if user wants to search by description
				System.out.println("With description...\n(enter description) ");
				input = keyboard.nextLine();
				results = newTaskList.searchDescription(input);
				break;

			case 4: // if user wants to search by location
				System.out.println("With location...\n(enter location) ");
				input = keyboard.nextLine();
				results = newTaskList.searchLocation(input);
				break;

			case 5: // if user wants to search by completion
				System.out.println("That are...\nY. Complete\nN. Incomplete\n(enter letter) ");
				input = keyboard.nextLine().toLowerCase();
				results = newTaskList.searchCompleted(input);
				break;
			}
			results.printTasks();
			break;

		case 4: // if user wants to sort tasks by priority
			TaskList.sortPriority(); //calling on method to sort tasks
			TaskList.printTasks(); //printing sorted list
			break;
			
		case 5: //if user wants to save tasks to disk
			try {
				newTaskList.writeFile(fileName);
			} catch(FileNotFoundException e) {
				System.out.print( "File not found." );
				System.exit(-1);
			}
			break;

		case 6: // if user wants to mark a task as completed
				System.out.println("Which task do you want to mark as completed? (enter number [1 = first, 2 = second, etc.]): ");
				number = (keyboard.nextShort()-1);
				newTaskList.getTask(number).setCompleted(true); //calling method to set specified task to true (completed)
				break;

		default: // if user wants to exit program
			System.exit(0);
		}
		
	} while( set!= 7 );

		keyboard.close();

		System.exit(0);

	}

}