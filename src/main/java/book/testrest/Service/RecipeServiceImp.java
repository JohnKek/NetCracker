package book.testrest.Service;

import book.testrest.Entity.Product;
import book.testrest.Entity.Recipe;
import book.testrest.dao.ProductRep;
import book.testrest.dao.RecipeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RecipeServiceImp implements RecipeService {
    @Autowired
    private RecipeRep recipeRep;

    @Override
    public List<Recipe> getAllRecipe() {
        return recipeRep.findAll();
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        recipeRep.save(recipe);
    }

    @Override
    public Recipe getRecipe(int id) throws Exception {
        Optional<Recipe> optional = recipeRep.findById(id);
        Recipe recipe = null;
        if (optional.isPresent()) {
            recipe = optional.get();
        } else {
            throw new Exception();
        }

        return recipe;
    }

    @Override
    public void deleteRecipe(int id) {
        recipeRep.deleteById(id);
    }
}
