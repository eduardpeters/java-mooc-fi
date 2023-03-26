
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> years = new ArrayList<>();

        while (true) {
            String row = scanner.nextLine();

            if (row.equals("")) {
                break;
            }

            String[] split = row.split(",");
            names.add(split[0]);
            years.add(Integer.valueOf(split[1]));
        }
        
        System.out.println("Longest name: " + findLongestInList(names));
        System.out.println("Average of the birth years: " + averageOfList(years));
    }
    
    public static String findLongestInList(ArrayList<String> list) {
        String longest = "";
        
        for (String value : list) {
            if (value.length() > longest.length()) {
                longest = value;
            }
        }
        
        return longest;
    }
    
    public static double averageOfList(ArrayList<Integer> numbers) {
        double sum = 0;
        
        for (int number : numbers) {
            sum += number;
        }
        
        return sum / numbers.size();
    }
    
}
