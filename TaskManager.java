/**
 * A program that manages tasks
 * @author Ryan Luchs
 * 
 */

import java.util.Date;
import java.util.Scanner;
import java.io.*;

/*
 * Task Manager Program
 * 
 * Do these things:
 * - Keep a list of tasks
 * - Allow user to add and remove tasks
 * - Allow user to reprioritize tasks
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
 * TaskManager main class
 * @author Ryan Luchs
 *
 */
public class TaskManager {

	/**
	 * TaskManager main method
	 * @param args
	 */
	
	public static void main(String[] args) {
		boolean run = true;
		
		final String DEFAULT_FILENAME = "tasklist.txt";
		
		TaskList tasks = null;
		String[] command;
		
		// Scanner for keyboard input
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Welcome to Task Manager\nEnter \"help\" for a list of commands\n");
		
		while(run) {
			System.out.print("> ");
			command = scan.nextLine().toLowerCase().split(" ");
			
			if(command.length != 0)
			switch(command[0]) {
				case "exit":
					run = false;
					break;
					
				case "help":
					if(command.length == 1) {
						System.out.print(CommandHelp.getHelpText());
					} else {
						System.out.print(CommandHelp.getCommandText(command[1]));
					}
					break;
					
				case "open":
					if(tasks == null) {
						if(command.length > 1) {			
							try {
								tasks = new TaskList(command[1]);
								System.out.printf("File \"%s\" was successfully opened\n\n", command[1]);
								tasks.print();
							} catch(FileNotFoundException e) {
								System.out.printf("File \"%s\" could not be found\n", command[1]);
							}
						} else {
							System.out.print("No file specified, defaulting...\n");
							try {
								tasks = new TaskList(DEFAULT_FILENAME);
								System.out.print("Opened default file\n\n");
								tasks.print();
							} catch(FileNotFoundException e) {
								System.out.print("Default file could not be found, someone's been tampering with my program...\n");
							}
						}
					} else {
						System.out.printf("Opening a new file will erase any changes made since the last save\nAre you sure you want to open a new file?\n");
						if(confirmed(scan)){
							if(command.length > 1) {			
								try {
									tasks = new TaskList(command[1]);
									System.out.printf("File \"%s\" was successfully opened\n\n", command[1]);
									tasks.print();
								} catch(FileNotFoundException e) {
									System.out.printf("File \"%s\" could not be found\n", command[1]);
								}
							} else {
								System.out.print("No file specified, defaulting...\n");
								try {
									tasks = new TaskList(DEFAULT_FILENAME);
									System.out.print("Opened default file\n\n");
									tasks.print();
								} catch(FileNotFoundException e) {
									System.out.print("Default file could not be found, someone's been tampering with my program...\n");
								}
							}
						}
					}
					break;
					
				case "print":
					if(tasks != null) {
						System.out.print('\n');
						tasks.print();
					} else {
						System.out.print("There is no file open\n");
					}
					break;
					
				default:
					System.out.printf("Operation %s not supported. Enter \"help\" for a list of commands\n", command[0]);
			}
		}
		
//		int y = 0;
//		int m = 0;
//		int d = 0;
//		boolean quit = false;
//		String filename = "tasklist.txt";
//		
//		System.out.println("Welcome to the Task Manager!");
		
//		System.out.print("Do you want to create a new file? (y/n):");
//		if(scan.nextLine().toLowerCase().equals("y")) {
//			
//		}
		
//		do {
//			// New Task
//			Task task = new Task();
//			System.out.println("Create a new task:");
//			
//			// Get Description
//			System.out.print("Description: ");
//			task.setDescription(scan.nextLine());
//			
//			// Get Priority
//			System.out.print("Priority (1-3): ");
//			task.setPriority(scan.nextShort());
//			
//			// Get Date
//			System.out.println("Due Date:");
//			System.out.print("Year: ");
//			y = scan.nextInt();
//			System.out.print("Month: ");
//			m = scan.nextInt();
//			System.out.print("Date: ");
//			d = scan.nextInt();
//			
//			task.setDueDate(new Date(y - 1900, m, d));
//			
//			// Get Category
//			System.out.print("Category (1-5): ");
//			task.setCategory(scan.nextShort());
//			scan.nextLine();
//			
//			// Get Location	
//			System.out.print("Location: ");
//			task.setLocation(scan.nextLine());
//			
//			// Get Completed
//			System.out.print("Is this task completed? (y/n): ");
//			if(scan.nextLine().toLowerCase().equals("y")){
//				task.setCompleted(true);
//			} else {
//				task.setCompleted(false);
//			}
//			
//			// Add tasks to list
//			tasks.addTask(task);
//			
//			// Continue entering tasks?
//			System.out.print("Continue? (y/n): ");
//			if(!scan.nextLine().toLowerCase().equals("y")){
//				quit = true;
//			}
//		} while(!quit);
//		
//		System.out.println();
//		tasks.print();
//		
//		try {
//			tasks.writeFile(filename);	
//		} catch(FileNotFoundException e) {
//			System.out.println("File \"" + filename + "\" not found!");
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		
//		tasks = new TaskList();
//		
//		System.out.println("Before read...");
//		tasks.print();
//		
//		try {
//			tasks.readFile(filename);
//		} catch(FileNotFoundException e) {	
//		}
//		
//		tasks.print();
		
		System.exit(0);
	}
	
	/**
	 * Gets confirmation for an action from the user
	 * @param s Scanner to read input with
	 * @return true/false depending on user input
	 */
	public static boolean confirmed(Scanner scan) {
		System.out.print("Enter y to confirm: ");
		return scan.nextLine().toLowerCase().equals("y");
	}

}
