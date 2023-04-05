
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Grades grades;

    public UserInterface(Scanner scanner, Grades grades) {
        this.scanner = scanner;
        this.grades = grades;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());

            if (input == -1) {
                break;
            }

            if (input < -1 || input > 100) {
                continue;
            }

            grades.add(input);
        }
    }
}
