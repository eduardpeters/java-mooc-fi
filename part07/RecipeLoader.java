
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeLoader {

    public static RecipeBook load(String filename) {
        RecipeBook recipes = new RecipeBook();

        try ( Scanner fileScanner = new Scanner(Paths.get(filename))) {
            while (fileScanner.hasNextLine()) {
                recipes.add(loadSingleRecipe(fileScanner));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return recipes;
    }

    public static Recipe loadSingleRecipe(Scanner fileScanner) {
        String lineWithName = fileScanner.nextLine();
        int lineWithCookingTime = Integer.valueOf(fileScanner.nextLine());
        ArrayList<String> ingredients = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String lineWithIngredient = fileScanner.nextLine();
            if (lineWithIngredient.isEmpty()) {
                break;
            }
            ingredients.add(lineWithIngredient);
        }

        return new Recipe(lineWithName, lineWithCookingTime, ingredients);

    }
}
