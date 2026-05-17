import java.util.*;

class Product {
    String name;
    double price;
    int quantity;

    public Product() {
        this.name = "unknown";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public static double applyDiscount(double total) {
        if (total > 500) {
            return total *0.85;
        } else if ( total > 200) {
            return total *0.90;
        } else if ( total > 100) {
            return total*0.95;
        }
        return total;
    }

    public void displayProduct() {
        System.out.println(name+ " PRICE: ₹"+price+ " QUANTITY: "+quantity+ " TOTAL: ₹"+ getTotalCost());
    }
}

public class ecommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p1 = new Product("Laptop", 65000, 1);
        Product p2 = new Product("Key-board", 1500, 1);

        ArrayList<Product> cart = new ArrayList<>();
        cart.add(p1);
        cart.add(p2);

        while(true) {
            System.out.print("Enter name : ");
            String name = sc.nextLine();
            System.out.print("Enter price : ");
            double price= sc.nextDouble();
            System.out.print("Enter quantity : ");
            int quantity = sc.nextInt();

            Product userProduct = new Product(name, price, quantity);

            cart.add(userProduct);

            System.out.println("Order Summary");
            double total = 0;
            for( Product p : cart) {
                p.displayProduct();
                total += p.getTotalCost();
            }

            double FinalCost = Product.applyDiscount(total);

            System.out.println("Before: "+ total);
            System.out.println("After: "+ FinalCost);

            System.out.println("to continue (Y/N)");
            char choice = sc.next().charAt(0);
            if (choice == 'N') {
                System.out.println("exiting");
                break;
            }
            sc.nextLine();
        }
        sc.close();
    }
}
