package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("all")
    @ResponseBody
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/find/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable("name") String name){
        Product product = productService.findProductByName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addSpecProduct(@RequestBody Product product){
        Product product1 = productService.addSpecProd(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @PostMapping("/addProduct/{name}/{description}/{price}")
    void addProduct(@PathVariable String name, @PathVariable String description, @PathVariable Double price){
        productService.addProduct(new Product(name, description, price));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String name){
        productService.deleteProductByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
