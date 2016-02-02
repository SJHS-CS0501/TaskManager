import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This program is designed to allow
 * a user to enter a set of tasks and
 * then they have a choice of options
 * to affect the actions.
 * @param args
 * @author Jack Protivnak
 */

public class TaskManager {
	public static void main(String[] args) {
		// main stuff goes here, yo
		System.out.println("Welcome to the Task Manager!");

		// All objects are defined
		TaskList taskList = new TaskList();
		String decide = null, filename = "Task.txt", saveOrNaw = null, input = null;
		short temp, choice = 0, temp2;
		boolean tempB;
		int i = 0, ten = 10, foo;
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
		DateFormat printFormat = new SimpleDateFormat("EEE MMM dd, yyyy", Locale.ENGLISH);
		Scanner keyboard = new Scanner(System.in);

		// This do-while loop will control the entire program and allows the menu
		// to be possible and repeat for the user.
		do {
			System.out.println("\nPlease select your function: \n\t1 - Load the task list from file\n\t2 -"
					+ " Save task list to file\n\t3 - Add task to Task List\n\t4 - Print task list\n\t5 - "
					+ "Search for tasks\n\t6 - Sort Task List by priority\n\t7 - Mark tasks as completed\n"
					+ "\t8 - Remove a task from the list\n\t9 - Edit a task\n\t10 - Exit");
			choice = keyboard.nextShort();
			keyboard.nextLine();

			// This switch will control the choices of 
			// the user based on what they want to do to 
			// their tasks and task list.
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
					System.out.println( "Please enter the following:" );
					System.out.println();

					System.out.println("Descrption: ");
					input = keyboard.nextLine();
					task.setDescription(input);

					System.out.println("Location: ");
					input = keyboard.nextLine();
					task.setLocation(input);

					System.out.println("Priority (as number):\n\t0 - Undefined\n\t1 - High\n\t2 - Medium\n\t3 - Low");
					input = keyboard.nextLine();
					temp = Short.parseShort(input);
					task.setPriority(temp);

					System.out.println("Category \n\t0 - Undefined"
							+ "\n\t1 - Other\n\t2 - School\n\t3 - Personal\n\t4 - Chore\n\t5 - Work: ");
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

					System.out.println("Due Date (MMM DD, YYYY): ");
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
					System.out.println( "Please enter which priority you would like to search by:"
							+ "\n\t0 - Undefined\n\t1 - High\n\t2 - Medium\n\t3 - Low" );
					temp = keyboard.nextShort();
					taskList.searchByPriority(temp).printTasks();
					break;
				case 2:
					System.out.println("Please enter the date you would like to search for (MMM DD, YYYY): ");
					input = keyboard.nextLine();
					keyboard.nextLine();
					try {
						d = format.parse(input);
						if (d == null) {
							System.out.println("date is null");
							break;
						} else {
							System.out.println(taskList.searchByDueDate(d));
						}
					} catch (ParseException e) {
						System.out.println("Unacceptable date! You loose!");
					}
					break;
				case 3:
					System.out.println("Please enter the category you'd like to search by:\n\t0 - Undefined"
							+ "\n\t1 - Other\n\t2 - School\n\t3 - Personal\n\t4 - Chore\n\t5 - Work");
					temp = keyboard.nextShort();
					taskList.searchByCategory(temp).printTasks();
					break;
				case 4:
					System.out.println("Please enter the description you'd like to search for: ");
					input = keyboard.nextLine();
					keyboard.nextLine();
					taskList.searchByDescription(input);
					break;
				case 5:
					System.out.println("Please enter the location you'd like to search for: ");
					input = keyboard.nextLine();
					keyboard.nextLine();
					taskList.searchByLocation(input);
					break;
				case 6:
					System.out.println("Would you like to search for completed or uncompleted tasks?"
							+ " (y for completed and n for uncompleted): ");
					input = keyboard.nextLine();
					keyboard.nextLine();
					if (input.equals('y')) {
						taskList.searchByCompleted(true).printTasks();
					} else {
						taskList.searchByCompleted(false).printTasks();
					}
					break;
				}
				break;

			case 6:
				System.out.println("Task List has been sorted by: Undefined/High/Medium/Low");
				taskList.sortByPriority();
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
				System.out.println("Please enter the number of the task you would like to edit: ");
				foo = keyboard.nextInt();
				System.out.println("Please enter the number of what you would like to edit: \n\t1 - Priority\n\t"
						+ "2 - Due Date\n\t3 - Category\n\t4 - Description\n\t5 - Location\n\t6 - Completed");
				temp2 = keyboard.nextShort();
				System.out.println("Please enter what you would like to change this field to: ");
				input = keyboard.nextLine();
				keyboard.nextLine();
				switch (temp2) {
				case 1:
					taskList.getTask(foo).setPriority(Short.parseShort(input));
					break;
				case 2:
					try {
						taskList.getTask(foo).setDueDate(format.parse(input));
					} catch (ParseException e) {
						System.out.println("Die");
					}
					break;
				case 3:
					taskList.getTask(foo).setCategory(Short.parseShort(input));
					break;
				case 4:
					taskList.getTask(foo).setDescription(input);
					break;
				case 5:
					taskList.getTask(foo).setLocation(input);
					break;
				case 6:
					if (input == "y") {
						taskList.getTask(foo).setCompleted(true);
					} else {
						taskList.getTask(foo).setCompleted(false);
					}
				}

			default:
				System.exit(0);
			}
		} while (choice != ten);

		keyboard.close();
		System.exit(0);
	}
}
