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
		boolean TrueFalse, success = false;
		String input, fileName = "Tasks.txt";
		Date date = new Date();
		int ctr = 0;
		File file;
		short set;
		
		System.out.print("Welcome to the Task Manager! Would you like to...\n1. read your tasks\n2. create a new task list\n"
						+ "3. search for a specific task\n4. sort your tasks(enter number) ");
		set = keyboard.nextShort();

		switch (set) {
		case 1:
			do {
			System.out.print("Enter the name of the file you want to read from: ");
			input = keyboard.nextLine();			
				try {
					newTaskList.readFile(input);
					success = true;
				} catch (FileNotFoundException e) {
					System.out.print("The file " + input + " does not exist.");
				}
			} while( !success );
			break;
			
		case 2:
			success = false;
			do {
				System.out.print("Enter the name of the file you want to read from: ");
				input = keyboard.nextLine();
				fileName = input;
				file = new File(fileName);
				if (file.exists()) {
					System.out.print("Do you want to overwrite the existing file? (yes/no): ");
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
						System.out.print("The file " + input + " does not exist.");
						success = false;
					}
				}
			} while (!success);

			break;

		case 3:
			System.out.print("Do you want to search by...\n1. priority\n2. category\n3. description\n4. location\n5. "
					+ "state of completion\n(enter number) ");
			set = keyboard.nextShort();
			TaskList results = null ;
			
			// This switch is for when the user wants to search through their tasks
			switch (set) {
			case 1:
				System.out.print("Of priority...\n0. Undefined\n1. High\n2. Medium\n3. Low\n(enter number) ");
				set = keyboard.nextShort();
				results = newTaskList.searchPriority(set);
				break;
				
			case 2:
				System.out.print("In category...\n0. Undefined\n1. Other\n2. School\n3. Personal\n4. Chore\n5. Work\n(enter number) ");
				set = keyboard.nextShort();
				results = newTaskList.searchCategory(set);
				break;
			
			case 3:
				System.out.print("With description...\n(enter description) ");
				input = keyboard.nextLine();
				results = newTaskList.searchDescription(input);
				break;
			
			case 4:
				System.out.print("With location...\n(enter location) ");
				input = keyboard.nextLine();
				results = newTaskList.searchLocation(input);
				break;
			
			case 5:
				System.out.print("That are...\nY. Complete\nN. Incomplete\n(enter letter) ");
				input = keyboard.nextLine().toLowerCase();
				results = newTaskList.searchCompleted(input);
				break;
			}
			results.printTasks();
			break;
			
		case 4:
			//newTaskList.sortPriority();
			break;			
		}

		/*
		 * menu:
		 * 
		 * hard part: sort by priority so they can print tasks in priority order
		 * 
		 * fix date format
		 */

		do {
			Task newTask = new Task();

			System.out.print("Enter priority (1-3): ");
			set = keyboard.nextShort();
			newTask.setPriority(set);
			
			keyboard.nextLine(); // eat line
			
			do {
				success = false;
				System.out.print("Enter due date (mm dd, yyyy): ");
				input = keyboard.nextLine();
				try {
					date = format.parse(input);
					success = true;
					newTask.setDueDate(date);
				} catch (ParseException e) {
					System.out.print("Could not parse date.");
					success = false;
				}
			} while (!success);

			System.out.print("Enter category (1-5): ");
			set = keyboard.nextShort();
			newTask.setCategory(set);

			keyboard.nextLine(); // eat line

			System.out.print("Enter description: ");
			input = keyboard.nextLine();
			newTask.setDescription(input);

			System.out.print("Enter location (return for none): ");
			input = keyboard.nextLine();
			newTask.setLocation(input);

			System.out.print("Enter state of completion (type true or false): ");
			TrueFalse = keyboard.nextBoolean();
			newTask.setCompleted(TrueFalse);

			keyboard.nextLine();

			newTaskList.addTask(newTask);

			System.out.print("Do you want to enter another task? (yes/no): ");
			input = keyboard.nextLine().toLowerCase();

		} while (input.charAt(0) == 'y');

		newTaskList.printTasks();

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

		keyboard.close();

		System.exit(0);

	}

}
