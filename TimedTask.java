import java.time.LocalDateTime;

public class TimedTask extends Task {
    Deadline deadline;

    public TimedTask(int id, String title, String description, Deadline deadline) {
        super(id, title, description);
        this.deadline = deadline;
    }

    public String toString() {
        return super.toString() + " | deadline=" + deadline.dateTime;
    }
}
