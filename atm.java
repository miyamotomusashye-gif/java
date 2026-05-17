import java.util.*;

class ATM {
    double balance = 1000;

    void checkBalance() {
        System.out.println("Balance : "+balance);
    }

    void deposite(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount to deposite !");
            } else {
                balance += amount;
                System.out.println("Deposited !  current balance : "+ balance);
            }
            System.out.println("Transaction successfull");
        } catch (IllegalArgumentException e) {
            System.out.println("Error : "+ e.getMessage());
        }
    }

    void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount to withdraw !");
            } else if (amount > balance) {
                throw new ArithmeticException("Insufficient balance !");
            } else {
                System.out.println("Withdrawn! current balance : "+balance);
                balance -= amount;
            }
            System.out.println("Transaction successfull");
        } catch (IllegalArgumentException e)  {
            System.out.println("Error : "+e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error : "+ e.getMessage());
        }
    }
} 
 
public class atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ATM user = new ATM();

        int choice;

        do {
            System.out.println("ATM");
            System.out.println("1.CHECK 2.DEPOSITE 3.WITHDRAW 4.EXIT");
            System.out.print("enter your choice (1,2,3,4): ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    user.checkBalance();
                    break;
                case 2:
                    System.out.print("enter amout to deposite : ");
                    user.deposite(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("enter amount to withdraw : ");
                    user.withdraw(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("Invalid choice !");
            }
        } while (choice != 4);
    }
}
