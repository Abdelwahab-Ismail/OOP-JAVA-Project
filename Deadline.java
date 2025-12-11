import java.time.LocalDateTime;
import java.time.Duration;

public class Deadline {
    LocalDateTime dateTime;

    public Deadline(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dateTime);
    }

    public Duration timeLeft() {
        return Duration.between(LocalDateTime.now(), dateTime);
    }
}
