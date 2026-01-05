import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        UserManager um = new UserManager();
        TaskManager tm = new TaskManager();
        User user = null;

        while (user == null) {
            System.out.println("1- Register\n2- Login");
            int c = Input.readInt("Choose: ");
            if (c == 1) {
                um.register(
                    Input.readNonEmptyString("Username: "),
                    Input.readNonEmptyString("Password: ")
                );
            } else if (c == 2) {
                user = um.login(
                    Input.readNonEmptyString("Username: "),
                    Input.readNonEmptyString("Password: ")
                );
                if (user == null)
                    System.out.println("Wrong login");
            }
        }

        while (true) {
            System.out.println("""
1- Create Task
2- View All Tasks
3- View Upcoming Tasks
4- Complete Task
5- Delete Task
0- Exit
""");
            int c = Input.readInt("Choose: ");

            if (c == 0) break;

            if (c == 1) {
                tm.addTask(
                    user.getId(),
                    Input.readNonEmptyString("Title: "),
                    Input.readDateOrNull("Deadline yyyy-MM-dd (Enter skip): "),
                    Input.readPriorityOrNull("Priority LOW/MEDIUM/HIGH (Enter skip): "),
                    Input.readNonEmptyString("Note: ")
                );
            }
            if (c == 2) tm.showAll(user.getId());
            if (c == 3) tm.showUpcoming(user.getId());
            if (c == 4) tm.completeTask(
                Input.readInt("Task ID: "), user.getId());
            if (c == 5) tm.deleteTask(
                Input.readInt("Task ID: "), user.getId());
        }
    }
}
