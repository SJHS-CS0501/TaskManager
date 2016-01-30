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
		boolean changes = false;
		
		final String DEFAULT_FILENAME = "tasklist.txt";
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
			} catch(IOException e) {
				System.out.println("Cannot read file: " + e.getMessage());
				System.out.printf("Setting most recent file to \"%s\"\n", DEFAULT_FILENAME);
				mostRecentFile = DEFAULT_FILENAME;
			}
		} catch (FileNotFoundException e) {
			System.out.printf("\"%s\" is missing\n", FILENAME_HISTORY);
			System.out.printf("Setting most recent file to \"%s\"\n", DEFAULT_FILENAME);
			mostRecentFile = DEFAULT_FILENAME;
		}
		
		System.out.print("Welcome to Task Manager\nEnter \"help\" for a list of commands\n");
		
		while(run) {
			System.out.print("> ");
			command = scan.nextLine().split(" ");
			System.out.print('\n');
			
			if(command.length != 0)
			switch(command[0]) {
				case "exit": // exit the program
					if(changes) {
						System.out.print("There are unsaved changes, are you sure you want to exit?\n");
						if(confirmed(scan)) {
							run = false;
						}
					} else {
						run = false;
					}
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
						if(command.length > 1 && !command[1].equals(FILENAME_HISTORY)) {			
							try {
								tasks = new TaskList(command[1]);
								System.out.printf("File \"%s\" was successfully opened\n", command[1]);
								openFile = command[1];
								changes = false;
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
								changes = false;
							} catch(FileNotFoundException e) {
								System.out.printf("File \"%s\" could not be found\n", mostRecentFile);
							}
						}
					} else {
						// if there is, ask the user it they are sure that they want to open a new one and erase any unsaved changes
						System.out.print("Opening a new file will erase any changes made since the last save\nAre you sure you want to open a new file?\n");
						if(confirmed(scan)){
							// if a filename is given try to open that
							if(command.length > 1 && !command[1].equals(FILENAME_HISTORY)) {			
								try {
									tasks = new TaskList(command[1]);
									System.out.printf("File \"%s\" was successfully opened\n", command[1]);
									openFile = command[1];
									changes = false;
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
									changes = false;
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
											changes = false;
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
											changes = false;
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
								changes = false;
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
						changes = true;
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
										System.out.print("No priority value was given\nEnter \"help search\" to view a list of options\n");
									}
									break;
									
								case "date": // search by date
									tasks.searchByDueDate(makeDate(scan)).printTasks(false);
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
										System.out.print("No category value was given\nEnter \"help search\" to view a list of options\n");
									}
									break;
									
								case "complete": // search for completed tasks
									tasks.searchByCompleted(true).printTasks(false);
									break;
									
								case "incomplete": // search for incomplete tasks
									tasks.searchByCompleted(false).printTasks(false);
									break;
									
								case "droids":
									System.out.print("These aren't the Droids you're looking for...\n");
									break;
									
								default:
									System.out.printf("Searches cannot be made by the field \"%s\"\nEnter \"help search\" to view a list of options\n", command[1]);
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
						changes = true;
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
									changes = true;
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
								changes = true;
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
									changes = true;
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
								changes = true;
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
										changes = true;
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
									changes = true;
								}
							}
						}
					}
					break;
					
				case "create":
					if(command.length > 1) {
						if(command[1].contains("/")) {
							System.out.print("Filename cannot contain \"/\"\n");
						} else if(command[1].contains("\\")) {
							System.out.print("Filename cannot contain \"\\\"\n");
						} else if(command[1].equals(FILENAME_HISTORY)) {
							System.out.printf("\"%s\" is illegal\n", FILENAME_HISTORY);
						} else {
							if(tasks == null) {
								File file = new File(command[1]);
								// check if a file exists
								if(file.exists()) {
									// if so, check to see if the user is okay with overwriting
									System.out.printf("File \"%s\" already exists\nAre you sure you want to use this file name?\n", command[1]);
									if(confirmed(scan)) {
										// make TaskList
										tasks = makeTaskList(scan);
										System.out.printf("File \"%s\" was created\n", command[1]);
										mostRecentFile = openFile;
										openFile = command[1];
										
										// ask the user if they want to save the new TaskList
										System.out.printf("Do you want to save \"%s\"?\n", command[1]);
										if(confirmed(scan)) {
											try {
												tasks.writeFile(command[1]);
												System.out.printf("\"%s\" has been saved\n", command[1]);
												changes = false;
											} catch(FileNotFoundException e) {
												System.out.printf("File \"%s\" could not be found\n", command[1]);
											}
										} else {
											changes = true;
										}
									}
								} else {
									// if file does not exist, make new TaskList
									tasks = makeTaskList(scan);
									System.out.printf("File \"%s\" was created\n", command[1]);
									mostRecentFile = openFile;
									openFile = command[1];
									
									// ask the user if they want to save the new TaskList
									System.out.printf("Do you want to save \"%s\"?\n", command[1]);
									if(confirmed(scan)) {
										try {
											tasks.writeFile(command[1]);
											System.out.printf("\"%s\" has been saved\n", command[1]);
											changes = false;
										} catch(FileNotFoundException e) {
											System.out.printf("File \"%s\" could not be found\n", command[1]);
										}
									} else {
										changes = true;
									}
								}
							} else {
								// check to see if user is okay with discarding changes
								System.out.print("Creating a new file will erase any changes made since the last save\nAre you sure you want to create a new file?\n");
								if(confirmed(scan)) {
									File file = new File(command[1]);
									// check if a file exists
									if(file.exists()) {
										// if so, check to see if the user is okay with overwriting
										System.out.printf("File \"%s\" already exists\nAre you sure you want to use this file name?\n", command[1]);
										if(confirmed(scan)) {
											// make TaskList
											tasks = makeTaskList(scan);
											System.out.printf("File \"%s\" was created\n", command[1]);
											mostRecentFile = openFile;
											openFile = command[1];
											
											// ask the user if they want to save the new TaskList
											System.out.printf("Do you want to save \"%s\"?\n", command[1]);
											if(confirmed(scan)) {
												try {
													tasks.writeFile(command[1]);
													System.out.printf("\"%s\" has been saved\n", command[1]);
													changes = false;
												} catch(FileNotFoundException e) {
													System.out.printf("File \"%s\" could not be found\n", command[1]);
												}
											} else {
												changes = true;
											}
										}	
									} else {
										// if file does not exist, make new TaskList
										tasks = makeTaskList(scan);
										System.out.printf("File \"%s\" was created\n", command[1]);
										mostRecentFile = openFile;
										openFile = command[1];
										
										// ask the user if they want to save the new TaskList
										System.out.printf("Do you want to save \"%s\"?\n", command[1]);
										if(confirmed(scan)) {
											try {
												tasks.writeFile(command[1]);
												System.out.printf("\"%s\" has been saved\n", command[1]);
												changes = false;
											} catch(FileNotFoundException e) {
												System.out.printf("File \"%s\" could not be found\n", command[1]);
											}
										} else {
											changes = true;
										}
									}
								}
							}
						}
					} else {
						System.out.print("A name must be specified to create a file\n");
					}
					break;
					
				case "edit":
					// check if file exists
					if(tasks ==  null) {
						System.out.print("There is no file open\n");
					} else {
						// if so, check to see if command is formated correctly
						if(command.length == 1) {
							System.out.print("Command format is invalid\nEnter \"help edit\" to view a list of options\n");
						} else {
							// if command[1] is a valid integer
							if(command[1].matches("(?:[0-9]*.)?[0-9]+")) {
								try {
									if(isNumberInRange(command[1], 1, tasks.size())) {
										String line;
										int n = Integer.parseInt(command[1]) - 1;
										
										// edit stuff
										if(command.length > 2) {
											switch(command[2]) {
												case "name": // edit name
												case "description":  // edit description
													System.out.print("Description: ");
													line = scan.nextLine();
													
													if(!line.contains("\t")) {
														tasks.getTask(n).setDescription(line);
														System.out.printf("Task #%d's description/name has been edit to \"%s\"\n", n + 1, line);
														changes = true;
													} else {
														System.out.print("Description cannot contain tabs\n");
													}
													break;
													
												case "priority": // edit priority
													if(command.length > 3) {
														switch(command[3]) {
															case "1":
															case "high":
																tasks.getTask(n).setPriority(Task.PRIO_HIGH);
																System.out.printf("Task #%d's priority has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															case "2":
															case "medium":
																tasks.getTask(n).setPriority(Task.PRIO_MED);
																System.out.printf("Task #%d's priority has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															case "3":
															case "low":
																tasks.getTask(n).setPriority(Task.PRIO_LOW);
																System.out.printf("Task #%d's priority has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															default:
																System.out.printf("Value \"%s\" undefined for priority\n", command[3]);
																break;
														}
													} else {
														System.out.print("No priority value was given\nEnter \"help edit\" to view a list of options\n");
													}
													break;
													
												case "date": // edit date
													tasks.getTask(n).setDueDate(makeDate(scan));
													System.out.printf("Task #%d's date has been reset\n", n + 1);
													changes = true;
													break;
													
												case "category": // edit category
													if (command.length > 3) {
														switch(command[3]) {
															case "1":
															case "other":
																tasks.getTask(n).setCategory(Task.CAT_OTHER);
																System.out.printf("Task #%d's category has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															case "2":
															case "school":
																tasks.getTask(n).setCategory(Task.CAT_SCHOOL);
																System.out.printf("Task #%d's category has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															case "3":
															case "personal":
																tasks.getTask(n).setCategory(Task.CAT_PERSONAL);
																System.out.printf("Task #%d's category has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															case "4":
															case "chore":
																tasks.getTask(n).setCategory(Task.CAT_CHORE);
																System.out.printf("Task #%d's category has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															case "5":
															case "work":
																tasks.getTask(n).setCategory(Task.CAT_WORK);
																System.out.printf("Task #%d's category has been set to \"%s\"\n", n + 1, command[3]);
																changes = true;
																break;
															default:
																System.out.printf("Value \"%s\" undefined for category\n", command[3]);
																break;
														}
													} else {
														System.out.print("No category value was given\nEnter \"help edit\" to view a list of options\n");
													}
													break;
													
												case "location":  // edit description
													System.out.print("Location: ");
													line = scan.nextLine();
													
													if(!line.contains("\t")) {
														tasks.getTask(n).setLocation(line);
														System.out.printf("Task #%d's location has been set to \"%s\"\n", n + 1, line);
														changes = true;
													} else {
														System.out.print("Location cannot contain tabs\n");
													}
													break;
												
												default:
													System.out.printf("Field \"%s\" is invalid\n", command[2]);
													break;
											}
										} else {
											System.out.print("No field was specified\nEnter \"help edit\" to view a list of options\n");
										}
									}
								} catch(NumberFormatException e) {
									System.out.print("That number is much too large\n");
								}
							} else {
								// if it is not, assume the user wants to search by name
								System.out.print("Search by name: ");
								String name = scan.nextLine();
								Task task = tasks.searchByDescription(name);
								// if not found say so
								if(task == null) {
									System.out.printf("Task \"%s\" could not be found\n", name);
								} else {
									String line;
									
									// edit stuff
									switch(command[1]) {
										case "name": // edit name
										case "description":  // edit description
											System.out.print("Description: ");
											line = scan.nextLine();
											
											if(!line.contains("\t")) {
												task.setDescription(line);
												System.out.printf("The description/name has been set to \"%s\"\n", line);
												changes = true;
											} else {
												System.out.print("Description cannot contain tabs\n");
											}
											break;
											
										case "priority": // edit priority
											if(command.length > 2) {
												switch(command[2]) {
													case "1":
													case "high":
														task.setPriority(Task.PRIO_HIGH);
														System.out.printf("The priority has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													case "2":
													case "medium":
														task.setPriority(Task.PRIO_MED);
														System.out.printf("The priority has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													case "3":
													case "low":
														task.setPriority(Task.PRIO_LOW);
														System.out.printf("The priority has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													default:
														System.out.printf("Value \"%s\" undefined for priority\n", command[2]);
														break;
												}
											} else {
												System.out.print("No priority value was given\nEnter \"help edit\" to view a list of options\n");
											}
											break;
											
										case "date": // edit date
											task.setDueDate(makeDate(scan));
											System.out.printf("The date has been reset\n");
											changes = true;
											break;
											
										case "category": // edit category
											if (command.length > 2) {
												switch(command[2]) {
													case "1":
													case "other":
														task.setCategory(Task.CAT_OTHER);
														System.out.printf("The category has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													case "2":
													case "school":
														task.setCategory(Task.CAT_SCHOOL);
														System.out.printf("The category has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													case "3":
													case "personal":
														task.setCategory(Task.CAT_PERSONAL);
														System.out.printf("The category has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													case "4":
													case "chore":
														task.setCategory(Task.CAT_CHORE);
														System.out.printf("The category has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													case "5":
													case "work":
														task.setCategory(Task.CAT_WORK);
														System.out.printf("The category has been set to \"%s\"\n", command[2]);
														changes = true;
														break;
													default:
														System.out.printf("Value \"%s\" undefined for category\n", command[2]);
														break;
												}
											} else {
												System.out.print("No category value was given\nEnter \"help edit\" to view a list of options\n");
											}
											break;
											
										case "location":  // edit description
											System.out.print("Location: ");
											line = scan.nextLine();
											
											if(!line.contains("\t")) {
												task.setLocation(line);
												System.out.printf("The location has been set to \"%s\"\n", line);
												changes = true;
											} else {
												System.out.print("Location cannot contain tabs\n");
											}
											break;
										
										default:
											System.out.printf("Field \"%s\" is invalid\n", command[1]);
											break;
									}
								}
							}
						}
					}
					break;
					
				default:
					System.out.printf("Operation \"%s\" not supported. Enter \"help\" for a list of commands\n", command[0]);
					break;
			}
		}
		
		// write name of opened file to most recently opened file space
		if(tasks != null && new File(openFile).exists()) {
			try {
				PrintWriter writer = new PrintWriter(FILENAME_HISTORY);
				writer.println(openFile);
				writer.close();
			} catch(FileNotFoundException e) {
				System.out.println("Could not write to \"" + FILENAME_HISTORY + "\": " + e.getMessage());
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
		boolean c = scan.nextLine().toLowerCase().equals("y");
		System.out.print('\n');
		return c;
	}
	
	/**
	 * Checks to see if the given string is a number between specified upper and lower bounds
	 * @param s The string to validate
	 * @param min The upper limit
	 * @param max The lower limit
	 * @return true/false whether the string is a number between min and max
	 */
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
	
	/**
	 * Creates a Date object from user input
	 * @param scan Scanner to get input
	 * @return Date object created
	 */
	public static Date makeDate(Scanner scan) {
		int y = 0;
		int m = 0;
		int d = 0;
		
		// Get year
		do {
		System.out.print("Year (yyyy): ");
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
			System.out.print("Day: ");
			while(!scan.hasNextInt()) {
				scan.next();
				System.out.print("Date must be a whole number: ");
			}
			d = scan.nextInt();
		} while(d < 1 || d > 31);
		
		// Eat newline
		scan.nextLine();
		
		return new Date(y - 1900, m - 1, d);
	}
	
	/**
	 * Creates a new Task from user input
	 * @param scan Scanner to read input
	 * @return The created Task
	 */
	public static Task makeTask(Scanner scan) {
		String line;
		boolean invalid = false;
		
		// New Task
		Task task = new Task();
		System.out.println("Create a new task");
		
		// Get Description
		do {
			System.out.print("Name or description: ");
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
		task.setDueDate(makeDate(scan));
		
		// Get Category
		do{
			System.out.print("Category (1-5) or\none of other/school/personal/chore/work: ");
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
		
//		// Get Completed
//		System.out.print("Is this task completed?\n");
//		if(confirmed(scan)){
//			task.setCompleted(true);
//		} else {
//			task.setCompleted(false);
//		}
		
		return task;
	}
	
	/**
	 * Creates a new TaskList from user input
	 * @param scan Scanner to read input
	 * @return The created TaskList
	 */
	public static TaskList makeTaskList(Scanner scan) {
		boolean addNewTask;
		TaskList tasklist = new TaskList();
		
		System.out.print("Create new file\n");
		do {
			tasklist.addTask(makeTask(scan));
			System.out.print("Add another?\n");
			addNewTask = confirmed(scan);
		} while(addNewTask);
		
		return tasklist;
	}

}
