package com.menora.controller;

import com.menora.bl.ProductsManager;
import com.menora.data.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ProductsController {

    private final ProductsManager productsManager;

    @GetMapping("/products/{insuredId}")
    public Map<String, List<Product>> getProductsOfInsured(@PathVariable String insuredId) {
        return productsManager.getProductsOfInsure(insuredId);
    }
}
