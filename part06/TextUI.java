
import java.util.Scanner;

public class TextUI {

    private Scanner scanner;
    private SimpleDictionary dictionary;

    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    public void start() {

        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            if (command.equals("end")) {
                System.out.println("Bye bye!");
                break;
            }

            if (command.equals("add")) {
                add();
            } else if (command.equals("search")) {
                search();
            } else {
                System.out.println("Unknown command");
            }

        }
    }

    private void add() {
        System.out.print("Word: ");
        String word = scanner.nextLine();
        System.out.print("Translation: ");
        String translation = scanner.nextLine();

        dictionary.add(word, translation);
    }

    private void search() {
        System.out.print("To be translated: ");
        String word = scanner.nextLine();
        String translation = this.dictionary.translate(word);

        if (translation == null) {
            System.out.println("Word " + word + " was not found");
        } else {
            System.out.print("Translation: " + translation);
        }

    }
}
