import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * do these things:
 * - keep list of tasks
 * - allow user to add/remove tasks
 * - allow user to prioritize tasks
 * - print out lists of tasks
 * 
 * list of tasks:
 * - read and store on disk
 * - sort/search
 * 
 * reports:
 * - list high priority
 * - list due today/soon
 * - list all(by date OR by priority)
 */

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
		String input, fileName = "Tasks.txt";
		boolean TrueFalse, success = false;
		TaskList results = null ;
		Date date = new Date();
		int number;
		File file;
		short set;
		
		//first menu
		System.out.println("Welcome to the Task Manager! Would you like to...\n1. read your tasks\n2. create a new task list\n"
						+ "3. search for a specific task\n4. sort your tasks\n5. mark a task as completed\n6. exit program\n(enter number) ");
		set = keyboard.nextShort();

		switch (set) {
		case 1: //if user wants to read tasks
			do {
			System.out.println("Enter the name of the file you want to read from: ");
			input = keyboard.nextLine();			
				try {
					results = newTaskList.readFile(input);
					success = true;
				} catch (FileNotFoundException e) {
					System.out.println("The file " + input + " does not exist.");
				}
			} while( !success );
			try {
				results.printTasks();
			} catch (NullPointerException e) {
				System.out.println("Cannot print tasks.");
			}
			System.exit(0);
			
		case 2: //if user wants to create a new task list
			success = false;
			do {
				System.out.println("Enter the name of the file you want to write to: ");
				input = keyboard.nextLine();
				fileName = input;
				file = new File(fileName);
				if (file.exists()) {
					System.out.println("Do you want to overwrite the existing file? (yes/no): ");
					input = keyboard.nextLine().toLowerCase();
					if (input.charAt(0) == 'y') {
						success = true;
					}
				} else {
					success = true;
				}
				if (success) {
					try {
						newTaskList.writeFile(fileName);
						success = true;
					} catch (FileNotFoundException e) {
						System.out.println("The file " + input + " does not exist.");
						success = false;
					}
				}
			} while( !success );
			break;
			
		case 3: //if user wants to search for a specific task
			System.out.println("Do you want to search by...\n1. priority\n2. category\n3. description\n4. location\n5. "
					+ "state of completion\n(enter number) ");
			set = keyboard.nextShort();
			
			// This switch is for when the user wants to search through their tasks
			switch (set) {
			case 1: //if user wants to search by priority
				System.out.println("Of priority...\n0. Undefined\n1. High\n2. Medium\n3. Low\n(enter number) ");
				set = keyboard.nextShort();
				results = newTaskList.searchPriority(set);
				break;
				
			case 2: //if user wants to search by category
				System.out.println("In category...\n0. Undefined\n1. Other\n2. School\n3. Personal\n4. Chore\n5. Work\n(enter number) ");
				set = keyboard.nextShort();
				results = newTaskList.searchCategory(set);
				break;
			
			case 3: //if user wants to search by description
				System.out.println("With description...\n(enter description) ");
				input = keyboard.nextLine();
				results = newTaskList.searchDescription(input);
				break;
			
			case 4: //if user wants to search by location
				System.out.println("With location...\n(enter location) ");
				input = keyboard.nextLine();
				results = newTaskList.searchLocation(input);
				break;
			
			case 5: //if user wants to search by completion
				System.out.println("That are...\nY. Complete\nN. Incomplete\n(enter letter) ");
				input = keyboard.nextLine().toLowerCase();
				results = newTaskList.searchCompleted(input);
				break;
			}
			results.printTasks();
			System.exit(0);
			
		case 4: //if user wants to sort tasks by priority
			TaskList.sortPriority();
			break;
			
		case 5: //if user wants to mark a task as completed
			do {
				do {
					System.out.println("Enter the name of the file you want to read from: ");
					input = keyboard.nextLine();
					try {
						newTaskList.readFile(input);
						success = true;
					} catch (FileNotFoundException e) {
						System.out.println("The file " + input + " does not exist.");
					}
				} while (!success);
				
				System.out.println("Which task do you want to mark as completed? (enter number [1 = first, 2 = second, etc.]): ");
				number = keyboard.nextShort();
				number = (number - 1);
				try {
					newTaskList.completed(number);
					success = true;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Invalid number entered.");
					success = false;
				}
			} while (!success);
			try {
				newTaskList.readFile(input);
			} catch (FileNotFoundException e) {
				System.out.println("Cannot read file.");
			}
			System.exit(0);
			
		case 6: //if user wants to exit program
			System.exit(0);
		}
		
		//creating a new task
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
			} while( !success );

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

			newTaskList.addTask(newTask);

			System.out.println("Do you want to enter another task? (yes/no): ");
			input = keyboard.nextLine().toLowerCase();

		} while (input.charAt(0) == 'y');

		newTaskList.printTasks();
/*
 	debug stuff
		try {
			newTaskList.writeFile(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + fileName + "\" not found");
			System.out.println("Dying...");
			e.printStackTrace();
			System.exit(-1);
		}

		newTaskList = new TaskList();

		System.out.println("Before read: ");
		newTaskList.printTasks();

		try {
			newTaskList.readFile(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + fileName + "\" not found");
			System.out.println("Dying...");
			e.printStackTrace();
			System.exit(-1);
		}
*/
		keyboard.close();

		System.exit(0);

	}

}