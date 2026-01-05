import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Notification {

    public static void showReminder(LocalDate deadline) {
        if (deadline == null) {
            return;
        }

        long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), deadline);

        if (daysLeft >= 0) {
            System.out.println(">> Reminder: " + daysLeft + " day(s) left for this task");
        }
    }
}
