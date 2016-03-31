/**
 * A convenient place to store help data that's not in a pesky text file
 * @author Ryan Luchs
 */

/**
 * A container for the help text for Task Manager
 * @author Ryan Luchs
 *
 */
public abstract class CommandHelp {
	
	public static final short CMD_EXIT = 0;
	public static final short CMD_HELP = 1;
	public static final short CMD_OPEN = 2;
	public static final short CMD_SAVE = 3;
	public static final short CMD_ADD = 4;
	public static final short CMD_PRINT = 5;
	public static final short CMD_SEARCH = 6;
	public static final short CMD_SORT = 7;
	public static final short CMD_MARK = 8;
	public static final short CMD_UNMARK = 9;
	public static final short CMD_DELETE = 10;
	public static final short CMD_CREATE = 11;
	public static final short CMD_EDIT = 12;
	
	
	public static final String[] COMMANDS = {
			"exit: closes the program\n",
			"help: provides information on how to operate Task Manager\n-Enter \"help [command name]\" for information on specific commands\n",
			"open: loads a file\n-Enter \"open [file name]\" to open a specific file\n-Enter \"open\" to open the last file viewed\n",
			"save: save a file\n-Enter \"save [file name]\" to save to as specific filename\n new files are created automatically\n-Enter \"save\" to save the open file\n",
			"add: creates a new task from user input and adds it to the open file\n",
			"print: displays list of tasks in open file\n",
			"search: searches for specific task(s)\n-Enter \"search [field] [value]\" to search for tasks with a specific value in the specified field\n-Enter \"search\" to search for a task by name\n\nValid fields include:\n-priority: takes values, numbers (1-3) or high, medium, or low\n-date: takes no values, prompt user for input\n-category: takes values, numbers (1-5) or other, school, personal, chore, or work\n-complete: takes no values, searches for completed tasks\n-incomplete: takes no values, searches for incomplete tasks\n",
			"sort: sorts list of tasks from highest to lowest priority\n",
			"mark: marks a task as completed\n-Enter \"mark [number]\" to mark the task with that number in the list\n-Enter \"mark\" to find the task by name\n",
			"unmark: marks a task as incomplete\n-Enter \"unmark [number]\" to unmark the task with that number in the list\n-Enter \"unmark\" to find the task by name\n",
			"delete: removes a task from the file\n-Enter \"delete [number]\" to delete the task with that number in the list\n-Enter \"delete\" to find the task by name\n",
			"create: creates a new file\n-Enter \"create [file name]\" to create a new file with that name\n",
			"edit: edits the data in a task\n-Enter \"edit [number] [field] [value]\" to set specified data field in the task with that number to a specific value\n-Enter \"edit [field] [value]\" to search for a task by name and set the specified data field to the specified value\n\nValid fields include:\n-name or description: takes no values, prompts user for input\n-priority: takes values, numbers (1-3) or high, medium, or low\n-date: takes no values, prompt user for input\n-category: takes values, numbers (1-5) or other, school, personal, chore, or work\n-location: takes no values, prompts user for input\n"
	};
	
	/**
	 * Returns the help String matching the command name entered
	 * @param s Command name
	 * @return The help string matching the entered command name, or a statement stating there no match if none is found
	 */
	public static String getCommandText(String s) {
		switch(s) {
			case "exit":
				return COMMANDS[CMD_EXIT];
			case "help":
				return COMMANDS[CMD_HELP];
			case "open":
				return COMMANDS[CMD_OPEN];
			case "save":
				return COMMANDS[CMD_SAVE];
			case "print":
				return COMMANDS[CMD_PRINT];
			case "search":
				return COMMANDS[CMD_SEARCH];
			case "sort":
				return COMMANDS[CMD_SORT];
			case "mark":
				return COMMANDS[CMD_MARK];
			case "unmark":
				return COMMANDS[CMD_UNMARK];
			case "delete":
				return COMMANDS[CMD_DELETE];
			case "create":
				return COMMANDS[CMD_CREATE];
			case "edit":
				return COMMANDS[CMD_EDIT];
			case "me":
				return "I'm sorry, I wish I could help you... It's just, there's nothing I can do for you unless it involves managing tasks...\n";
			default:
				return "Command \"" + s + "\" does not exist\n";
		}
	}
	
	/**
	 * Returns the help text for all commands separated by return characters
	 * @return Help text for all commands
	 */
	public static String getHelpText() {
		StringBuilder s = new StringBuilder("\n--Commands--\n");
		for(int i = 0; i < COMMANDS.length; i++) {
			s.append(COMMANDS[i]);
			s.append('\n');
		}
		return s.toString();
	}
	
	

}
