package model;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
        loadProducts();
    }

    private void loadProducts() {
        products.add(new Product("p001", "Nike Shoes SB", 599.90, 1000));
        products.add(new Product("p002", "Vans Shoes OldSchool", 499.90, 1000));
        products.add(new Product("p003", "Puma Shoes Sport", 299.90, 1000));
    }

    public void displayProduct() {
        System.out.println("Available Products");
        for(Product p : products) {
            p.displayProduct();
        }
    }

    public Product findProductById(String id) {
        for(Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
