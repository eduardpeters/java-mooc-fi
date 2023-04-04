
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int CAPACITY = 100;
        int containerOne = 0;
        int containerTwo = 0;

        while (true) {
            System.out.println("First: " + containerOne + "/" + CAPACITY);
            System.out.println("Second: " + containerTwo + "/" + CAPACITY);

            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                if (amount > 0) {
                    if (amount > CAPACITY - containerOne) {
                        amount = CAPACITY - containerOne;
                    }
                    containerOne += amount;
                }
            } else if (command.equals("move")) {
                if (amount > 0) {
                    if (amount > containerOne) {
                        amount = containerOne;
                    }
                    if (amount > CAPACITY - containerTwo) {
                        amount = CAPACITY - containerTwo;
                    }
                    containerOne -= amount;
                    containerTwo += amount;
                }
            } else if (command.equals("remove")) {
                if (amount > 0) {
                    if (amount > containerTwo) {
                        amount = containerTwo;
                    }
                    if (amount > CAPACITY - containerOne) {
                        amount = CAPACITY - containerOne;
                    }
                    containerTwo -= amount;
                    containerOne += amount;
                }
            }

        }
    }

}
