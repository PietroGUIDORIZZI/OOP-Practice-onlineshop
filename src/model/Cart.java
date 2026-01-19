package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    //add product
    public void addProduct(Product product, int quantity) {
        boolean found = false;
        for(Product productObject: products) {
            if(productObject.getId().equals(product.getId())) {
                productObject.setQuantity(productObject.getQuantity() + quantity);
                found = true;

                System.out.println(quantity + " " + product.getName() + "(s) added to your cart. New quantity is " + productObject.getQuantity());
                break;
            }
        }

        if(!found) {
            product.setQuantity(quantity);
            products.add(product);
            System.out.println(quantity + " " + product.getName() + "(s) added to your cart.");
        }
    }

    //remove product
    public void removeProduct(String productId, int quantity) {
        for(Product p : products) {
            if (p.getId().equals(productId)) {
                if(p.getQuantity() > quantity) {
                    p.setQuantity(p.getQuantity() - quantity);
                    System.out.println(quantity + " " + p.getName() + "(s) removed from your cart. Remaining quantity is " + p.getQuantity());
                }else {
                    products.remove(p);
                    System.out.println(p.getName() + " removed from your cart!");
                }
                break;
            }
        }
    }

    //display product
    public void displayCart() {
        System.out.println("Cart Items:  ");
        for (Product p : products) {
            p.displayProduct();
        }
    }

    //total cost calc
    public double calcTotalCost() {
        double totalCost = 0;

        for (Product p : products) {
            totalCost += p.getPrice() * p.getQuantity();
        }

        return totalCost;
    }
}
