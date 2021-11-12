package book.testrest.Service;


import book.testrest.Entity.Ingridient;
import book.testrest.Entity.Product;
import book.testrest.dao.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRep productRep;

    @Override
    public List<Product> getAllProducts() {
        return productRep.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRep.save(product);
    }

    @Override
    public Product getProduct(int id) throws Exception {
        Optional<Product> optional = productRep.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new Exception();
        }

        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productRep.deleteById(id);
    }


}
