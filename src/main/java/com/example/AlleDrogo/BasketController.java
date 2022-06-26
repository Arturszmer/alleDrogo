package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Order;
import com.example.AlleDrogo.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/add")
    void addProductToBasket(@PathVariable Product product){
        basketService.addProduct(product);
    }

    @GetMapping
    List<Product> basket(){
        return basketService.getBasket();
    }

    @PostMapping
    Order confirmBasket(@PathVariable String shipmentAddres){
        return basketService.confirmBasket(shipmentAddres);
    }

}
