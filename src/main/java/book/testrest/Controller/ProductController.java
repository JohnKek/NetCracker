package book.testrest.Controller;


import book.testrest.Entity.Ingridient;
import book.testrest.Entity.Product;
import book.testrest.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/getAll")
    public List<Product> showAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) throws Exception {
        Product product = productService.getProduct(id);
        return product;
    }

    @PostMapping("/")
    public Product addNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);

        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }


    @PostMapping("/{id}/{weight}")
    public Ingridient addIngridient(@PathVariable int id,@PathVariable int weight) throws Exception {
        Product product=productService.getProduct(id);
        Ingridient ingridient=new Ingridient(weight);
        product.addIngridient(ingridient);
        productService.saveProduct(product);
        return ingridient;
    }


}
