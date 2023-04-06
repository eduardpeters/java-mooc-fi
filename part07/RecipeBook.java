
import java.util.ArrayList;

public class RecipeBook {

    ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public ArrayList<Recipe> getRecipes() {
        return this.recipes;
    }

    public ArrayList<Recipe> findByName(String searchFor) {
        ArrayList<Recipe> matches = new ArrayList<>();

        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(searchFor)) {
                matches.add(recipe);
            }
        }

        return matches;
    }

    public ArrayList<Recipe> findByMaxTime(int timeLimit) {
        ArrayList<Recipe> matches = new ArrayList<>();

        for (Recipe recipe : this.recipes) {
            if (recipe.getCookingTime() <= timeLimit) {
                matches.add(recipe);
            }
        }

        return matches;
    }

    public ArrayList<Recipe> findByIngredient(String searchFor) {
        ArrayList<Recipe> matches = new ArrayList<>();

        for (Recipe recipe : this.recipes) {
            if (recipe.getIngredients().contains(searchFor)) {
                matches.add(recipe);
            }
        }

        return matches;
    }
}
