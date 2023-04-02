
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoList list;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("add")) {
                add();
            } else if (command.equals("list")) {
                list();
            } else if (command.equals("remove")) {
                remove();
            } else {
                System.out.println("Unknown command");
            }

        }
    }

    private void add() {
        System.out.print("To add: ");
        String task = scanner.nextLine();

        this.list.add(task);
    }

    private void list() {
        this.list.print();
    }

    private void remove() {
        System.out.print("Which one is removed? ");
        int taskNumber = Integer.valueOf(scanner.nextLine());

        this.list.remove(taskNumber);
    }

}
