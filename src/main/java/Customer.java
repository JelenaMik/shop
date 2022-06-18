import javax.swing.*;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer{

    public String name;
    private double balance;
    public String productToBuy;
    public int amountToBuy;


    ArrayList<Customer> customers = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    Scanner intscanner = new Scanner(System.in);

   Customer(String name, double balance){
       this.name = name;
       this.balance = balance;
   }

    public double getBalance() {
        return balance;
    }

    public Customer() {
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addCustomer() {

            Customer customer = new Customer();

            System.out.println("Enter customer name!");
            customer.name = scanner.nextLine();
            System.out.println("Please enter balance of customer");
            customer.balance = intscanner.nextDouble();

            this.customers.add(customer);
        //JOptionPane.showMessageDialog(null, "Customer " + customer.name + " added successfully!");
            System.out.println("Customer " + customer.name + " added successfully!");
   }

    public void defaultCustomers(){
        Customer Anna = new Customer("Anna", 2000);
        this.customers.add(Anna);
        Customer Lauris = new Customer("Lauris", 150);
        this.customers.add(Lauris);
        Customer John = new Customer("John", 785);
        this.customers.add(John);
    }

    public void seeAllCustomers(){
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }

    public int checkBalance(String customerName, double totalPrice){
       int temporary = 0;
        for (Customer customer: customers) {
            if (customer.name.equals(customerName)) {
                if (customer.balance>=totalPrice){
                    temporary=1;
                    break;
                }
            }
        }
        return temporary;
    }

    public void reduceBalance(String customerName, double totalPrice) {
        for (Customer customer : customers) {
            if (customer.name.equals(customerName)) {
                double newBalance= customer.balance - totalPrice;
                customer.setBalance(newBalance);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' + ", balance: " + getBalance() +
                '}';
    }
}


