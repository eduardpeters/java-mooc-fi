
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file:");
        String fileName = scanner.nextLine();

        try ( Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                printLine(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void printLine(String line) {
        String[] splitLine = line.split(",");
        String name = splitLine[0];
        int age = Integer.valueOf(splitLine[1]);

        if (age == 1) {
            System.out.println(name + ", age: " + age + " year");
        } else {
            System.out.println(name + ", age: " + age + " years");
        }
    }

}
