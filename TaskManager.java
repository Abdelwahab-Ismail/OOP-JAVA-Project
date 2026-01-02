import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();
    int nextId = 1;

    public void createTask(int userId, String title, Deadline deadline,
        Priority priority, String note) {
        Task t = new TimedTask(nextId, userId, title, deadline, priority, note);
        tasks.add(t);
        nextId++;
        System.out.println("Task created");
    }

    public void markCompleted(int id) {
        for (Task t : tasks) {
            if (t.id == id) {
                t.markCompleted();
                System.out.println("Task completed");
                return;
            }
        }
        System.out.println("Task not found");
    }

    public void showUpcomingTasks(int userId) {
        boolean found = false;
        for (Task t : tasks) {
            if (t.getUserId() == userId && t.isUpcoming()) {
                t.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No upcoming tasks");
        }
    }

    public void showAllTasksForUser(int userId) {
        boolean found = false;
        for (Task t : tasks) {
            if (t.getUserId() == userId) {
                t.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found");
        }
    }
}
