import java.util.*;
import java.sql.*;

public class StudentManagement {
    static final String URL = "jdbc:mysql://localhost:3306/vidyarthi";
    static final String ROOT = "root";
    static final String PASSWORD = "pratik";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            Connection con = DriverManager.getConnection(URL,ROOT,PASSWORD);
            while(true) {
                System.out.println("===========STUDENT MANAGEMENT============");
                System.out.println("1.ADD   2.VIEW   3.UPDATE   4.DELETE   5.EXIT");
                System.out.print("Enter your choice : ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter id : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter percent : ");
                        double percent = sc.nextDouble();
                        String insert = "INSERT INTO student VALUES(?,?,?)";
                        PreparedStatement ps1 = con.prepareStatement(insert);
                        ps1.setInt(1,id);
                        ps1.setString(2,name);
                        ps1.setDouble(3,percent);
                        ps1.executeUpdate();
                        System.out.println("Student added");
                        break;
                    case 2:
                        String select = "SELECT * FROM student";
                        PreparedStatement ps2 = con.prepareStatement(select);
                        ResultSet rs = ps2.executeQuery();
                        while(rs.next()) {
                            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
                        }
                        break;
                    case 3:
                        System.out.print("Enter id : ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name : ");
                        String uname = sc.nextLine();
                        System.out.print("Enter new percet : ");
                        double upercent = sc.nextDouble();
                        String update = "UPDATE student SET name=?, percent=? WHERE id=?";
                        PreparedStatement ps3 = con.prepareStatement(update);
                        ps3.setString(1,uname);
                        ps3.setDouble(2,upercent);
                        ps3.setInt(3,uid);
                        ps3.executeUpdate();
                        System.out.println("Student details updated");
                        break;
                    case 4:
                        System.out.print("Enter id : ");
                        int did = sc.nextInt();
                        String delete = "DELETE FROM student WHERE id=?";
                        PreparedStatement ps4 = con.prepareStatement(delete);
                        ps4.setInt(1,did);
                        ps4.executeUpdate();
                        break;
                    case 5:
                        System.out.println("Exiting....");
                        con.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice !");
                }
            }
        } catch(Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
