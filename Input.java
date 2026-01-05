import java.time.LocalDate;
import java.util.Scanner;

public class Input {

    private static Scanner sc = new Scanner(System.in);

    public static String readNonEmptyString(String msg) {
        String s;
        do {
            System.out.print(msg);
            s = sc.nextLine().trim();
        } while (s.isEmpty());
        return s;
    }

    public static LocalDate readDateOrNull(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return null;
            try {
                return LocalDate.parse(s); // yyyy-MM-dd
            } catch (Exception e) {
                System.out.println("Invalid date format. Use yyyy-MM-dd or press Enter.");
            }
        }
    }

    public static Priority readPriorityOrNull(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return null;
            if (s.equalsIgnoreCase("LOW") ||
                s.equalsIgnoreCase("MEDIUM") ||
                s.equalsIgnoreCase("HIGH")) {
                return Priority.valueOf(s.toUpperCase());
            }
            System.out.println("Priority must be LOW, MEDIUM, or HIGH.");
        }
    }

    public static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number.");
            }
        }
    }
}
