import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Welcome to the shop!");
        JOptionPane.showMessageDialog(null, "Welcome to the shop!");

        Scanner scanner = new Scanner(System.in);
        Scanner intscanner = new Scanner(System.in);
        Product product = new Product();
        product.defaultProducts();
        Customer customer = new Customer();
        customer.defaultCustomers();

        String input ="";

        do{
            System.out.println("""
                    
                    1. Add a product
                    2. List all available products
                    3. See products on sale
                    4. Add customer
                    5. See all customers
                    6. Buy product
                    
                    """
            );

            input = scanner.nextLine();


            switch(input){
                case "1":
                    product.addProduct();
                    break;
                case "2":
                    product.seeAllProducts();
                    break;
                case "3":
                    product.seeSales();
                    break;
                case "4":
                    customer.addCustomer();
                    break;
                case "5":
                    customer.seeAllCustomers();
                    break;
                case "6":

                    int amountToBuy = 0;
                    int productToBuy;
                    String customerName = "";
                    double totalPrice;

                    System.out.println("Enter an Id of product you want to buy!");
                    productToBuy = intscanner.nextInt();
                    System.out.println("Enter an amount of product you want to buy!");
                    amountToBuy = intscanner.nextInt();

                    totalPrice= product.getPriceOfSelectedProduct(productToBuy, amountToBuy);
                    int available = product.availableAmount(productToBuy, amountToBuy);
                    if (available==0){
                        System.out.println("Requested amount is not available");
                        break;
                    }

                    System.out.println("Enter customer name!");
                    customerName = scanner.nextLine();

                    int balanceCheck = customer.checkBalance(customerName, totalPrice);
                    if (balanceCheck==0) {
                        System.out.println(customerName + " don't have enough money for this purchase!");
                        break;
                    }
                    product.reduceAmountOfProduct(amountToBuy, productToBuy);
                    customer.reduceBalance(customerName, totalPrice);
                    System.out.println("Product purchased successfully!");

                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }

        }while(!input.equalsIgnoreCase("quit"));

    }
}
