/**
 * A convenient place to store help data that's not in a pesky text file
 * @author Ryan Luchs
 */

/**
 * A container for the help text for Task Manager
 * @author Ryan Luchs
 *
 */
public final class CommandHelp {
	
	public static final short CMD_EXIT = 0;
	public static final short CMD_HELP = 1;
	public static final short CMD_OPEN = 2;
	public static final short CMD_SAVE = 3;
	public static final short CMD_ADD = 4;
	public static final short CMD_PRINT = 5;
	
	public static final String[] commands = {
			"exit: closes the program\n",
			"help: provides information on how to operate Task Manager\nEnter \"help [command name]\" for information on specific commands\n",
			"open: loads a file\nEnter \"open [file name]\" to open a specific file\nEnter \"open\" to open the most recent file viewed\n",
			"save: \n",
			"add: \n",
			"print: displays list of tasks in open file\n",
	};
	
	/**
	 * Returns the help String matching the command name entered
	 * @param s Command name
	 * @return The help string matching the entered command name, or a statement stating there no match if none is found
	 */
	public static String getCommandText(String s) {
		switch(s) {
			case "exit":
				return commands[CMD_EXIT];
			case "help":
				return commands[CMD_HELP];
			case "open":
				return commands[CMD_OPEN];
			case "print":
				return commands[CMD_PRINT];
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
		for(int i = 0; i < commands.length; i++) {
			s.append(commands[i]);
			s.append('\n');
		}
		return s.toString();
	}
	
	

}
