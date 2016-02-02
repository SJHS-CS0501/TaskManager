
/**
 * 
 */
import java.util.*;
import java.io.*;
import java.text.DateFormat;

/**
 * @author Jack Protivnak
 * TaskList contains a list of tasks and operations for
 * that list.
 */
public class TaskList {
	/*
	 * Data:
	 * 
	 * - List of tasks
	 */
	ArrayList<Task> taskList;

	/**
	 * Create a new TaskList from scratch.
	 */
	public TaskList() {
		taskList = new ArrayList<Task>();
	}

	/**
	 * Create a new TaskList from disk, reading from provided filename.
	 * 
	 * @param filename
	 *            String filename
	 */
	public TaskList(String filename, DateFormat format) throws FileNotFoundException {
		readFile(filename, format);
	}

	/**
	 * Print all tasks in the task list.
	 */
	public void printTasks() {
		System.out.println("Tasks: ");
		for (int i = 0; i < taskList.size(); i++) {
			System.out.print(taskList.get(i).toString());
			System.out.println("-----");
		}
		System.out.println("EOL");
	}

	/**
	 * Add the provided task.
	 * 
	 * @param t
	 * @return true if add succeeded
	 */
	public boolean addTask(Task t) {
		return taskList.add(t);

	}

	/**
	 * Return task at index i. Throws exception if index is illegal.
	 * 
	 * @param i index of task
	 * @return Task object at index.
	 */
	public Task getTask(int i) {
		return taskList.get(i);
	}

	/**
	 * Remove the specified task at index i. Throws an exception if index is
	 * illegal.
	 * 
	 * @param i
	 *            index of task to remove
	 */
	public void removeTask(int i) {
		taskList.remove(i);
	}

	/**
	 * Search tasks by priority.
	 * @param p
	 * @return matches
	 */
	public TaskList searchByPriority(short p) {
		TaskList foo = new TaskList();

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getPriority() == p) {
				foo.addTask(taskList.get(i));
			}
		}
		return foo;
	}

	/**
	 * Search tasks by Due Date.
	 * @param d
	 * @return matches
	 */
	public Task searchByDueDate(Date d) {
		Task foo = null;

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDueDate().equals(d)) {
				foo = taskList.get(i);
				break;
			}
		}

		return foo;
	}

	/**
	 * Search tasks by Category.
	 * @param c
	 * @return matches
	 */
	public TaskList searchByCategory(short c) {
		TaskList foo = new TaskList();

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getCategory() == c) {
				foo.addTask(taskList.get(i));
			}
		}
		return foo;
	}

	/**
	 * Search tasks by Description.
	 * @param d
	 * @return match
	 */
	public TaskList searchByDescription(String d) {
		TaskList foo = new TaskList();

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(d)) {
				foo.addTask(taskList.get(i));
				break;
			}
		}

		return foo;
	}

	/**
	 * Search tasks by Location.
	 * @param l
	 * @return match
	 */
	public TaskList searchByLocation(String l) {
		TaskList foo = new TaskList();

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getLocation().equals(l)) {
				foo.addTask(taskList.get(i));
				break;
			}
		}

		return foo;
	}

	/**
	 * Search tasks by if they were completed or not.
	 * @param c
	 * @return matches
	 */
	public TaskList searchByCompleted(boolean c) {
		TaskList foo = new TaskList();

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getCompleted() == c) {
				foo.addTask(taskList.get(i));
			}
		}
		return foo;
	}
	
	/**
	 * Sorting taskList by priority from Undefined/High/Medium/Low.
	 * @return taskList
	 */
	public TaskList sortByPriority() {
		int startScan, index, minIndex, minValue;
		for (startScan = 0; startScan < (taskList.size() - 1); startScan++) {
			minIndex = startScan;
			minValue = taskList.get(startScan).getPriority();
			for (index = startScan + 1; index < taskList.size(); index++) {
				if (taskList.get(index).getPriority() < minValue) {
					minValue = taskList.get(index).getPriority();
					minIndex = index;
				}
			}
			Collections.swap(taskList, minIndex, startScan);
		}
		return this;
	}

	/**
	 * Setting task as completed.
	 * @param c
	 */
	public void setAsCompleted(short c) {
		taskList.get(c).setCompleted(true);
	}

	/**
	 * Will return size of task list
	 * @return size of taskList
	 */
	public int getSize() {
		return taskList.size();
	}
	/**
	 * Read list of tasks from filename provided.
	 * 
	 * @param filename
	 *            Filename to read
	 */
	public void readFile(String filename, DateFormat format) throws FileNotFoundException {
		Task t;
		// asssume that taskList is initialized
		taskList.clear(); // remove all old tasks

		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try {
			while (reader.ready()) {
				t = new Task();
				t.read(reader);
				t.setDateFormat(format);
				if (t != null) {
					taskList.add(t);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("IO Exception encountered: " + e.getMessage());
		}
	}

	/**
	 * Writing taskList to file.
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void writeFile(String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filename);
		for (int i = 0; i < taskList.size(); i++) {
			taskList.get(i).write(writer);
			/*
			 * EQUIVALENT: Task foo = taskList.get(i); foo.write(writer);
			 */
		}
		writer.close();
	}

}
