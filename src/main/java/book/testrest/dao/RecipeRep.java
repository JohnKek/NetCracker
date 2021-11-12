package book.testrest.dao;

import book.testrest.Entity.Product;
import book.testrest.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRep extends JpaRepository<Recipe,Integer> {
}
