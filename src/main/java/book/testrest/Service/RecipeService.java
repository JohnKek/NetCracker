package book.testrest.Service;

import book.testrest.Entity.Product;
import book.testrest.Entity.Recipe;

import java.util.List;

public interface RecipeService {

    public List<Recipe> getAllRecipe();

    public void saveRecipe(Recipe recipe);

    public Recipe getRecipe(int id) throws Exception;

    public void deleteRecipe(int id);

}
