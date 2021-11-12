package book.testrest.dao;

import book.testrest.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product,Integer> {
}
