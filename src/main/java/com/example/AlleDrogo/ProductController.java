package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    String index(){
        return "index";
    }


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProducts")
    @ResponseBody
    Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }
}
