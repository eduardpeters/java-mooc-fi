
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container containerOne = new Container();
        Container containerTwo = new Container();

        while (true) {
            System.out.println("First: " + containerOne);
            System.out.println("Second: " + containerTwo);
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            int amount = Integer.valueOf(inputParts[1]);

            if (amount <= 0) {
                continue;
            }

            if (command.equals("add")) {
                containerOne.add(amount);
            } else if (command.equals("move")) {
                if (amount > containerOne.contains()) {
                    amount = containerOne.contains();
                }
                containerOne.remove(amount);
                containerTwo.add(amount);

            } else if (command.equals("remove")) {
                containerTwo.remove(amount);
            }
        }
    }
}
