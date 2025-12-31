public class Task implements Completable {

    int id;
    int userId;
    String title;
    Deadline deadline;
    boolean completed;

    Priority priority;
    String note;

    public Task(int id, int userId, String title, Deadline deadline,
                Priority priority, String note) {

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.deadline = deadline;
        this.completed = false;

        // Optional values
        if (priority == null) {
            this.priority = Priority.LOW;
        } else {
            this.priority = priority;
        }

        if (note == null || note.isEmpty()) {
            this.note = "No notes";
        } else {
            this.note = note;
        }
    }

    public int getUserId() {
        return userId;
    }

    public boolean isUpcoming() {
        return deadline.isUpcoming() && !completed;
    }

    @Override
    public void markCompleted() {
        completed = true;
    }

    public void display() {
        System.out.println(
            "ID: " + id +
            " | Title: " + title +
            " | Deadline: " + deadline.getDate() +
            " | Priority: " + priority +
            " | Note: " + note +
            " | Completed: " + completed
        );
    }
}
