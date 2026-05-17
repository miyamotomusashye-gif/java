import java.util.*;

public class advancecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {

            try {
                System.out.println("=================CALCULATOR==================");
                System.out.println("1.ADD   2.SUB   3.MULT   4.DIV   5.EXIT");
                System.out.print("Enter your choice : ");
                int choice = sc.nextInt();

                if (choice == 5) {
                    System.out.println("Exiting...");
                    break;
                }

                if (choice < 1 || choice > 4) {
                    throw new IllegalArgumentException("Invalid choice");
                }


                System.out.print("Enter num 1: ");
                double num1 = sc.nextDouble();
                System.out.print("Enter num 2: ");
                double num2 = sc.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("result : "+ (num1 + num2));
                        break;
                    case 2:
                        System.out.println("result : "+ (num1 - num2));
                        break;
                    case 3:
                        System.out.println("result : "+ (num1 * num2));
                        break;
                    case 4:
                        if (num2 == 0) {
                            throw new ArithmeticException("Divide by zero not allowed");
                        } else {
                            System.out.println("result : "+ (num1 / num2));
                        }
                        break;
                } 
            } catch (IllegalArgumentException e ) {
                System.out.println("Error : "+ e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error : "+ e.getMessage());
            }
            
        } 
    }
}
