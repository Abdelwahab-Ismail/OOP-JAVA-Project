import java.time.LocalDate;

public class TimedTask extends Task {

    private LocalDate deadline;
    private Priority priority;
    private String note;

    public TimedTask(int id, int userId, String title,
    LocalDate deadline, Priority priority, String note) {

        super(id, userId, title);
        this.deadline = deadline;
        this.priority = (priority == null) ? Priority.LOW : priority;
        this.note = (note == null || note.isEmpty()) ? "NONE" : note;
    }

    @Override
    public boolean isUpcoming() {
        return deadline != null &&
        deadline.isAfter(LocalDate.now()) &&
        !isCompleted();
    }

    @Override
    public String toCSV() {
        return getId() + "," +
        getUserId() + "," +
        getTitle() + "," +
        deadline + "," +
        priority + "," +
        note + "," +
            isCompleted();
    }

    @Override
    public void display() {
        System.out.println(
            "ID: " + getId() +
            " | Title: " + getTitle() +
            " | Deadline: " + deadline +
            " | Priority: " + priority +
            " | Note: " + note +
            " | Completed: " + isCompleted()
        );

        // Notification for upcoming tasks
        Notification.showReminder(deadline);
    }
}
