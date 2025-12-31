import java.time.LocalDate;

public class Deadline {

    LocalDate date;

    public Deadline(String dateStr) {
        this.date = LocalDate.parse(dateStr); // yyyy-MM-dd
    }

    public boolean isUpcoming() {
        return date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now());
    }

    public LocalDate getDate() {
        return date;
    }
}
