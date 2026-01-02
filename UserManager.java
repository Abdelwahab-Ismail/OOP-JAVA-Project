import java.util.ArrayList;

public class UserManager {

    ArrayList<User> users = new ArrayList<>();
    int nextId = 1;

    public void registerUser(String username, String password) {
        users.add(new User(nextId, username, password));
        nextId++;
        System.out.println("User registered");
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.username.equals(username) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }
}
