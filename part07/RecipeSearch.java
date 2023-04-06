
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File to read: ");
        String file = scanner.nextLine();
        System.out.println("");

        RecipeBook recipes = RecipeLoader.load(file);

        System.out.println("Commands:\n"
                + "list - lists the recipes\n"
                + "stop - stops the program\n"
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient\n");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            System.out.println("");

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                printRecipes(recipes.getRecipes());
            } else if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String searchFor = scanner.nextLine();
                System.out.println("");

                printRecipes(recipes.findByName(searchFor));
            } else if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxCookingTime = Integer.valueOf(scanner.nextLine());
                System.out.println("");

                printRecipes(recipes.findByMaxTime(maxCookingTime));
            } else if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String searchFor = scanner.nextLine();
                System.out.println("");

                printRecipes(recipes.findByIngredient(searchFor));
            }
        }
    }

    public static void printRecipes(ArrayList<Recipe> recipes) {
        System.out.println("Recipes:");
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

}
