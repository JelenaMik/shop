import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Build a shop
//Possible to add customers +
//possible to add products +
//possible to buy products+
//possible to see sales +
//Products quantity should reduce in shop once bought+
//customers will have a balance that gets reduced based on product the buy and quantity+
//should show error if not enough money or product



public class Product {
    public int id;
    public String name;
    public int amount;
    public double price;
    public double sale;
    public int availability;

    Scanner scanner = new Scanner(System.in);
    Scanner intscanner = new Scanner(System.in);

    public ArrayList<Product> products = new ArrayList<>();

    public Product() {
    }

    public Product(int id, String name, int amount, double price, double sale){
        this.id = id;
        this.name=name;
        this.amount=amount;
        this.price=price;
        this.sale=sale;
    }

    public Product(int id) {
        this.id = id;
    }

    public void defaultProducts(){
        Product milk = new Product(products.size(), "milk", 20, 1.1, 20);
        this.products.add(milk);
        Product coffee = new Product(products.size(), "coffee", 100, 11.99, 0);
        this.products.add(coffee);
        Product bread = new Product(products.size(), "bread", 50, 0.89, 10);
        this.products.add(bread);
        Product officePaper = new Product(products.size(),"Office Paper", 500, 5.54, 0);
        this.products.add(officePaper);
    }

    public void addProduct() {

        Product product = new Product();

        product.id=products.size();
        System.out.println("Product ID was set to " + product.id + "!");
        product.name = JOptionPane.showInputDialog("Please input the product name!" );
        product.amount = Integer.parseInt(JOptionPane.showInputDialog("Please input available amount of product"));
        product.price = Double.parseDouble(JOptionPane.showInputDialog("Please input a price of product"));
        product.sale = Double.parseDouble(JOptionPane.showInputDialog("Please input a price reduction in percents if product is on sale!"));


        this.products.add(product);
        JOptionPane.showMessageDialog(null, "Product " + product.name + " added successfully!");
        System.out.println("Product " + product.name + " added successfully!");


    }


    public void seeAllProducts(){
        for (Product product : products){
            System.out.println(product);
        }
    }

public int availableAmount(int productToBuy, int amountToBuy){
    availability = 0;
    Product selectedProduct = products.get(productToBuy);
    if (selectedProduct.amount>=amountToBuy){
        availability=1;
    }
    return availability;
}


    public void reduceAmountOfProduct(int amountToBuy, int productToBuy){
        for (Product product: products) {
            if (product.id==productToBuy) {
                product.amount -=amountToBuy;
                break;
            }
        }
    }

    public double getPriceOfSelectedProduct(int productToBuy, int amountToBuy){
        Product selectedProduct = products.get(productToBuy);
        double totalPrice = selectedProduct.price* (1-selectedProduct.sale/100)*amountToBuy;
        return totalPrice;
    }

    public String seeSales(){

        System.out.println("Products on sale:");
        for (Product product: products){
            if (product.sale>0){
                System.out.println(product.name);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Product{" + "Id: " + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", sale=" + sale +
                '}';
    }
}
