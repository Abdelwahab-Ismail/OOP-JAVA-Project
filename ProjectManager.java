import java.io.*;

public class ProjectManager {

    String fileName = "projects.csv";

    public ProjectManager() {
        try {
            File f = new File(fileName);
            if (!f.exists()) {
                PrintWriter pw = new PrintWriter(f);
                pw.println("id,userId,name");
                pw.close();
            }
        } catch (Exception e) {
            System.out.println("Project file error");
        }
    }

    public void createProject(int userId, String name) {
        try {
            int id = getLastId() + 1;
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
            pw.println(id + "," + userId + "," + name);
            pw.close();
            System.out.println("Project created");
        } catch (Exception e) {
            System.out.println("Create project error");
        }
    }

    public void showProjects(int userId) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (Integer.parseInt(d[1]) == userId) {
                    System.out.println("ID: " + d[0] + " | Name: " + d[2]);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Read projects error");
        }
    }
    public void showAllTasksForUser(int userId) {
    try {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine(); // skip header
        String line;

        System.out.println("\n--- Your Tasks ---");

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");

            int uId = Integer.parseInt(d[1]);
            if (uId == userId) {
                System.out.println(
                        "ID: " + d[0] +
                        " | Title: " + d[2] +
                        " | Completed: " + d[3] +
                        " | Priority: " + d[4] +
                        " | Deadline: " + d[5] +
                        " | Project ID: " + d[6]
                );
            }
        }
        br.close();

    } catch (Exception e) {
        System.out.println("Error reading tasks");
    }
}


    private int getLastId() {
        int id = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                id = Integer.parseInt(line.split(",")[0]);
            }
            br.close();
        } catch (Exception e) {
            return 0;
        }
        return id;
    }
}
