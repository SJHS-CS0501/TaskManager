import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * 
 */

/**
 * @author Ryan Smith TaskList contains a list of tasks and operations for that
 *         list.
 */
public class TaskList {
	/*
	 * Data:
	 * 
	 * -list of tasks
	 */

	ArrayList<Task> taskList;

	/*
	 * Operations:
	 * 
	 * -add/remove tasks -get task by index -get task by some other value?
	 * -search task by name -search/sort by priority -search/sort by due date
	 * -search/sort by completion -search/sort by category -write list to disk
	 * -write list from disk
	 */

	/**
	 * Create a new TaskList from scratch
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
	public TaskList(String filename) throws FileNotFoundException {
		readFile(filename);
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
	 * @param i
	 * @return Task object at index, will return NULL if not found
	 */
	public Task getTask(int i) {
		return taskList.get(i);
	}

	/**
	 * Remove the specified task at index i. Throws an exception if index is
	 * illegal.
	 * 
	 * @param i
	 */
	public void removeTask(int i) {
		taskList.remove(i);
	}

	public Task searchByDescription(String d) {
		Task t = null;

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(d)) {
				t = taskList.get(i);
			}
			break;
		}
		return t;
	}
	/**
	 * searches tasks by priority
	 * @param p
	 * @return foo
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
	 * Sorts tasks by priority
	 * @param t
	 */
	public void sortByPriority(Task t) {
		int ctr = 0;
		taskList.sort(Task::compareTo);
		taskList.forEach(System.out::println);
	}
	

	/**
	 * Read list of tasks from filename provided.
	 * 
	 * @param filename
	 *            filename to read
	 */
	public void readFile(String filename) throws FileNotFoundException {
		Task t;
		// assume that taskList is initialized
		taskList.clear(); // remove all old tasks

		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try {
			while(reader.ready()) {
				t = new Task();
				t.read(reader);
				if(t != null) {
					taskList.add(t);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("IO Exception encountered: " + e.getMessage());
		}
	}
	/**
	 * 
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

}
