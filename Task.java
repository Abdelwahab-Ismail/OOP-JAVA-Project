// 


public class Task implements Completable {
    int id;
    String title;
    String description;
    boolean completed;
    int priority = 0;                                               // ----------------
    Project project;                                               // min fututre will be add

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public void complete() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    public String toString() {
        return "Task[" + id + "] " + title + " (completed=" + completed + ", priority=" + priority + ")";
    }
}
