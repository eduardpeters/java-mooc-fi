
import java.util.Scanner;

public class FirstWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String phrase = scanner.nextLine();

            if (phrase.equals("")) {
                break;
            }

            String[] split = phrase.split(" ");

            System.out.println(split[0]);
        }
    }
}
