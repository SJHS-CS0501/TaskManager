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
	
	
	public static final String[] COMMANDS = {
			"exit: closes the program\n",
			"help: provides information on how to operate Task Manager\nEnter \"help [command name]\" for information on specific commands\n",
			"open: loads a file\nEnter \"open [file name]\" to open a specific file\nEnter \"open\" to open the last file viewed\n",
			"save: save a file\nEnter \"save [file name]\" to save to a specific file\nnew files are created automatically\nEnter \"save\" to save the open file\n",
			"add: creates a new task from user input and adds it to the open file\n",
			"print: displays list of tasks in open file\n",
			"search: \n",
			"sort: sorts list of tasks from highest to owest priority\n",
			"mark: marks a task as completed\nEnter \"mark [number]\" to mark the task with that number in the list\nEnter \"mark\" to find the task by name\n",
			"unmark: removes the \"complete\" mark from a task\nEnter \"unmark [number]\" to unmark the task with that number in the list\nEnter \"unmark\" to find the task by name\n",
			"delete: removes a task from the file\nEnter \"delete [number]\" to delete the task with that number in the list\nEnter \"delete\" to find the task by name\n",
			"create: creates a new file"
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
			case "me":
				return "I'm sorry... there's nothing I can do for you...\n";
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
