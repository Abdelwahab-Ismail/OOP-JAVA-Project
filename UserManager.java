import java.io.*;
import java.util.ArrayList;

public class UserManager {

    private final String FILE = "users.csv";
    private ArrayList<User> users = new ArrayList<>();
    private int nextId = 1;

    public UserManager() {
        load();
    }

    private void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            br.readLine();
            String l;
            while ((l = br.readLine()) != null) {
                String[] d = l.split(",");
                users.add(new User(Integer.parseInt(d[0]), d[1], d[2]));
                nextId++;
            }
        } catch (Exception ignored) {}
    }

    private void save() {
        try (PrintWriter pw = new PrintWriter(FILE)) {
            pw.println("id,username,password");
            for (User u : users)
                pw.println(u.getId() + "," + u.getUsername() + "," + u.getPassword());
        } catch (Exception ignored) {}
    }

    public void register(String u, String p) {
        users.add(new User(nextId++, u, p));
        save();
    }

    public User login(String u, String p) {
        for (User user : users)
            if (user.getUsername().equals(u) && user.getPassword().equals(p))
                return user;
        return null;
    }
}
