package duke.main;

import duke.error.NoSuchTaskError;
import duke.task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int getSize() {
        return tasks.size();
    }

    ArrayList<String> toUiStringList() {
        int i = 1;
        ArrayList<String> result = new ArrayList<>();
        for (Task t : tasks) {
            StringBuilder sb = new StringBuilder();
            sb.append(i++);
            sb.append(".");
            sb.append(t);
            result.add(sb.toString());
        }
        return result;
    }

    ArrayList<String> toSaveStringList() {
        ArrayList<String> strings = new ArrayList<>();
        for (Task t : tasks) {
            strings.add(t.toSave());
        }
        return strings;
    }

    public Task doTask(int taskNumber) throws NoSuchTaskError {
        if (taskNumber < 0 || taskNumber >= tasks.size()) {
            throw new NoSuchTaskError();
        }
        Task doneTask = tasks.get(taskNumber);
        doneTask.setDone();
        assert(doneTask.isDone());
        return doneTask;
    }

    public Task deleteTask(int taskNumber) throws NoSuchTaskError {
        if (taskNumber < 0 || taskNumber >= tasks.size()) {
            throw new NoSuchTaskError();
        }
        Task deleted = tasks.get(taskNumber);
        tasks.remove(taskNumber);
        return deleted;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        assert(tasks.size() > 0);
        return task;
    }

    public TaskList find(String searchTerm) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDescription().contains(searchTerm)) {
                foundTasks.add(t);
            }
        }
        return new TaskList(foundTasks);
    }
}
