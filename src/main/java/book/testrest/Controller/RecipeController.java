package book.testrest.Controller;


import book.testrest.Entity.Ingridient;
import book.testrest.Entity.Product;
import book.testrest.Entity.Recipe;
import book.testrest.Service.ProductService;
import book.testrest.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<Recipe> showAllRecipe() {
        List<Recipe> recipes = recipeService.getAllRecipe();
        return recipes;
    }


    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable int id) throws Exception {
        Recipe recipe = recipeService.getRecipe(id);
        return recipe;
    }


    @PostMapping("/")
    public Recipe addNewRecipe(@RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);

        return recipe;
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return recipe;
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
    }

    @PostMapping("/{id}/{prodid}/{weight}")
    public void addIngridient(@PathVariable int id, @PathVariable int prodid, @PathVariable int weight) throws Exception {
        Product product = productService.getProduct(prodid);
        Ingridient ingridient = new Ingridient(weight);
        ingridient.setProduct(product);
        productService.saveProduct(product);
        Recipe recipe = recipeService.getRecipe(id);
        recipe.addIngridients(ingridient);
        recipeService.saveRecipe(recipe);
    }

    @GetMapping("/{id}/showIngridients")
    public List<Ingridient> showIngridient(@PathVariable int id) throws Exception {
        Recipe recipe = recipeService.getRecipe(id);
        return recipe.getIngridientList();

    }


}
