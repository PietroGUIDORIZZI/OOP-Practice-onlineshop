package model;

import java.util.Scanner;

public class OnlineShopping {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();

        User user = new User("Pietro");

        boolean shopping = true;

        System.out.println("\nWelcome, " + user.getName());
        while (shopping) {
            shop.displayProduct();

            System.out.println("\n1. Add to Cart\n2. Remove from Cart\n3. View Cart\n4. Checkout\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter product id to add: ");
                    String productId = scanner.nextLine();
                    Product p = shop.findProductById(productId);

                    if(null != p ) {
                        System.out.println("Enter quantity to add: ");
                        int quantity = scanner.nextInt();
                        user.getCart().addProduct(p, quantity);
                    }else {
                        System.out.println("Product not found! ");
                    }

                    break;

                case 2:
                    System.out.println("Enter product id: ");
                    String removeId = scanner.nextLine();

                    System.out.println("Enter quantity to be removed: ");
                    int removeQty = scanner.nextInt();
                    scanner.nextLine();

                    user.getCart().removeProduct(removeId, removeQty);
                    break;

                case 3:
                    user.getCart().displayCart();
                    break;

                case 4:
                    double cost = user.getCart().calcTotalCost();
                    System.out.println("Total Amount to be paid: $" + cost);
                    System.out.println("Thank you for Shopping");
                    shopping = false;
                    break;

                case 5:
                    shopping = false;
                    break;

                default:
                    System.out.println("Invalid Choice, Please try again.");




            }
        }

    }
}
