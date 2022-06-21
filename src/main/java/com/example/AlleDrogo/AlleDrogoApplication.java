package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class
AlleDrogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlleDrogoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService){
		return args -> {
//			productService.addProduct(new Product
//					("Gitara Fender Stratocaster",
//					"Gitara elektryczna wyprodukowana w 2009 roku",
//					8500));
//			productService.addProduct(new Product
//					("Gitara Gibson Les Paul",
//					"Gitara elektryczna wyprodukowana w 1999 roku",
//					12000));
		};
	}

}
