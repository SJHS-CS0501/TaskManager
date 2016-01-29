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
		
		final String DEFAULT_FILENAME = "default.savefile";
		final String FILENAME_HISTORY = "last.savefile";
		
		String openFile = null;
		String mostRecentFile;
		
		TaskList tasks = null;
		String[] command;
		
		// Scanner for keyboard input
		Scanner scan = new Scanner(System.in);
		
		// get the name of the last opened file
		try {
			BufferedReader reader = new BufferedReader(new FileReader("last.savefile"));
			try {
				mostRecentFile = reader.readLine();
				reader.close();
			} catch(IOException e){
				System.out.println("Cannot read file: " + e.getMessage());
				System.out.printf("Setting most recent file to \"%s\"\n", DEFAULT_FILENAME);
				mostRecentFile = DEFAULT_FILENAME;
			}
		} catch (FileNotFoundException e) {
			System.out.printf("\"%s\" is missing, the folder has been compromised\n", FILENAME_HISTORY);
			System.out.printf("Setting most recent file to \"%s\"\n", DEFAULT_FILENAME);
			mostRecentFile = DEFAULT_FILENAME;
		}
		
		System.out.print("Welcome to Task Manager\nEnter \"help\" for a list of commands\n");
		
		while(run) {
			System.out.print("> ");
			command = scan.nextLine().toLowerCase().split(" ");
			System.out.print('\n');
			
			if(command.length != 0)
			switch(command[0]) {
				case "exit": // exit the program
					run = false;
					break;
					
				case "help": // get command descriptions
					if(command.length == 1) {
						System.out.print(CommandHelp.getHelpText());
					} else {
						System.out.print(CommandHelp.getCommandText(command[1]));
					}
					break;
					
				case "open": // load a file
					// Check to see if there is a file open
					if(tasks == null) {
						// if a filename is given try to open that
						if(command.length > 1) {			
							try {
								tasks = new TaskList(command[1]);
								System.out.printf("File \"%s\" was successfully opened\n", command[1]);
								openFile = command[1];
							} catch(FileNotFoundException e) {
								System.out.printf("File \"%s\" could not be found\n", command[1]);
							}
						// if not, default to the previous
						} else {
							System.out.print("No file specified, opening previous file...\n");
							try {
								tasks = new TaskList(mostRecentFile);
								openFile = mostRecentFile;
								System.out.printf("File \"%s\" was successfully opened\n", openFile);
							} catch(FileNotFoundException e) {
								System.out.printf("File \"%s\" could not be found\n", mostRecentFile);
							}
						}
					} else {
						// if there is, ask the user it they are sure that they want to open a new one and erase any unsaved changes
						System.out.print("Opening a new file will erase any changes made since the last save\nAre you sure you want to open a new file?\n");
						if(confirmed(scan)){
							// if a filename is given try to open that
							if(command.length > 1) {			
								try {
									tasks = new TaskList(command[1]);
									System.out.printf("File \"%s\" was successfully opened\n", command[1]);
									openFile = command[1];
								} catch(FileNotFoundException e) {
									System.out.printf("File \"%s\" could not be found\n", command[1]);
								}
							// if not, default to the previous
							} else {
								System.out.print("No file specified, opening previous file...\n");
								try {
									tasks = new TaskList(mostRecentFile);
									String temp = openFile;
									openFile = mostRecentFile;
									mostRecentFile = temp;
									System.out.printf("File \"%s\" was successfully opened\n", openFile);
								} catch(FileNotFoundException e) {
									System.out.printf("File \"%s\" could not be found\n", mostRecentFile);
								}
							}
						}
					}
					break;
					
				case "save": // make sure the "most recent file" file cannot be overwritten
					// ensure there is a file open
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						// if user enters a filename, use that after checking to prevent illegal names and characters
						if(command.length > 1) {
							if(command[1].contains("/")) {
								System.out.print("Filename cannot contain \"/\"\n");
							} else if(command[1].contains("\\")) {
								System.out.print("Filename cannot contain \"\\\"\n");
							} else if(command[1].equals(FILENAME_HISTORY)) {
								System.out.printf("\"%s\" cannot be written to\n", FILENAME_HISTORY);
							} else {
								File file = new File(command[1]);
								// check if a file exists
								if(file.exists()) {
									// confirm that the user wants to overwrite it
									System.out.printf("File \"%s\" already exists\nDo you want to overwrite it?\n", command[1]);
									if(confirmed(scan)) {
										try {
											tasks.writeFile(command[1]);
											System.out.printf("\"%s\" has been saved\n", command[1]);
											System.out.printf("Enter \"open %s\" to open the file\n", command[1]);
										} catch(FileNotFoundException e) {
											System.out.printf("File \"%s\" could not be found\n", command[1]);
										}
									}
								} else {
									// if file does not exist, make it
									System.out.printf("File \"%s\" does not exist\nDo you want to create it?\n", command[1]);
									if(confirmed(scan)) {
										try {
											tasks.writeFile(command[1]);
											System.out.printf("\"%s\" has been created and saved\n", command[1]);
											System.out.printf("Enter \"open %s\" to open the new file\n", command[1]);
										} catch(FileNotFoundException e) {
											System.out.printf("File \"%s\" could not be found\n", command[1]);
										}
									}
								}
							}
						// if not use the name of the open file
						} else {
							try {
								tasks.writeFile(openFile);
								System.out.printf("\"%s\" has been saved\n", openFile);
							} catch(FileNotFoundException e) {
								System.out.printf("File \"%s\" could not be found\n", openFile);
							}
						}
					}
					break;
					
				case "add": // add a new task to the list
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						tasks.addTask(makeTask(scan));
					}
					break;
					
				case "print": // display tasks to screen
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						tasks.printTasks(true);
					}
					break;
					
				case "search": // searches for and prints out specific tasks
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						if(command.length > 1) {
							switch(command[1]) {
								case "priority": // search by priority
									if (command.length > 2) {
										switch(command[2]) {
											case "1":
											case "high":
												tasks.searchByPriority(Task.PRIO_HIGH).printTasks(false);
												break;
											case "2":
											case "medium":
												tasks.searchByPriority(Task.PRIO_MED).printTasks(false);
												break;
											case "3":
											case "low":
												tasks.searchByPriority(Task.PRIO_LOW).printTasks(false);
												break;
											default:
												System.out.printf("Value \"%s\" undefined for priority\n", command[2]);
												break;
										}
									} else {
										System.out.print("No priority value was specified\nEnter \"help search\" to view a list of options\n");
									}
									break;
									
								case "date": // search by date
									int y;
									int m;
									int d;
									
									// Get Date
									System.out.println("Date");
									
									// Get year
									do {
									System.out.print("Year: ");
									while(!scan.hasNextInt()) {
										scan.next();
										System.out.print("Year must be a whole number: ");
									}
									y = scan.nextInt();
									} while(y < 0);
									
									// Get Month
									do {
										System.out.print("Month: ");
										while(!scan.hasNextInt()) {
											scan.next();
											System.out.print("Month must be a whole number: ");
										}
										m = scan.nextInt();
										} while(m < 1 || m > 12);
									
									// Get date
									do {
										System.out.print("Date: ");
										while(!scan.hasNextInt()) {
											scan.next();
											System.out.print("Date must be a whole number: ");
										}
										d = scan.nextInt();
									} while(d < 1);
									
									// Eat newline
									scan.nextLine();
									
									tasks.searchByDueDate(new Date(y - 1900, m - 1, d)).printTasks(false);
									break;
									
								case "category": // search by category
									if (command.length > 2) {
										switch(command[2]) {
											case "1":
											case "other":
												tasks.searchByCategory(Task.CAT_OTHER).printTasks(false);
												break;
											case "2":
											case "school":
												tasks.searchByCategory(Task.CAT_SCHOOL).printTasks(false);
												break;
											case "3":
											case "personal":
												tasks.searchByCategory(Task.CAT_PERSONAL).printTasks(false);
												break;
											case "4":
											case "chore":
												tasks.searchByCategory(Task.CAT_CHORE).printTasks(false);
												break;
											case "5":
											case "work":
												tasks.searchByCategory(Task.CAT_WORK).printTasks(false);
												break;
											default:
												System.out.printf("Value \"%s\" undefined for category\n", command[2]);
												break;
										}
									} else {
										System.out.print("No category value was specified\nEnter \"help search\" to view a list of options\n");
									}
									break;
									
								case "complete": // search for completed tasks
									tasks.searchByCompleted(true).printTasks(false);
									break;
									
								case "incomplete": // search for incomplete tasks
									tasks.searchByCompleted(false).printTasks(false);
									break;
									
								case "droids":
									System.out.print("These are not the droids you're looking for\n");
									break;
									
								default:
									System.out.printf("Searches cannot be made by the criteria \"%s\"\nEnter \"help search\" to view a list of options\n", command[1]);
									break;
							}
						} else {
							// search by task name
							System.out.print("Search by name: ");
							String name = scan.nextLine();
							Task task = tasks.searchByDescription(name);
							// if not found say so
							if(task == null) {
								System.out.printf("Task \"%s\" could not be found\n", name);
							} else {
								System.out.print('\n' + task.toString());
							}
						}
					}
					break;
					
				case "sort":
					// ensure there is a file open
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						tasks.sortByPriority();
						System.out.print("The tasks have been sorted from highest to lowest priority\n");
					}
					break;
					
				case "mark": // marks tasks as completed
					// ensure there is a file open
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						// if the user enters a number, mark the item with that number
						if(command.length > 1) {
							// ensure entered number is valid
							try {
								if(isNumberInRange(command[1], 1, tasks.size())) {
									tasks.getTask(Integer.parseInt(command[1]) - 1).setCompleted(true);
									System.out.printf("Task #%s has been marked as complete\n", Integer.parseInt(command[1]));
								}
							} catch(NumberFormatException e) {
								System.out.print("That number is much too large\n");
							}
						} else {
							// search by task name
							System.out.print("Search by name: ");
							String name = scan.nextLine();
							Task task = tasks.searchByDescription(name);
							// if not found say so
							if(task == null) {
								System.out.printf("Task \"%s\" could not be found\n", name);
							} else {
								task.setCompleted(true);
								System.out.printf("Task \"%s\" has been marked as complete\n", name);
							}
						}
					}
					break;
					
				case "unmark": // unmarks completed tasks
					// ensure there is a file open
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						// if the user enters a number, mark the item with that number
						if(command.length > 1) {
							// ensure entered number is valid
							try {
								if(isNumberInRange(command[1], 1, tasks.size())) {
									tasks.getTask(Integer.parseInt(command[1]) - 1).setCompleted(false);
									System.out.printf("Task #%s has been unmarked\n", Integer.parseInt(command[1]));
								}
							} catch(NumberFormatException e) {
								System.out.print("That number is much too large\n");
							}
						} else {
							// search by task name
							System.out.print("Search by name: ");
							String name = scan.nextLine();
							Task task = tasks.searchByDescription(name);
							// if not found say so
							if(task == null) {
								System.out.printf("Task \"%s\" could not be found\n", name);
							} else {
								task.setCompleted(false);
								System.out.printf("Task \"%s\" has been unmarked\n", name);
							}
						}
					}
					break;
					
				case "delete": // removes tasks from list
					// ensure there is a file open
					if(tasks == null) {
						System.out.print("There is no file open\n");
					} else {
						// if the user enters a number, mark the item with that number
						if(command.length > 1) {
							// ensure entered number is valid
							try {
								if(isNumberInRange(command[1], 1, tasks.size())) {
									System.out.printf("Are you sure you want to delete task #%s \"%s\"?\n", command[1], tasks.getTask(Integer.parseInt(command[1]) - 1).getDescription());
									if(confirmed(scan)) {
										tasks.removeTask(Integer.parseInt(command[1]) - 1);
										System.out.printf("The task has been deleted\n");
									}
								}
							} catch(NumberFormatException e) {
								System.out.print("That number is much too large\n");
							}
						} else {
							// search by task name
							System.out.print("Search by name: ");
							String name = scan.nextLine();
							Task task = tasks.searchByDescription(name);
							// if not found say so
							if(task == null) {
								System.out.printf("Task \"%s\" could not be found\n", name);
							} else {
								System.out.printf("Are you sure you want to delete \"%s\"?\n", name);
								if(confirmed(scan)) {
									tasks.removeTask(task);
									System.out.printf("The task has been deleted\n");
								}
							}
						}
					}
					break;
					
				case "create":
					if(tasks == null) {
						if(command.length > 1) {
							if(command[1].contains("/")) {
								System.out.print("Filename cannot contain \"/\"\n");
							} else if(command[1].contains("\\")) {
								System.out.print("Filename cannot contain \"\\\"\n");
							} else if(command[1].equals(FILENAME_HISTORY)) {
								System.out.printf("\"%s\" is illegal\n", FILENAME_HISTORY);
							} else {
								System.out.print("Creating a new file will erase any changes made since the last save\nAre you sure you want to create a new file?\n");
								if(confirmed(scan)) {
									File file = new File(command[1]);
									// check if a file exists
									if(file.exists()) {
										System.out.printf("File \"%s\" already exists\nDo you want to overwrite it?\n", command[1]);
										if(confirmed(scan)) {
											boolean addNewTask;
											do {
												
											} while(addNewTask);
										}	
									} else {
										
									}
								}
							}
						} else {
							System.out.print("A name must be specified to create a file\n");
						}
					} else {
						
					}
					break;
					
				default:
					System.out.printf("Operation \"%s\" not supported. Enter \"help\" for a list of commands\n", command[0]);
					break;
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
		
		// write name of opened file to most recently opened file space
		if(tasks != null) {
			try {
				PrintWriter writer = new PrintWriter(FILENAME_HISTORY);
				writer.println(openFile);
				writer.close();
			} catch(FileNotFoundException e) {
				System.out.print("Could not write to \"" + FILENAME_HISTORY + "\": " + e.getMessage());
			}
		}
		
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
	
	public static boolean isNumberInRange(String s, long min, long max ) {
		if(s.matches("(?:[0-9]*)?[0-9]+")) {
			long n = Long.parseLong(s);
			if( n < min) {
				System.out.printf("The number %d is below range\nInput must be at least %d\n", n, min);
				return false;
			} else if( n > max) {
				System.out.printf("The number %d is above range\nInput must be at most %d\n", n, max);
				return false;
			} else {
				return true;
			}
		} else {
			System.out.print("Number must be a positive integer\n");
			return false;
		}
	}
	
	public static Task makeTask(Scanner scan) {
		int y = 0;
		int m = 0;
		int d = 0;
		String line;
		boolean invalid = false;
		
		// New Task
		Task task = new Task();
		System.out.println("Create a new task");
		
		// Get Description
		do {
			System.out.print("Description: ");
			line = scan.nextLine();
			
			if(!line.contains("\t")) {
				task.setDescription(line);
			} else {
				System.out.print("Description cannot contain tabs\n");
			}
			
		} while(line.contains("\t"));
		
		// Get Priority
		do{
			System.out.print("Priority (1-3) or\none of high/medium/low: ");
			switch(scan.nextLine()) {
				case "1":
				case "high":
					task.setPriority(Task.PRIO_HIGH);
					invalid = false;
					break;
				case "2":
				case "medium":
					task.setPriority(Task.PRIO_MED);
					invalid = false;
					break;
				case "3":
				case "low":
					task.setPriority(Task.PRIO_LOW);
					invalid = false;
					break;
				default:
					System.out.print("Value undefined for priority\n");
					invalid = true;
					break;
			}
		}while(invalid);
		
		// Get Date
		System.out.println("Due Date");
		
		// Get year
		do {
		System.out.print("Year: ");
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.print("Year must be a whole number: ");
		}
		y = scan.nextInt();
		} while(y < 0);
		
		// Get Month
		do {
			System.out.print("Month: ");
			while(!scan.hasNextInt()) {
				scan.next();
				System.out.print("Month must be a whole number: ");
			}
			m = scan.nextInt();
			} while(m < 1 || m > 12);
		
		// Get date
		do {
			System.out.print("Date: ");
			while(!scan.hasNextInt()) {
				scan.next();
				System.out.print("Date must be a whole number: ");
			}
			d = scan.nextInt();
		} while(d < 1);
		
		// Eat newline
		scan.nextLine();
		
		task.setDueDate(new Date(y - 1900, m - 1, d));
		
		// Get Category
		do{
			System.out.print("Priority (1-5) or\none of other/school/personal/chore/work: ");
			switch(scan.nextLine()) {
				case "1":
				case "other":
					task.setCategory(Task.CAT_OTHER);
					invalid = false;
					break;
				case "2":
				case "school":
					task.setCategory(Task.CAT_SCHOOL);
					invalid = false;
					break;
				case "3":
				case "personal":
					task.setCategory(Task.CAT_PERSONAL);
					invalid = false;
					break;
				case "4":
				case "chore":
					task.setCategory(Task.CAT_CHORE);
					invalid = false;
					break;
				case "5":
				case "work":
					task.setCategory(Task.CAT_WORK);
					invalid = false;
					break;
				default:
					System.out.print("Value undefined for category\n");
					invalid = true;
					break;
			}
		}while(invalid);
		
		
		// Get Location	
		do {
			System.out.print("Location: ");
			line = scan.nextLine();
			
			if(!line.contains("\t")) {
				task.setLocation(line);
			} else {
				System.out.print("Location cannot contain tabs\n");
			}
		} while(line.contains("\t"));
		
		// Get Completed
		System.out.print("Is this task completed?\n");
		if(confirmed(scan)){
			task.setCompleted(true);
		} else {
			task.setCompleted(false);
		}
		
		return task;
	}

}
