import java.util.ArrayList;

public class Project {
    int id;
    String name;
    ArrayList<Task> tasks = new ArrayList<Task>();

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addTask(Task t) {
        tasks.add(t);
        t.project = this;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
