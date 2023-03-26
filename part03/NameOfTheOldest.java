
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oldestAge = -1;
        String oldestName = "";

        while (true) {
            String row = scanner.nextLine();

            if (row.equals("")) {
                break;
            }

            String[] split = row.split(",");
            int currentAge = Integer.valueOf(split[1]);
            if (currentAge > oldestAge) {
                oldestAge = currentAge;
                oldestName = split[0];
            }
        }

        System.out.println("Name of the oldest: " + oldestName);
    }
}
