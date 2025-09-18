import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TaskManager {
    private final Map<Integer, Integer> taskToPriority;
    private final Map<Integer, Integer> taskToUser;
    private final PriorityQueue<Task> tasksQueue;

    public TaskManager(List<List<Integer>> tasks) {
        taskToPriority = new HashMap<>();
        taskToUser = new HashMap<>();
        tasksQueue = new PriorityQueue<>();

        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskToPriority.put(taskId, priority);
        taskToUser.put(taskId, userId);
        tasksQueue.add(new Task(taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        taskToPriority.put(taskId, newPriority);
        tasksQueue.add(new Task(taskId, newPriority));
    }

    public void rmv(int taskId) {
        taskToPriority.remove(taskId);
        taskToUser.remove(taskId);
    }

    public int execTop() {
        while (!tasksQueue.isEmpty()) {
            Task highest = tasksQueue.poll();
            if (taskToPriority.containsKey(highest.taskId()) &&
                    highest.priority() == taskToPriority.get(highest.taskId())) {
                int userId = taskToUser.get(highest.taskId());
                rmv(highest.taskId());
                return userId;
            }
        }
        return -1;
    }
}

record Task(int taskId, int priority) implements Comparable<Task> {

    @Override
    public int compareTo(Task other) {
        if (this.priority == other.priority) {
            return -1 * Integer.compare(this.taskId, other.taskId);
        }
        return -1 * Integer.compare(this.priority, other.priority);
    }
}