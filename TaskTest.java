import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testMarkCompleted() {

        Task t = new TimedTask(
            1,
            1,
            "Study",
            null,              // Deadline اختياري
            Priority.HIGH,
            "Final exam"
        );

        t.markCompleted();

        assertTrue(t.isCompleted());
    }
}
