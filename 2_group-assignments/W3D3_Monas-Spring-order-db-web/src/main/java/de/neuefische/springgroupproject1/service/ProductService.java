package de.neuefische.springgroupproject1.service;

import de.neuefische.springgroupproject1.db.ProductDB;
import de.neuefische.springgroupproject1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private final ProductDB productDB;

    @Autowired
    public ProductService(ProductDB productDB){
        this.productDB = productDB;
    }

    public List<Product> getProductList(String query) {
        if (query == null) {
            return productDB.getProductList();
        } else {
            List<Product> matchingProducts = new ArrayList<>();

            List<Product> productList = productDB.getProductList();
            for (Product product : productList) {
                if(product.getName().toLowerCase().startsWith(query.toLowerCase())){
                    matchingProducts.add(product);
                }
            }
            return matchingProducts;
        }
    }

}
