
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oldestAge = -1;

        while (true) {
            String row = scanner.nextLine();

            if (row.equals("")) {
                break;
            }

            String[] split = row.split(",");
            int currentAge = Integer.valueOf(split[1]);
            if (currentAge > oldestAge) {
                oldestAge = currentAge;
            }
        }
        
        System.out.println("Age of the oldest: " + oldestAge);
    }
}
