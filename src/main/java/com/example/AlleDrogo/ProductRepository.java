package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    void deleteProductById(String name);

    Optional <Product> findProductById(String name);
}
