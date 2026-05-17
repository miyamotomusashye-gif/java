import java.util.*;

class Hotel {
    static int floor = 3;
    static int room = 4;
    static int[][] hotel = new int[floor][room];

    static void displayRoom() {
        System.out.println("Room Status");
        System.out.println("[1=Booked | 0=empty]");
        for (int i = 0; i < hotel.length; i++) {
            System.out.print("Floor "+ (i + 1)+ ": " );
        for (int j = 0; j < hotel.length; j++) {
            System.out.print(hotel[i][j] + " " );
        }
        System.out.println();
        }
    }
    
    static void bookRoom(int floor, int room) {
        if (hotel[floor][room] == 0) {
            hotel[floor][room] = 1;
            System.out.println("Room booked successfully");
        } else {
            System.out.println("Room already booked");
        }   
    }
    
    static void checkoutRoom(int floor, int room) {
        if (hotel[floor][room] == 1) {
            hotel[floor][room] = 0;
            System.out.println("Checkout successfully");
        } else {
            System.out.println("Room already available");
        }    
    }
}

public class Emperial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do{
            // System.out.println("---------------------------------------------------------------");
            System.out.println("=========================HOTEL EMPERIAL BOOKING=====================");
            System.out.println("1.VIEW ROOMS  2.BOOK ROOM  3.CHECKOUT  4.EXIT");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Hotel.displayRoom();
                    break;
                case 2:
                    System.out.print("Floor (1-3) : ");
                    int Floorno = sc.nextInt() -1;
                    System.out.print("Room (1-4) : ");
                    int roomno = sc.nextInt() -1;
                    if (Floorno >= 0 && Floorno < 2 && roomno >= 0 && roomno < 3) {
                        Hotel.bookRoom(Floorno, roomno);
                    } else { System.out.println("Invalid room number"); }
                    break;
                case 3:
                    System.out.print("Floor (1-3) : ");
                    int floorno = sc.nextInt() -1;
                    System.out.print("Room (1-4) : ");
                    int roomo = sc.nextInt() -1;
                    if ( floorno >= 0 && floorno < 2 && roomo >=0 && roomo < 3) {
                        Hotel.checkoutRoom(floorno, roomo);
                    } else { System.out.println("Invalid room number"); }
                    break;
                case 4:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4 );
        sc.close();
    }
}
