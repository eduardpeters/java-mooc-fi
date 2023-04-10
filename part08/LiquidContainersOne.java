
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int containerOne = 0;
        int containerTwo = 0;
        int MAXCAPACITY = 100;

        while (true) {
            System.out.println("First: " + containerOne + "/100");
            System.out.println("Second: " + containerTwo + "/100");
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
                if (containerOne + amount > MAXCAPACITY) {
                    containerOne = MAXCAPACITY;
                } else {
                    containerOne += amount;
                }
            } else if (command.equals("move")) {
                if (amount > containerOne) {
                    amount = containerOne;
                }
                if (containerTwo + amount > MAXCAPACITY) {
                    containerTwo = MAXCAPACITY;
                } else {
                    containerOne -= amount;
                    containerTwo += amount;
                }
            } else if (command.equals("remove")) {
                if (amount > containerTwo) {
                    amount = containerTwo;
                }

                containerTwo -= amount;
            }
        }
    }

}
