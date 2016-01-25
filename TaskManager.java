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
		Scanner scan = new Scanner(System.in);
		TaskList tasks = new TaskList();
		
		int y = 0;
		int m = 0;
		int d = 0;
		boolean quit = false;
		String filename = "tasklist.txt";
		
		System.out.println("Welcome to the Task Manager!");
		
//		System.out.print("Do you want to create a new file? (y/n):");
//		if(scan.nextLine().toLowerCase().equals("y")) {
//			
//		}
		
		do {
			// New Task
			Task task = new Task();
			System.out.println("Create a new task:");
			
			// Get Description
			System.out.print("Description: ");
			task.setDescription(scan.nextLine());
			
			// Get Priority
			System.out.print("Priority (1-3): ");
			task.setPriority(scan.nextShort());
			
			// Get Date
			System.out.println("Due Date:");
			System.out.print("Year: ");
			y = scan.nextInt();
			System.out.print("Month: ");
			m = scan.nextInt();
			System.out.print("Date: ");
			d = scan.nextInt();
			
			task.setDueDate(new Date(y - 1900, m - 1, d));
			
			// Get Category
			System.out.print("Category (1-5): ");
			task.setCategory(scan.nextShort());
			scan.nextLine();
			
			// Get Location	
			System.out.print("Location: ");
			task.setLocation(scan.nextLine());
			
			// Get Completed
			System.out.print("Is this task completed? (y/n): ");
			if(scan.nextLine().toLowerCase().equals("y")){
				task.setCompleted(true);
			} else {
				task.setCompleted(false);
			}
			
			// Add tasks to list
			tasks.addTask(task);
			
			// Continue entering tasks?
			System.out.print("Continue? (y/n): ");
			if(!scan.nextLine().toLowerCase().equals("y")){
				quit = true;
			}
		} while(!quit);
		
		System.out.println();
		tasks.print();
		
		try {
			tasks.writeFile(filename);	
		} catch(FileNotFoundException e) {
			System.out.println("File \"" + filename + "\" not found!");
			e.printStackTrace();
			System.exit(-1);
		}
		
		tasks = new TaskList();
		
		System.out.println("Before read...");
		tasks.print();
		
		try {
			tasks.readFile(filename);
		} catch(FileNotFoundException e) {	
		}
		
		tasks.print();
		
		System.exit(0);
	}

}
