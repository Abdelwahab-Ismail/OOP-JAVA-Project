import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskManager {

    private final String FILE = "tasks.csv";
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public TaskManager() {
        load();
    }

    private void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                TimedTask t = new TimedTask(
                        Integer.parseInt(d[0]),
                        Integer.parseInt(d[1]),
                        d[2],
                        d[3].equals("null") ? null : LocalDate.parse(d[3]),
                        Priority.valueOf(d[4]),
                        d[5]
                );
                if (Boolean.parseBoolean(d[6])) t.markCompleted();
                tasks.add(t);
                nextId++;
            }
        } catch (Exception ignored) {}
    }

    private void save() {
        try (PrintWriter pw = new PrintWriter(FILE)) {
            pw.println("id,userId,title,deadline,priority,note,completed");
            for (Task t : tasks)
                pw.println(t.toCSV());
        } catch (Exception ignored) {}
    }

    public void addTask(int userId, String title, LocalDate d,
                        Priority p, String note) {
        tasks.add(new TimedTask(nextId++, userId, title, d, p, note));
        save();
    }

    public void showAll(int userId) {
        for (Task t : tasks)
            if (t.getUserId() == userId)
                t.display();
    }

    public void showUpcoming(int userId) {
        for (Task t : tasks)
            if (t.getUserId() == userId && t.isUpcoming())
                t.display();
    }

    public void completeTask(int id, int userId) {
        for (Task t : tasks)
            if (t.getId() == id && t.getUserId() == userId)
                t.markCompleted();
        save();
    }

    public void deleteTask(int id, int userId) {
        tasks.removeIf(t -> t.getId() == id && t.getUserId() == userId);
        save();
    }
}
