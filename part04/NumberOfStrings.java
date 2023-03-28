
import java.util.Scanner;

public class NumberOfStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stringCount = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            stringCount += 1;
        }

        System.out.println(stringCount);
    }
}
