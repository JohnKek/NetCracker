package book.testrest.Service;

import book.testrest.Entity.Ingridient;
import book.testrest.Entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public void saveProduct(Product product);

    public Product getProduct(int id) throws Exception;

    public void deleteProduct(int id);


}
