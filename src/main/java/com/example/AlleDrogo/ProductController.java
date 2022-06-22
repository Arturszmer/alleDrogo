package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    @ResponseBody
    Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/addProduct")
    void addProduct(@PathVariable String name, @PathVariable String description, @PathVariable Double price){
        productService.addProduct(new Product(name, description, price));
    }
}
